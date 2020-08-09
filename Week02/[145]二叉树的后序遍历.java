//给定一个二叉树，返回它的 后序 遍历。 
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
//输出: [3,2,1] 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 
// 👍 357 👎 0


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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if(root == null){
            return res;
        }
        //用来存放整个遍历节点
        Stack<TreeNode> stack = new Stack<>();
        //用来在遍历右子树的时候保存左节点
        Stack<TreeNode> leftStack = new Stack<>();

        TreeNode node = root;
        while ( node !=null) {
            stack.push(node);
            TreeNode rightNode = node.right;
            while (rightNode != null ||!leftStack.isEmpty()) {
                stack.push(rightNode);
                //只将左子树压栈
                if(rightNode.left!=null){
                    leftStack.push(rightNode.left);
                }
                rightNode = rightNode.right;
                //右子树遍历完成以后，开始从栈中取出左子树，重复循环
                if(rightNode == null && !leftStack.isEmpty()){
                    rightNode = leftStack.pop();
                }
            }
            node = node.left;
        }
        while(!stack.isEmpty()){
            res.add(stack.pop().val);
        }

        return res;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
