package main;
import java.util.ArrayList;

import Matrix.*;
public class main {
	public static void main(String[] args) {
		
	TruthTable test1 = new TruthTable(2,2);
	for(int i = 0; i < test1.getSize().get(0); i++) {
		for(int j = 0; j < test1.getSize().get(1); j++) {
			test1.Table.get(i).set(j, "0");
		}
	}
	
	//WE ARE HAVING SOME FUCKING PROBLEM HERE, THE test1 SUPPOSE TO BE 2*2 MATRIX, BUT SOMEHOW ENDED UP 2*4 FUCKING HELL, SOMEONE PLEASE SEND HELP
	
	System.out.println(test1.getTable());
	System.out.println(test1.NegateTable());	
	}
}
