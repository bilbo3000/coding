class Solution {
    public int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
        int rec1 = (N - L) * (M - K);
        int rec2 = (S - Q) * (R - P);
        int overlap = 0; 
        
        // No overlaps
        if (M <= P || R <= K || L >= S || Q >= N) {
            overlap = 0; 
        } 
        else {
            int overlapx = 0; 
            int overlapy = 0; 
            
            if (P <= K && M <= R) {
                overlapx = M - K; 
            } else if (K <= P && R <= M) {
                overlapx = R - P; 
            } else if (K <= P && M <= R) {
                overlapx = M - P; 
            } else if (P <= K && R <= M) {
                overlapx = R - K; 
            }
            
            if (S >= N && L >= Q) {
                overlapy = N - L; 
            } else if (N >= S && Q >= L) {
                overlapy = S - Q; 
            } else if (N >= S && L >= Q) {
                overlapy = S - L; 
            } else if (S >= N && Q >= L) {
                overlapy = N - Q; 
            }
            
            overlap = overlapx * overlapy; 
        }
        
        return rec1 + rec2 - overlap; 
    }
}
