package Term;

import java.util.ArrayList;

public abstract class Term {
	protected ArrayList<String> bitValues = new ArrayList<String>();
	public abstract String getName();
	
	public boolean compareTerm(Term t) {
		int count = 0;
		for (int i = 0; i < t.getBitValues().size(); i ++) {
			if (!this.bitValues.get(i).equals(t.getBitValues().get(i))) count++;
		}
		return count == 1;
	}
	public ArrayList<String> getBitValues() {
		return bitValues;
	}
	public ArrayList<String> getImplicant(){
		ArrayList<String> implicant = new ArrayList<String>();
		for(int i=0; i<bitValues.size(); i++) {
			String element = this.getImplicantHelper(i, bitValues.get(i));
			if(! element.isEmpty()) {
				implicant.add(element);
			}
		}
		return implicant;
		
	}
	
	private String getImplicantHelper(int idx, String bit) {
		String str = new String();
		switch(idx) {
		case 0:
			if(bit.equals("0")) {
				str = "Ac";
			}else if(bit.equals("1")){
				str = "A";
			}else {
				str = "";
			}
			break;
		case 1:
			if(bit.equals("0")) {
				str = "Bc";
			}else if(bit.equals("1")){
				str = "B";
			}else {
				str = "";
			}
			break;
		case 2:
			if(bit.equals("0")) {
				str = "Cc";
			}else if(bit.equals("1")){
				str = "C";
			}else {
				str = "";
			}
			break;
		case 3:
			if(bit.equals("0")) {
				str = "Dc";
			}else if(bit.equals("1")){
				str = "D";
			}else {
				str = "";
			}
			break;
		}
		return str;
	}
}
