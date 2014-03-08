public class Solution {
    public int largestRectangleArea(int[] height) {
        int[] h = new int[height.length + 2];
        h[0] = 0; 
        System.arraycopy(height, 0, h, 1, height.length);
        h[h.length - 1] = 0;
        Stack<Integer> s = new Stack<Integer>();
        int max = 0;
        max = h[0];
        s.push(0);

        for (int i = 1; i < h.length; i++) {
            if (h[i] >= h[s.peek()]) {
                s.push(i);
            }
            else {
                // Clear out stack
                while (s.size() > 0 && h[s.peek()] > h[i]) {
                    int index = s.pop();
                    int areaRight = h[index] * (i - index); 
                    int areaLeft = 0;  
                    
                    if (s.size() != 0) {
                    	areaLeft = (index - 1 - s.peek()) * h[index]; 
                    }
                    
                    max = Math.max(max, areaLeft + areaRight);
                }

                s.push(i);
            }
        }

        return max;
    }
}
