//给定一个二叉树，返回它的中序 遍历。 
//
// 示例: 
//
// 输入: [1,null,2,3]
//   1
//    \
//     2
//    /
//   3
//
//输出: [1,3,2] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 哈希表 
// 👍 601 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> treeList = new ArrayList<>();
        Stack < TreeNode > stack = new Stack < > ();
        if(root == null){
            return treeList;
        }

        TreeNode  node = root;

        /**
         * node为空时，表示无子节点，这是考虑栈中是否还有节点。如果有，继续添加到treelist中
         */
        while(node != null || !stack.isEmpty() ){

            while(node != null){
                //将节点本身和左节点全部压栈
                stack.push(node);
                node = node.left;
            }

            //将顶层栈元素取出（最底层的左子节点）
            node = stack.pop();
            treeList.add(node.val);
            node = node.right;//当前节点的右子节点
        }

        return treeList;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
