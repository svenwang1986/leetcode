package com.leetcode.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * amazon coding test 
 * @author sven
 * @date 20191114
 */
public class NetworkRouterPairs {

	public static void main(String[] args) {
		int[][] links = new int[][]{{1,2},{2,3},{3,4},{4,5},{6,3}};
		List r1 = getWakeRouter(6,5, links);
		System.out.println(r1);
		
		int[][] links2 = new int[][]{{1,2},{1,3},{2,3},{3,4},{4,5},{4,6},{5,6},{5,7},{6,7},{7,8},{8,9},{8,10},{9,10}};
		List r2 = getWakeRouter(10,13, links2);
		System.out.println(r2);
	}
	
	public static List<Integer> getWakeRouter(int routerNum, int linkNum, int[][] links){
		
		List<Integer> result = new ArrayList<Integer>();
		if(routerNum == 1){
			result.add(1);
			return result;
		}
		Map<Integer,List<Integer>> map = new HashMap<>();
		for(int[] link :links){
			List<Integer> list = map.get(link[0]);
			if(list == null){
				list = new ArrayList<Integer>();
			}
			list.add(link[1]);
			map.put(link[0], list);
			
			list = map.get(link[1]);
			if(list == null){
				list = new ArrayList<Integer>();
			}
			list.add(link[0]);
			map.put(link[1], list);
		}
		
		System.out.println(map);
		
		for(int i = 1; i <= routerNum; i++){
			//brute force, retrieve the map ,check if wen can get all the element without i
			//if we meet i or a retrieved element , stop
			Queue<Integer> queue  = new ConcurrentLinkedQueue<>(); 
			Set<Integer> set = new HashSet<>();
			//设置起点
			int start = i + 1;
			if(i == routerNum){
				start = 1;
			}
			queue.add(start);
			//从一个点出发（只要不是当前要去除的点就可以），遍历所有的map关系，跳过和i有关的link,最后如果发现除了i都在，则证明链路是通的
			while(!queue.isEmpty()){
				int router = queue.poll();
				set.add(router);
				List<Integer> list = map.get(router);
				for(int n: list){
					if(set.contains(n) || n == i){
						continue;
					}
					queue.add(n);
				}
			}
			System.out.println("i=" + i + ", set = " + set);
			if(set.size() < routerNum - 1){
				result.add(i);
			}
			
			
		}
		
		return result;
	}
}
