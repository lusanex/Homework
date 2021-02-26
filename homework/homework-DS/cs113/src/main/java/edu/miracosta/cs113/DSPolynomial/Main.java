/*
 * Copyright (c) 2002-2020, the original author or authors.
 *
 * This software is distributable under the BSD license. See the terms of the
 * BSD license in the documentation provided with this software.
 *
 * https://opensource.org/licenses/BSD-3-Clause
 */
package edu.miracosta.cs113.DSPolynomial;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.io.File;
import java.util.regex.*;

import org.jline.builtins.*;
import org.jline.builtins.Completers.TreeCompleter;
import org.jline.builtins.Options.HelpException;
import org.jline.keymap.BindingReader;
import org.jline.keymap.KeyMap;
import org.jline.reader.*;
import org.jline.reader.LineReader.Option;
import org.jline.reader.impl.DefaultParser;
import org.jline.reader.impl.DefaultParser.Bracket;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.terminal.*;
import org.jline.utils.*;
import org.jline.utils.InfoCmp.Capability;
import org.jline.reader.impl.BufferImpl;

import static java.time.temporal.ChronoField.HOUR_OF_DAY;
import static java.time.temporal.ChronoField.MINUTE_OF_HOUR;
import static org.jline.builtins.Completers.TreeCompleter.node;
import static org.jline.keymap.KeyMap.ctrl;
import static org.jline.keymap.KeyMap.key;


public class Main 
{
	
    public static void usage() {
        String[] usage = {
                "Usage: java " + Main.class.getName() + "\n"
              , "    This program adds two polynomials of the form"
              , "    mx^n + mn^n-1 + mn^n-2 ... ... m\n"
              , "    Example:\n" 
              , "    -23x^4 + 2x^3 + 3x^2 + 7x + 12 \n"
              , "    To display available commands type help\n" 
	       };
        for (String u: usage) {
            System.out.println(u);
        }
    }

    public static void help() {
        String[] help = {
            "List of available commands:" , "  Builtin:"
          , "    cls        clear screen"
          , "    help       list available commands"
	  , "    exit       exit from poly-calc app"
	  , "                                      "
          , "  Application Commands:\n"
          , "    edit       --first-poly, --second-poly"
          , "               Edits the first or second polynomial expresion\n"
          , "    show       --first-poly, --second-poly, --polys, --sum\n"  	     
	  , "                                                                       "
          , "               --first-poly, --second-poly"
          , "                  Shows the expression of the first or second polynomial" 
	  , "                  to the stdoutput.                                    "
	  , "                                                                       "
	  , "               --polys                                                 "
	  , "                  Shows both polynomial expressions to the stdoutput   "
	  , "                                                                       "
	  , "               --sum                                                   "
	  , "                  calculates the sum of the two polynomial expresions  "
	  , "                  and displays the result to the stdoutput.            "
	  , "                                                                       "
	  , "                                                                       "
	  , "                                                                       "
	  , "                                                                       "
	  };
        for (String u: help) {
            System.out.println(u);
        }

    }
    public static void helpPolys() {
        String[] help = {
            "List of available commands:\n"
          , "    clear      wipes the data of the selected polynomial               \n"
          , "    add        adds a new Term to the selected polynomial               \n" 
	  , "    edit       edits the current polynomial                            \n"
	  , "    help       shows the current help                                  \n"
	  , "                                                                       "
	  , "                                                                       "
	  , "                                                                       "
	  };
        for (String u: help) {
            System.out.println(u);
        }

    }

