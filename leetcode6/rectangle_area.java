/**
 * Find the total area of two rectangles where each is represented by 
 * left lower corner and upper right corner. 
 * The ideas was to add two rectangles together and substract their 
 * overlaps. The trick part was finding the overlap. This approaches 
 * discusses all possible combinations for parallel edges and vertical 
 * edges independently. The tricky part is during the case where edges 
 * are alternating, need to specify the relative position of all four 
 * edges to avoid ambiguous. 
 */
public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int result = (C - A) * (D - B) + (G - E) * (H - F); 
        int overlap = 0; 
        
        int x = 0; 
        int y = 0; 
        
        if (A <= E && G <= C) {
            x = G - E; 
        } else if (E <= A && C <= G) {
            x = C - A; 
        } else if (A <= E && E <= C && C <= G) {
            x = C - E; 
        } else if (E <= A && A <= G && G <= C) {
            x = G - A; 
        }
        
        if (D >= H && F >= B) {
            y = H - F; 
        } else if (H >= D && B >= F) {
            y = D - B; 
        } else if (D >= H && H >= B && B >= F) {
            y = H - B; 
        } else if (H >= D && D >= F && F >= B) {
            y = D - F; 
        }
        
        overlap = x * y; 
        
        return result - overlap; 
    }
}
