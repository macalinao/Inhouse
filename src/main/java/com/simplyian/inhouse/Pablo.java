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
public class Pablo {
	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			String sentence = br.readLine();

			System.out.println(analyze(sentence));

		} catch (Exception ex) {
		}
	}

	private static int analyze(String sentence) {
		int ret = 0;
		String[] lemmae = sentence.split(" ");
		for (String lemma : lemmae) {
			int score = lemma.length();
			for (char c : lemma.toCharArray()) {
				if (c == ',' || c == '!' || c == '.' || c == '?') {
					score -= 1;
				}
			}
			if (score >= 6) {
				ret += 1;
			}
		}
		return ret;
	}
}
