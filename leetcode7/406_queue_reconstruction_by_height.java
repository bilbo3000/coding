/*
 * Queue reconstruction by height. Given a list of people where first element 
 * is height and second element is the number of people taller or equal height 
 * in front of this people. Goal is to reconstruct the queue. 
 * 
 * The core idea was to process people grouped by their height in descreasing order, 
 * break even on second element k. 
 * 
 * This is correct because the position can only be impacted by taller/equal height
 * people. So when process each height group, only need to consider people that have 
 * already been placed. Following height groups will be shorter and does not impact 
 * current placement at all. Therefore, for current height group, for each people, we
 * can simply insert at position k (cause all previous k elements are already place and 
 * be larger or equal). 
 * 
 * Time: O(nlogn), sorting.
 * Space: O(n), arraylist store each element. 
 */
class Solution {
	public int[][] reconstructQueue(int[][] people) {
		if (people == null || people.length == 0 || people[0].length == 0) {
			return new int[0][];
		}

		int n = people.length;
		int[][] res = new int[n][2];
		List<int[]> l = new ArrayList<>();
		
		// Sort input based on height, break even on k
		Arrays.sort(people, new Comparator<int[]>() {
			@Override
			public int compare(int[] p1, int[] p2) {
				if (p1[0] != p2[0]) {
					return p2[0] - p1[0];
				} else {
					return p1[1] - p2[1]; 
				}
			}
		});

		// Reconstruction starts
		for (int i = 0; i < n; i++) {
			l.add(people[i][1], people[i]);
		}

		// Move people from list to result array
		for (int i = 0; i < n; i++) {
			res[i][0] = l.get(i)[0];
			res[i][1] = l.get(i)[1];
		}

		return res;
	}
}