    private static void doOption(Polynomial poly, String opt, Terminal terminal , LineReader lineRead){


	    switch(opt){
		    case "clear":
			    String ans = lineRead.readLine(
					    "Delete the current Polynomial y/n? ");
			    if ("yes".contains(ans.toLowerCase())){
			           poly.clear();
			    	   terminal.writer().println(
                            	        AttributedString.fromAnsi(
				        "\u001B[31m==>\u001B\"" + 
					"Polynomial was deleted"+ "\"[0m")
                                	.toAnsi(terminal));
				    return;
			    }
			    terminal.writer().println(
                            AttributedString.fromAnsi("\u001B[32m==>\u001B\"" 
				    + "Operation aborted"+ "\"[0m")
                                .toAnsi(terminal));
			    break;

		    case "add":

			    lineRead.printAbove("Add a term example: 2x^2 or -x"); 
			    String s = lineRead.readLine(">> ");
			    try {

			    	poly.addTerm(new Term(s));

				terminal.writer().println(
				    AttributedString.fromAnsi("\u001B[32m==>\u001B\"" 
					+ "Term added: "+ s+ "\"[0m")
					.toAnsi(terminal));

			    }
			    catch(Exception e){
				    
				terminal.writer().println(
				    AttributedString.fromAnsi("\u001B[31m==>\u001B\"" 
					+ "Illegal Term "+ s+ "\"[0m")
					.toAnsi(terminal));


			    }



			    break;

		    case "edit":
			    
			    Polynomial oldPoly = new Polynomial(poly);
			    poly.clear();
			    List<Tuples> indexListTerms;
			    List<String> listTerms; 
			    lineRead.printAbove(
			      "Actual Polynomial: "+ oldPoly.toString() + "\n" 
			      +"press ↑ key to edit the old polynomial or type a new one\n"
			      + "\nExample of polynomial: 2x^2 + x^5 + 23\n\n");
			    History hs = lineRead.getHistory();
			    hs.add(oldPoly.toString());
			    String p = lineRead.readLine(">> ");
			    p = p.replaceAll(" ","");
			    indexListTerms = regex(p);
			    //System.out.println(indexListTerms + " "+p.replaceAll(" ",""));

			    if ( indexListTerms.size() == 0 ){

				    restoreOldPoly(poly,oldPoly);
				    terminal.writer().println(
				    AttributedString.fromAnsi(
					 "\u001B[31m==>\u001B\"" 
					 + " Illegal Polynomial Expression " + p 
					 + "\"[0m").toAnsi(terminal));
				    return;

			    }
			    else {

				    listTerms = parsePolyExpression(indexListTerms
						    ,p);

				    for ( int i = 0 ; i < listTerms.size();i++ ){
					    try {
						    //System.out.println(listTerms.get(i));
						    poly.addTerm(new Term(listTerms
							          .get(i)));
					    }
					    catch(Exception e){
						    poly.clear();
						    //e.printStackTrace();
						    restoreOldPoly(poly,oldPoly);   
				    		    terminal.writer()
						   	.println(AttributedString
						   	.fromAnsi("\u001B[31m==>\u001B\"" 
						   	+ " Illegal Polynomial Expression " 
							+ listTerms.get(i) 
						   	+ "\"[0m").toAnsi(terminal));
							return;
							
					    }

				    }

				    //poly = new Polynomial(temp);
			    	    terminal.writer().println(AttributedString
					    .fromAnsi("\u001B[32m==>\u001B\"" 
					    + poly.toString()+ "\"[0m")
					    .toAnsi(terminal));
			    }
			    break;


	    }


    }
    
    private static void restoreOldPoly(Polynomial newPoly , Polynomial oldData){

	    for ( int j   = 0 ; j < oldData.getNumTerms() ; j++ ){
		    newPoly.addTerm( oldData.getTerm(j));
	    }

    }


    private static ArrayList<Tuples> regex(String poly){
	    //poly = poly.replaceAll(" ","");
	    ArrayList<Tuples> tuples = new ArrayList<>();
	    Pattern p = Pattern.compile("[+-]{1,}");
	    Matcher m = p.matcher(poly);
	    while(m.find()){
		    tuples.add(new Tuples(m.start(),m.end()));
	    }
	    if ( tuples.size() > 1 ){
		    return tuples;
	    }
	    else {
		    return tuples;
	    }

    }

