class Solution {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     * 
     * Basically make regular sort color more generic. 
     * 
     * O(kn)
     */
    public void sortColors2(int[] colors, int k) {
        int l = 1; 
        int r = k; 
        int p1 = -1; 
        int p2 = colors.length; 
        
        while (l < k) {
            int start = p1 + 1; 
            int end = p2 - 1; 
            
            for (int i = start; i <= end; i++) {
                if (i >= p2) {
                    break; 
                }
                
                if (colors[i] == l) {
                    p1++; 
                    swap(colors, i, p1);
                } else if (colors[i] == r) {
                    p2--; 
                    swap(colors, i, p2);
                    i--; 
                }
            }
            
            l++; 
            r--; 
        }
    }
    
    private void swap(int[] colors, int l, int r) {
        int temp = colors[l]; 
        colors[l] = colors[r]; 
        colors[r] = temp; 
    }
}
