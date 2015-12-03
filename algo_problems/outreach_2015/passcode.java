import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
    for (int i = 1; i <= 12; i++) {
      if (i == 11) {
        continue; 
      }
      
      for (int j = 1; j <= 31; j++) {
        if (j == 11 || j == 22) {
          continue; 
        }
        
        int d2 = i % 10; 
        int d1 = i / 10; 
        int d4 = j % 10; 
        int d3 = j / 10; 
        
        if (d1 == d3 || d1 == d4 || d2 == d3 || d2 == d4) {
          continue; 
        }
        
        System.out.printf("%d%d%d%d\n", d1, d2, d3, d4); 
      }
    }
  }
}
