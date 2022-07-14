package com.projetoISO;

import org.jpos.iso.ISOUtil;

public class Teste {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String nome = "DANILO1";

		System.out.println(!isCartaoComChip(3));
		int restoDivisao = nome.length() % 2;
		
		if(restoDivisao > 0) {
			System.out.println("resto da divisão " + restoDivisao);
		}else {
			System.out.println("não tem resto de divisão "+ restoDivisao);
		}
		
	}

	private static boolean isCartaoComChip(int smart) {
		return smart ==1 || smart == 3;
	}
}
