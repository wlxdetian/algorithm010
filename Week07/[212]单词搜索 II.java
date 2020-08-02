//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法 
// 👍 201 👎 0

/**
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * 示例:
 *
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 *
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 *
 * 提示:
 *
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-search-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class Trie {


        class  TrieNode{

            private TrieNode[] links;
            private final int R = 26;//26个字母
            private boolean isEnd;

            public TrieNode(){
                links = new TrieNode[R];
            }

            public boolean containsKey(char ch){
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch){
                return  links[ch - 'a'] ;
            }

            public void put(char ch ,TrieNode node){
                links[ch -'a'] = node;

            }

            public void setEnd(){
                isEnd = true;
            }

            public boolean isEnd(){
                return isEnd;
            }
        }

        private TrieNode  root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();

        }

        /** Inserts a word into the trie. */
        public void insert(String word) {

            TrieNode node = root;
            for(int i = 0 ;i<word.length();i++){
                char ch = word.charAt(i);
                if(!node.containsKey(ch)){
                    node.put(ch,new TrieNode());
                }
                node = node.get(ch);
            }
            node.setEnd();
        }

        private TrieNode searchPrefix(String word){
            TrieNode node = root;
            for(int i = 0 ;i < word.length();i++){
                char ch = word.charAt(i);
                if(node.containsKey(ch)){
                    node = node.get(ch);
                }else{
                    return null;
                }
            }
            return node;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);
            return node !=null && node.isEnd();

        }

        public TrieNode searchEndNode(String word) {
            TrieNode node = searchPrefix(word);
            return node;

        }


        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {

            TrieNode node = searchPrefix(prefix);
            return node != null;
        }
    }

    private char[][] bboard;
    private Set<String>  res = new HashSet<String>();
    private int row = 0;
    private  int col = 0;
    private  boolean[][] visited;
    public List<String> findWords(char[][] board, String[] words) {
        if(board == null || board[0]==null || words == null || words.length == 0){
            return new ArrayList<String>();
        }
        this.bboard = board;
        this.row = board.length;
        this.col = board[0].length;
        int len = words.length;
        Trie trie = new Trie();
        for( int i = 0 ;i < len ;i++){
            trie.insert(words[i]);
        }
        // System.out.println(trie.search("aaa"));
        visited = new boolean[row][col];
        for(int i = 0 ;i < row ;i++){
            for(int j = 0 ;j <col ;j ++){
                StringBuilder ch = new StringBuilder("");
                if (trie.startsWith(""+bboard[i][j]) ){
                    dfs(i,j,trie,ch);
                }
            }
        }
        return new ArrayList<String>(res);
    }

    public void dfs(int i,int j, Trie trie,StringBuilder prefix){
        if ( i < 0 || i > row-1 || j < 0 || j > col-1  ){
            return ;
        }

        if ( visited[i][j] ){
            return ;
        }
        prefix.append(bboard[i][j]);

        if (trie.search(prefix.toString())){
            if (!res.contains(prefix.toString())){
                res.add(prefix.toString());
            }
        }

        visited[i][j] = true;
        if (trie.startsWith(prefix.toString())){
            dfs(i-1,j,trie,prefix);
            dfs(i+1,j,trie,prefix);
            dfs(i,j-1,trie,prefix);
            dfs(i,j+1,trie,prefix);
        }
        prefix.deleteCharAt(prefix.length()-1);
        // prefix = prefix.substring(prefix.length()-1);
        visited[i][j] =false;
    }
}

//leetcode submit region end(Prohibit modification and deletion)