    private static List<String> parsePolyExpression(List<Tuples> tuples
		    ,String polyExpression){
	    List<String> termList = new ArrayList<>();
	    int size = tuples.size();
	    int i = 0;
	    if ( size == 0 ){
		    return termList;
	    }

	    if ( tuples.get(0).start == 0 ) {
		    termList.add(polyExpression.substring(0,tuples.get(1).end-1));
		    i = 1;
		    size = size -1;
	    	    for (; i < size ; i++ ){
		    	termList.add(polyExpression
					.substring(tuples.get(i).start
						,tuples.get(i+1).end-1));
	    	    }
	    }
	    else {
		    termList.add(polyExpression.substring(0,tuples.get(0).start));
		    for ( ; i < size;i++ ){
			    if ( i == size -1 ){
				    termList.add(polyExpression
						    .substring(tuples.get(i).start
							   ,polyExpression.length()));
				    break;
			    }
			    termList.add(polyExpression.substring(tuples.get(i).start
						    ,tuples.get(i+1).end-1));
		    }

	    }
	    return termList;
    }



    private static class Tuples{
	    public int start;
	    public int end;
	    Tuples(int start , int end){
		    this.start = start;
		    this.end = end;
	    }
	    public String toString() {
		    return "["+start+","+ end+"]";
	    }
	    
    }
   



    private static class OptionSelector {

        private enum Operation {FORWARD_ONE_LINE, BACKWARD_ONE_LINE, EXIT}
        private final Terminal terminal;
        private final List<String> lines = new ArrayList<>();
        private final Size size = new Size();
        private final BindingReader bindingReader;

        public OptionSelector(Terminal terminal, String title
			,Collection<String> options) {
            this.terminal = terminal;
            this.bindingReader = new BindingReader(terminal.reader());
            lines.add(title);
	    lines.add("Select an option using ↓ ↑ keys or ctrl-e | ctrl-y (press enter) > ");
            lines.addAll(options);
        }

        private List<AttributedString> displayLines(int cursorRow) {
            List<AttributedString> out = new ArrayList<>();
            int i = 0;
            for (String s : lines) {
               if (i == cursorRow) {
                   out.add(new AttributedStringBuilder()
				   .append(s, AttributedStyle.INVERSE)
				   .toAttributedString());
               } else {
                   out.add(new AttributedString(s));
               }
               i++;
            }
            return out;
        }

        private void bindKeys(KeyMap<Operation> map) {
            map.bind(Operation.FORWARD_ONE_LINE, "e", ctrl('E')
			    ,key(terminal, Capability.key_down));
            map.bind(Operation.BACKWARD_ONE_LINE, "y", ctrl('Y')
			    , key(terminal, Capability.key_up));
            map.bind(Operation.EXIT,"\r");
        }

        public String select() {
            Display display = new Display(terminal, true);
            Attributes attr = terminal.enterRawMode();
            try {
                terminal.puts(Capability.enter_ca_mode);
                terminal.puts(Capability.keypad_xmit);
                terminal.writer().flush();
                size.copy(terminal.getSize());
                display.clear();
                display.reset();
                int selectRow = 2;
                KeyMap<Operation> keyMap = new KeyMap<>();
                bindKeys(keyMap);
                while (true) {
                    display.resize(size.getRows(), size.getColumns());
                    display.update(displayLines(selectRow)
				    ,size.cursorPos(0, lines.get(0).length()));
                    Operation op = bindingReader.readBinding(keyMap);
                    switch(op) {
                        case FORWARD_ONE_LINE:
                            selectRow++;
                            if (selectRow > lines.size() - 1) {
                                selectRow = 2;
                            }
                            break;
                        case BACKWARD_ONE_LINE:
                            selectRow--;
                            if (selectRow < 2) {
                                selectRow = lines.size() - 1;
                            }
                            break;
                        case EXIT:
                            return lines.get(selectRow);
                    }
                }
			
            } finally {
                terminal.setAttributes(attr);
                terminal.puts(Capability.exit_ca_mode);
                terminal.puts(Capability.keypad_local);
                terminal.writer().flush();
            }
        }
    }

