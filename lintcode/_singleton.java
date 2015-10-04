class Solution {
    // static final instance 
    private static final Solution instance = new Solution();
    
    // private constructor
    private Solution() {}
    
    /**
     * @return: The same instance of this class every time
     */
    public static Solution getInstance() {
        return instance; 
    }
};
