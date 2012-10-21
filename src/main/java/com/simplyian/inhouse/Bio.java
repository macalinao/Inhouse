package com.simplyian.inhouse;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Hello world!
 *
 */
public class Bio {
	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			String number = br.readLine();

			int amount;
			try {
				amount = Integer.parseInt(number);
			} catch (Exception ex) {
				System.out.println("that's not a number");
				return;
			}
			
			boolean[] cheating = new boolean[amount];
			
			for (int i = 0; i < amount; i++) {
				String grades = br.readLine();
				String[] gra = grades.split(" ");
				if (gra.length < 5) {
					System.out.println("not enough grades");
					return;
				}
				
				int prefinal;
				try {
					prefinal = Integer.parseInt(gra[3]);
				} catch (Exception ex) {
					System.out.println("you are dum");
					return;
				}
				
				int dafinal = Integer.parseInt(gra[4]);
				
				boolean cheater = ((prefinal * 0.75) > dafinal);
				cheating[i] = cheater;
			}

			for (boolean c : cheating) {
				if (c) {
					System.out.println("CHEATER CHEATER PUMPKIN EATER");
				} else {
					System.out.println("THANK YOU FOR BEING A GOOD STUDENT");
				}
			}

		} catch (Exception ex) {
		}
	}
}