    private static LineReader initReadLine(Completer completer,Parser parser, 
		    String prompt ,String rightPrompt, Terminal terminal){

	    completer = new TreeCompleter(
			        node("edit",
					node("--first-poly"),
					node("--second-poly")
				     ),
				node("show",
					node("--first-poly"),
					node("--second-poly"),
					node("--polys"),
					node("--sum"))
					    );

	    
	  LineReader lineReader = LineReaderBuilder.builder()
                    .terminal(terminal)
                    .completer(completer)
                    .parser(parser)
                    .variable(LineReader.SECONDARY_PROMPT_PATTERN, "%M%P > ")
                    .variable(LineReader.INDENTATION, 2)
                    .option(Option.INSERT_BRACKET, true)
                    .build();

	  return lineReader;




    }


    public static void doCommand(LineReader reader, Terminal terminal,
		    String prompt, String rightPrompt){

	    Polynomial firstPoly = new Polynomial();
	    Polynomial secondPoly = new Polynomial();
	    boolean color = true;

            while (true) {
                String line = null;
		List<String> words = null;
		
                try {
                    line = reader.readLine(prompt, rightPrompt
				    ,(MaskingCallback) null, null);
                    line = line.trim();

                    if (color) {
                        terminal.writer().println(
                            AttributedString.fromAnsi(
				    "\u001B[33m==>\u001B[0m\"" + line + "\"")
                                    .toAnsi(terminal));

                    } else {
                        terminal.writer().println("==>\"" + line + "\"");
                    }
                    terminal.flush();

                   if (line.equalsIgnoreCase("quit") || line.equalsIgnoreCase("exit")) 			   {
                        break;
                    }
                    ParsedLine pl = reader.getParser().parse(line, 0);
		    words = pl.words();
		    String sentinel = "";
		    if ( words.size() >= 2 ){
			    sentinel = words.get(0) + " "+ words.get(1);
		    }
		    
                    String[] argv = pl.words().subList(1, 
				    pl.words().size()).toArray(new String[0]);
                    //System.out.println("argv[] "+argv[0]);
                    if ("cls".equals(pl.word())) {
                        terminal.puts(Capability.clear_screen);
                        terminal.flush();
                    }
                    else if ("history".equals(pl.word())) {
                        Commands.history(reader, System.out, System.err, Paths.get("")
					,argv);
                    }
                    else if ("help".equals(pl.word()) || "?".equals(pl.word())) {
                        help();
                    }
                    else if ( "edit --first-poly".equals(sentinel) ) {
                        OptionSelector selector = new OptionSelector(
					terminal, "First polynomial: " + firstPoly 
                                        ,Arrays.asList("edit","clear", "add", "help"
						,"exit"));
                        String selected = selector.select();
			if ( selected.equals("help") ){
				helpPolys();
			}
			doOption(firstPoly,selected,terminal,reader);
                        System.out.println("First polynomial: "+firstPoly.toString());
                    }
		    else if ( "edit --second-poly".equals(sentinel) ) {
                        OptionSelector selector = new OptionSelector(
					terminal, "Second polynomial: " + secondPoly 
                                        , Arrays.asList("edit","clear", "add"
				        , "help","exit"));
                        String selected = selector.select();

			if ( selected.equals("help") ){
				helpPolys();
			}
			doOption(secondPoly,selected,terminal,reader);
                        System.out.println("Second polynomial: " + secondPoly.toString());
                    }
		    else if ( "show --first-poly".equals(sentinel) ){

                        terminal.writer().println(
                            AttributedString.fromAnsi(
				    "\u001B[34mFirst polynomial: \u001B[0m\"" + firstPoly + "\"")
                                .toAnsi(terminal));
		    }
		    else if ( "show --second-poly".equals(sentinel) ){

                        terminal.writer().println(
                            AttributedString.fromAnsi(
				    "\u001B[34mSecond polynomial: \u001B[0m\"" + secondPoly+ "\"")
                                .toAnsi(terminal));
		    }
		    else if ( "show --polys".equals(sentinel) ){

                        terminal.writer().println(
                            AttributedString.fromAnsi(
				    "\u001B[34mFirst polynomial: \u001B[0m\"" + firstPoly+ "\"")
                                .toAnsi(terminal));
			
                        terminal.writer().println(
                            AttributedString.fromAnsi(
				    "\u001B[34mSecond polynomial: \u001B[0m\"" + secondPoly+ "\"")
                                .toAnsi(terminal));
		    }
		    //Law of Addition says that it doesn't matter what order 
		    //you add up numbers, you will always get the same answer. 
		    else if ( "show --sum".equals(sentinel) ){
			Polynomial sum = new Polynomial(firstPoly);
			sum.add(secondPoly);
                        terminal.writer().println(
                            AttributedString.fromAnsi(
				    "\u001B[34mSum of polynomials: \u001B[0m\"" 
				    + sum + "\"").toAnsi(terminal));
		    }
	
		    



                }
                catch (HelpException e) {
                    HelpException.highlight(e.getMessage(), HelpException.defaultStyle()).print(terminal);
                }
                catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
                catch (UserInterruptException e) {
                    // Ignore
                }
                catch (EndOfFileException e) {
                    return;
                } catch (Exception e) {
					e.printStackTrace();
				}
            }
      }

 
    private static String initPrompt(){

           String p = new AttributedStringBuilder()
                                .style(AttributedStyle.DEFAULT.background(
							AttributedStyle.CYAN))
                                .append("polynomial")
                                .style(AttributedStyle.DEFAULT)
                                .append("@calculator")
                                .style(AttributedStyle.DEFAULT.foreground(
							AttributedStyle.GREEN))
                                .append("\n==")
                                .style(AttributedStyle.DEFAULT)
                                .append("> ").toAnsi();
	   return p;
    }

