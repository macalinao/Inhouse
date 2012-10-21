/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyian.inhouse;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author simplyianm
 */
public class HappyNumbers {
	private static int iterations;

	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			String num = br.readLine();
			happify(num);
			System.out.println("Happy Number in " + iterations + " steps");
		} catch (Exception ex) {
		}
	}

	private static void happify(String num) {
		if (iterations > 50) {
			System.out.println("):");
			System.exit(0);
		}
		
		iterations++;

		int result = 0;

		char[] parts = num.toCharArray();
		for (char part : parts) {
			int party = Integer.parseInt(Character.toString(part));
			result += party * party;
		}

		if (result == 1) {
			return;
		} else {
			happify(Integer.toString(result));
		}
	}
}
