package table;

import java.util.ArrayList;

import term.MinTerm;
import term.Term;

public class Group {
	ArrayList<Term> groupMembers = new ArrayList<Term>();
	ArrayList<Integer> checked = new ArrayList<Integer>();
	
	public Group() {
		// TODO Auto-generated constructor stub
	}
	
	public void addTerm(Term t) {
		groupMembers.add(t);
		checked.add(0);
	}
	
	public ArrayList<Term> getGroupMembers() {
		return groupMembers;
	}
	
	public void check(Term t) {
		int i = groupMembers.indexOf(t);
		checked.set(i, 1);
	}
	
	public ArrayList<Integer> getChecked() {
		return checked;
	}
	
	public ArrayList<Term> getUnchecked() {
		ArrayList<Term> unchecked = new ArrayList<Term>();
		for (int i = 0; i < checked.size(); i ++) {
			if (checked.get(i) == 0) {
				unchecked.add(groupMembers.get(i));
			}
		}
		return unchecked;
	}
	
	public static void main(String[] args) {
		Group g = new Group();
		ArrayList<String> bitVals1 = new ArrayList<String>();
		bitVals1.add("0");
		bitVals1.add("0");
		bitVals1.add("1");
		bitVals1.add("0");
		MinTerm t1 = new MinTerm(bitVals1);
		ArrayList<String> bitVals2 = new ArrayList<String>();
		bitVals2.add("1");
		bitVals2.add("1");
		bitVals2.add("1");
		bitVals2.add("0");
		MinTerm t2 = new MinTerm(bitVals2);
		g.addTerm(t1);
		g.addTerm(t2);
		g.check(t1);
		System.out.println(g.getChecked());
	}
}
