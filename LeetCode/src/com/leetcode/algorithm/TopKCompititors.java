package com.leetcode.algorithm;

import java.util.*;

public class TopKCompititors {

	public static void main(String[] args) {
		int numCompetitors = 6;
		int topNCompetitors = 2;
		String[] competitors = { "newshop", "shopnow", "afshion", "fashionbeats", "mymarket", "tcellular" };
		int numReviews = 6;
		String[] reviews = { "newshop shopnow;is providing good services in the city;everyone should use newshop",
				"best services by newshop", "fashionbeats has great services in the city",
				"i am proud to have fashionbeats", "shopnow;mymarket has awesome services",
				"Thanks Newshop for the quick delivery." };

		List<String> list = solution(competitors, reviews, topNCompetitors);

		System.out.println(list);
	}

	public static List<String> solution(String[] competitors, String[] reviews, int k) {
		List<String> result = new ArrayList<String>();
		List<String>[] bucket = new List[reviews.length];
		Set<String> competitorsSet = new HashSet<>();
		for (String s : competitors) {
			competitorsSet.add(s);
		}
		Map<String, Integer> counter = new HashMap<>();
		for (String review : reviews) {
			String[] wordArr = review.split("\\W+");
			for (String word : wordArr) {
				if (competitorsSet.contains(word)) {
					counter.put(word, counter.getOrDefault(word, 0) + 1);
				}
			}
		}
		
		for(String key : counter.keySet()){
			
			int count = counter.get(key);
			
			List list = bucket[count];
			if(list == null){
				list = new ArrayList();
				bucket[count] = list;
			}
			list.add(key);
		}
		
		for(int i = bucket.length - 1; i >= 0 && k > 0; i--){
			List list = bucket[i];
			if(list != null){
				Collections.sort(list);
				for(Object s: list){
					result.add((String)s);
					k = k - 1;
					if(k == 0){
						return result;
					}
				}
				
			}
		}

		return result;
	}
}
