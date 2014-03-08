package box;

import java.util.*;
import java.util.Map.Entry;

public class BoxCollection {
	Map<Integer, Double> boxes = new HashMap<Integer, Double>(); 
	List<Entry<Integer, Double>> list = new ArrayList<Entry<Integer, Double>>();  // Sorted list
	boolean sorted = false;  // If the list is sorted 
	
	/*
	 * Add a box to the collection 
	 */
	public void addBox(int id, double weight) {
		if (weight < 0) {
			return; 
		}
		
		boxes.put(id, weight); 
		
		// Sort the weight
		list = new ArrayList<Entry<Integer, Double>>(boxes.entrySet());  
		Collections.sort(list, new Comparator<Entry<Integer, Double>>(){
			@Override
			public int compare(Entry<Integer, Double> e1, Entry<Integer, Double> e2) {
				 if (e1.getValue() < e2.getValue()) {
					 return -1; 
				 }
				 else if (e1.getValue() > e2.getValue()) {
					 return 1; 
				 }
				 else {
					 return 0; 
				 }
			}
		});
		
	}
	
	/*
	 * Get a box weight from the collection 
	 */
	public double getWeight(int id) {
		if (boxes.containsKey(id)) {
			return boxes.get(id); 
		}
		
		return 0.0; 
	}
	
	/*
	 * Get weight for a given percentile. 
	 */
	public double percentile(int p) {
		if (list.size() == 0) {
			return 0; 
		}
		
		if (p <= pn(0)) {
			return list.get(0).getValue(); 
		}
		
		if (p >= pn(list.size() - 1)) {
			return list.get(list.size() - 1).getValue(); 
		}
		
		int prev = 0; 
		int curr = 1; 
		
		while (curr < list.size() && pn(curr) < p) {
			prev = curr; 
			curr++; 
		}
		
		if (pn(curr) == p) {
			return list.get(curr).getValue(); 
		}
		
		double vk = list.get(prev).getValue(); 
		double vkk = list.get(curr).getValue(); 
		int pk = pn(prev); 
		int pkk = pn(curr); 
		
		return  vk + (p - pk) / (double)(pkk - pk) * (vkk - vk); 
	}
	
	/*
	 * Calculate the percentile for element at index n. 
	 */
	private int pn(int n) {
		
		if (n < 0) {
			return 0; 
		}
		
		double wn = list.get(n).getValue(); 
		double sN = 0.0; 
		double sn = 0.0; 
		
		for (int i = 0; i < list.size(); i++) {
			Entry<Integer, Double> e = list.get(i); 
			sN += e.getValue(); 
			
			if (i == n) {
				sn = sN; 
			}
		}
		
		return (int) Math.round(100 / sN * (sn - wn / 2)); 
	}
	
	public static void main(String[] args) {
		BoxCollection c = new BoxCollection(); 
		c.addBox(1, 99.5);
		c.addBox(2, 67.4);
		c.addBox(3, 67.3);
		c.addBox(4, 67.4); 
		
		System.out.println(c.getWeight(2)); 
		
		for (int i = 0; i <= 100; i = i + 10) {
			System.out.println(c.percentile(i)); 
		}
	}
}
