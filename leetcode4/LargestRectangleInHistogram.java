public class Solution {
    public int largestRectangleArea(int[] height) {
        int len = height.length;
        ArrayList<Integer> al = new ArrayList<Integer>();
        for (int item : height) {
            al.add(item);
        }
        al.add(0, 0);
        al.add(0);
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for (int i = 0; i < al.size(); i++) {
            while (stack.size() != 0 && al.get(stack.peek()) > al.get(i)) {
                int index = stack.pop();
                max = Math.max(max, al.get(index) * (i - stack.peek() - 1));
            }

            stack.push(i);
        }

        return max;
    }
}
