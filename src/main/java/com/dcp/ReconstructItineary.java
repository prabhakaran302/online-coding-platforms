package com.dcp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/reconstruct-itinerary/submissions/
 * 
 * @author prabhakaran.nivanil
 *
 */
public class ReconstructItineary {
	public List<String> findItinerary(List<List<String>> tickets) {
		List<String> res = new ArrayList<String>();

		Map<String, PriorityQueue<String>> map = new HashMap<>();
		for (List<String> curTicket : tickets) {
			if (!map.containsKey(curTicket.get(0))) {
				PriorityQueue<String> p = new PriorityQueue<String>();
				map.put(curTicket.get(0), p);
			}
			map.get(curTicket.get(0)).offer(curTicket.get(1));
		}

		makeResult("JFK", res, map);

		Collections.reverse(res);
		return res;
	}

	private void makeResult(String string, List<String> res, Map<String, PriorityQueue<String>> map) {
		PriorityQueue<String> s = map.get(string);
		while (s != null && !s.isEmpty()) {
			makeResult(s.poll(), res, map);
		}
		res.add(string);
	}

	public static void main(String[] args) {
		ReconstructItineary itineary = new ReconstructItineary();
		List<List<String>> tickets = getTickets();
		System.out.println(itineary.findItinerary(tickets));
	}

	private static List<List<String>> getTickets() {
		List<List<String>> tickets = new ArrayList<List<String>>();

		String[][] str = new String[][] { { "JFK", "SFO" }, { "JFK", "ATL" }, { "SFO", "ATL" }, { "ATL", "JFK" },
				{ "ATL", "SFO" } };
		for (String[] a : str) {
			List<String> li = new ArrayList<String>();
			li.add(a[0]);
			li.add(a[1]);
			tickets.add(li);
		}

		return tickets;
	}
}
