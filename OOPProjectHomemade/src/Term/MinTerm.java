package Term;

import java.util.ArrayList;

public class MinTerm extends Term {
	
	private int name;
	
	public MinTerm(ArrayList<String> bitVals) {
		this.bitValues = bitVals;
		String strBitVal = "";
		for (int i = 0; i < bitVals.size(); i ++) {
			strBitVal += bitVals.get(i);
		}
		this.name = Integer.parseInt(strBitVal, 2);
	}
	
	public int getNameInt() {
		return name;
	}
	
	public String getName() {
        return String.valueOf(name);
    }
	
	public static void  main(String[] args) {
		ArrayList<String> bitVals = new ArrayList<String>();
		bitVals.add("0");
		bitVals.add("0");
		bitVals.add("1");
		bitVals.add("0");
		MinTerm t = new MinTerm(bitVals);
		System.out.println(t.getNameInt());
	}
}
