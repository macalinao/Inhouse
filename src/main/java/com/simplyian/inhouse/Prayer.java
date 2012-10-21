/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.simplyian.inhouse;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author simplyianm
 */
public class Prayer {
	public static void main(String[] args) {
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);

			// Mah number
			String number = br.readLine();
			int amount = Integer.parseInt(number);

			ArrayList<MyEvent> events = new ArrayList<MyEvent>();

			for (int i = 0; i < amount; i++) {
				events.add(makeEvent(br.readLine()));
			}

			Collections.sort(events, new Comparator<MyEvent>() {
				public int compare(MyEvent a, MyEvent b) {
					return b.end - a.end;
				}
			});

			int amt = 1;
			MyEvent last = events.get(0);
			events.remove(0);

			int iterations = 0;
			while (events.size() > 0) {
				if (iterations++ > 50) {
					break;
				}
				for (int i = 0; i < events.size(); i++) {
					MyEvent event = events.get(i);
					if (event.end <= last.start) {
						amt++;
						last = event;
						events.remove(event);
						break;
					}
				}


				Collections.sort(events, new Comparator<MyEvent>() {
					public int compare(MyEvent a, MyEvent b) {
						return b.end - a.end;
					}
				});
			}
			System.out.println(amt);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private static MyEvent makeEvent(String times) {
		String[] tim = times.split(" ");
		return new MyEvent(Integer.parseInt(tim[0]), Integer.parseInt(tim[1]));
	}

	public static class MyEvent {
		public int start;

		public int end;

		public MyEvent(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public String toString() {
			return "MyEvent{" + "start=" + start + ", end=" + end + '}';
		}
	}
}