    private static String initRightPrompt(){

            String r = new AttributedStringBuilder()
                                .style(AttributedStyle.DEFAULT.background(
							AttributedStyle.RED))
                                .append(LocalDate.now().format(
							DateTimeFormatter.ISO_DATE))
                                .append("\n")
                                .style(AttributedStyle.DEFAULT.foreground(
							AttributedStyle.RED 
							| AttributedStyle.BRIGHT))
                                .append(LocalTime.now().format(
							new DateTimeFormatterBuilder()
                                                .appendValue(HOUR_OF_DAY, 2)
                                                .appendLiteral(':')
                                                .appendValue(MINUTE_OF_HOUR, 2)
                                                .toFormatter()))
                                		.toAnsi();

	    return r;

    }

    


    public static void main(String[] args) throws IOException {
        try {
            String prompt  = initPrompt(); 
            String rightPrompt = initRightPrompt(); 
	    LineReader reader = null;


           TerminalBuilder builder = TerminalBuilder.builder();


            Completer completer = null;
            Parser parser = null;
 	    DefaultParser p2 = new DefaultParser();
            p2.setEofOnUnclosedBracket(Bracket.CURLY, Bracket.ROUND, Bracket.SQUARE);
            parser = p2;

	    Terminal terminal = builder.build();
	    reader = initReadLine(completer, parser, prompt, rightPrompt,terminal);


            usage();
            System.out.println(terminal.getName()+": "+terminal.getType());
            System.out.println("\nhelp: list available commands");

	    doCommand(reader,terminal,prompt,rightPrompt);

            	    
         	    
   	}
        catch (Throwable t) {
            t.printStackTrace();
        }

    }
}
