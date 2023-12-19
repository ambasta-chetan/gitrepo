package com.practice.p1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        //Input: [[8,10],[15,18],[1,3],[2,6]]

        //Output: [[1,6],[8,10],[15,18]]
        
        
        int arr[][]= {{1,3},{2,6},{8,10},{15,18}};
        int res[][]=processPairs(arr);
        
        for(int i=0;i<res.length;i++) {
        	System.out.println(res[i][0] + "," + res[i][1]);
        }
        
        
        

	}

	private static int[][] processPairs(int[][] pairs){
		
		List<Pair> pairList=new ArrayList<>();
		//List<Pair> resultList=new ArrayList<>();
		
		for(int i=0;i<pairs.length;i++) {
				Pair p=new Pair(pairs[i][0], pairs[i][1]);
				pairList.add(p);
		}
		System.out.println(pairList);
		Collections.sort(pairList);
		System.out.println(pairList);
		int n=pairList.size();
		for(int i=0;i<n-1;i++) {
			
			Pair p1=pairList.get(i);
			Pair p2=pairList.get(i+1);
			
			if(p1.second >= p2.first) {
				//mergeAndDelete
				p1.second=p2.second;
				pairList.remove(p2);
				i--;
				n--;
				
			}
			
		}
		System.out.println(pairList);
		int res[][]=new int[pairList.size()][2];
		for(int i=0;i<pairList.size();i++) {
			res[i][0]=pairList.get(i).first;
			res[i][1]=pairList.get(i).second;
			
		}
		return res;
	}
	
}
class Pair implements Comparable<Pair>{
	@Override
	public String toString() {
		return "Pair [first=" + first + ", second=" + second + "]";
	}

	Integer first;
	Integer second;
	
	public Pair(Integer first, Integer second) {
		super();
		this.first = first;
		this.second = second;
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return this.first.compareTo(o.first);
	}
}
