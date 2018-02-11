package com.yeq.initrac;

import java.util.Comparator;

public class Character {

	String name;
	int init;
	int dex; // Will be used to break ties
	
	public Character() {
		name = "";
		init = 0;
		dex = 0;
	}
	
	public int getDex() {
		return dex;
	}

	public void setDex(int dex) {
		this.dex = dex;
	}

	public Character(String n, int i, int d) {
		name = n;
		init = i;
		dex = d;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInit() {
		return init;
	}

	public void setInit(int init) {
		this.init = init;
	}

	@Override
	public String toString() {
		return String.format("%s: %s", name, init);
	}

}

class CharComparator implements Comparator<Character> {

	@Override
	public int compare(Character o1, Character o2) {
		// TODO Auto-generated method stub
		return Integer.compare(o1.getInit(), o2.getInit());
	}
	
}
