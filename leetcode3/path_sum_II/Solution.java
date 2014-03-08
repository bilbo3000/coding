public class Solution {
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

        if (root == null) {
            return result;
        }

        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                temp.add(root.val);
                result.add(temp);
                return result;
            }
            else {
                return result;
            }
        }

        ArrayList<ArrayList<Integer>> temp = pathSum(root.left, sum - root.val);
        temp.addAll(pathSum(root.right, sum - root.val));

        for (ArrayList<Integer> item : temp) {
            item.add(0, root.val);
            result.add(item);
        }

        return result;
    }
}
