public class Main {
    public static void main(String[] args) {
        Solution sln = new Solution();
        TreeNode root = null;
        int[] values = new int[]{5, 4, 9, 5, 7, 2, 2};

        // Insert tests
        for (int x : values) {
            root = sln.insert(root, x);
        }

        sln.levelPrint(root);
//        output:
//        5
//        4 5 9
//        2 7
//        2

        // Delete tests
        // Delete node does not exist
        root = sln.delete(root, 1);
        sln.levelPrint(root);
//        output: nothing changes
//        5
//        4 5 9
//        2 7
//        2

        // Delete duplicated element
        root = sln.delete(root, 2);
        sln.levelPrint(root);
//        output: 2 got deleted from previous tree
//        5
//        4 5 9
//        2 7

        // Delete any element
        root = sln.delete(root, 4);
        sln.levelPrint(root);
//        output: 4 got deleted from previous tree
//        5
//        2 5 9
//        7

        // Delete root
        root = sln.delete(root, 5);
        sln.levelPrint(root);
//        output: root (5) got deleted from previous tree
//        5
//        2 9
//        7

        // Delete from empty tree
        root = sln.delete(null, 5);  // Do nothing
    }
}
