package edu.miracosta.cs113.lab4.model;

public class DirectoryEntry {
	private String name;
	private String number;

	public DirectoryEntry(String name, String number){
		if ( name == null || number == null ){
			throw new NullPointerException();
		}
		this.name = name;
		this.number = number;

	}

	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name = name;
	}

	public String getNumber(){
		return number;
	}

	public void setNumber(String number){
		this.number = number;

	}
	@Override
	public boolean equals(Object o) {
		if ( o == null || !(o instanceof DirectoryEntry)) {
			return false;
		}
		DirectoryEntry other = (DirectoryEntry) o;
		return other.name.equals(name) && other.number.equals(number);
		
		
	}
	@Override
	public String toString() {
		return "( "+name+" , "+number+" )";
	}
}

