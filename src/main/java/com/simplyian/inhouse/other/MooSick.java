package com.simplyian.inhouse.other;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MooSick extends LinkedHashMap<ArrayList<List<LinkedList<Object>>>, String> {
	public static void main(String[] args) {
		try {
			FileInputStream stream = new FileInputStream(new File("moosick.in"));
			Scanner scanner = new Scanner(stream);
			
			int first = Integer.parseInt(scanner.nextLine());
			int[] song = new int[first];
			for (int i = 0; i < song.length; i++) {
				song[i] = Integer.parseInt(scanner.nextLine());
			}
			
			// Number of notes in the chord
			int c = Integer.parseInt(scanner.nextLine());
			
			if (c < 1) {
				System.out.println(c);
				return;
			}
			
			int[] chord = new int[c]; // Ruminant seventh chord
			for (int i = 0; i < c; i++) {
				chord[i] = Integer.parseInt(scanner.nextLine());
			}
			
			// Sort the chord
			Arrays.sort(chord);
			int[] baseRuminant = chord;
			
			int base = baseRuminant[0];
			for (int i = 0; i < baseRuminant.length; i++) {
				baseRuminant[i] -= base;
			}
			
			List<Integer> chords = new ArrayList<Integer>();
			
			// Sort the song
			for (int i = 0; i < song.length - baseRuminant.length; i++) {
				int[] chordToCheck = new int[baseRuminant.length];
				for (int q = 0; q < baseRuminant.length; q++) {
					chordToCheck[q] = song[i + q];
				}
				
				Arrays.sort(chordToCheck);
				
				int baze = chordToCheck[0];
				for (int x = 0; x < chordToCheck.length; x++) {
					chordToCheck[x] -= baze;
				}
				
				boolean matches = true;
				for (int x = 0; x < baseRuminant.length; x++) {
					if (baseRuminant[x] != chordToCheck[x]) {
						matches = false;
						break;
					}
				}
				
				// Check if chord matches
				if (matches) {
					chords.add(i + 1);
				}
			}
			
			System.out.println(chords.size());
			for (int i = 0; i < chords.size(); i++) {
				System.out.println(chords.get(i));
			}
		} catch (Exception ex) {
			Logger.getLogger(MooSick.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}