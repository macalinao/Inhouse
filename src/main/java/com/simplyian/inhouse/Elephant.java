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
public class Elephant {
	public static final int A = 6;

	public static final int B = 11;

	public static final int C = 13;

	private static final int[] NUMS = {C, B, A};

	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			int amount = Integer.parseInt(br.readLine());

			System.out.println(getAmount(amount));

		} catch (Exception ex) {
		}
	}

	public static int getAmount(int weight) {
		int total = 0;
		for (int i = 0; i < 2; i++) {
			int amt = weight - NUMS[i];
			if (amt == 0) {
				return 1;
			}
			
			if (amt < 0) {
				return -1;
			}
			
			int dat = getAmount(amt);
			if (dat == -1) {
				return -1;
			}
			total += dat;
		}
		return total;
	}
}
