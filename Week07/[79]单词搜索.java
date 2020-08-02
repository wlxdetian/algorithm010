//给定一个二维网格和一个单词，找出该单词是否存在于网格中。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例: 
//
// board =
//[
//  ['A','B','C','E'],
//  ['S','F','C','S'],
//  ['A','D','E','E']
//]
//
//给定 word = "ABCCED", 返回 true
//给定 word = "SEE", 返回 true
//给定 word = "ABCB", 返回 false 
//
// 
//
// 提示： 
//
// 
// board 和 word 中只包含大写和小写英文字母。 
// 1 <= board.length <= 200 
// 1 <= board[i].length <= 200 
// 1 <= word.length <= 10^3 
// 
// Related Topics 数组 回溯算法 
// 👍 490 👎 0

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 *  
 *
 * 示例:
 *
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 *
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *  
 *
 * 提示：
 *
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    private String word;
    private boolean res;
    private  boolean[][] visited;
    private char[][] board ;
    public boolean exist(char[][] board, String word) {

        if (board == null){
            return false;
        }
        this.word = word;
        this.board = board;

        this.visited =  new boolean[board.length][board[0].length];

        for (int i = 0 ; i<board.length ; i++ ){
            for ( int j = 0 ; j<board[i].length ; j++){
                char ch = board[i][j];
                if(ch == word.charAt(0) && !visited[i][j]){
                    dfs(i,j,1);
                }
            }
        }
        return this.res;

    }

    public void dfs(int i,int j,int nextIndex){
        //递归结束条件
        if(nextIndex == this.word.length()){
            this.res = true;
            return ;
        }
        //递归循环
        visited[i][j] = true;
        if(this.res != true && i-1>=0 && board[i-1][j] == word.charAt(nextIndex) && !visited[i-1][j]){
            dfs(i-1,j,nextIndex+1);
        }
        // System.out.println(board);
        if(this.res != true
                && i+1<board.length
                && board[i+1][j] == word.charAt(nextIndex)
                && !visited[i+1][j]){
            dfs(i+1,j,nextIndex+1);
        }
        if(res != true && j-1>=0 && board[i][j-1] == word.charAt(nextIndex) && !visited[i][j-1]){
            dfs(i,j-1,nextIndex+1);
        }
        if(res != true && j+1<board[0].length && board[i][j+1] == word.charAt(nextIndex) && !visited[i][j+1]){
            dfs(i,j+1,nextIndex+1);
        }

        visited[i][j] = false;


    }
}
//leetcode submit region end(Prohibit modification and deletion)
