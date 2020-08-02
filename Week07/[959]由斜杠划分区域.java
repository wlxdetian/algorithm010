//在由 1 x 1 方格组成的 N x N 网格 grid 中，每个 1 x 1 方块由 /、\ 或空格构成。这些字符会将方块划分为一些共边的区域。 
//
// （请注意，反斜杠字符是转义的，因此 \ 用 "\\" 表示。）。 
//
// 返回区域的数目。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：
//[
//  " /",
//  "/ "
//]
//输出：2
//解释：2x2 网格如下：
// 
//
// 示例 2： 
//
// 输入：
//[
//  " /",
//  "  "
//]
//输出：1
//解释：2x2 网格如下：
// 
//
// 示例 3： 
//
// 输入：
//[
//  "\\/",
//  "/\\"
//]
//输出：4
//解释：（回想一下，因为 \ 字符是转义的，所以 "\\/" 表示 \/，而 "/\\" 表示 /\。）
//2x2 网格如下：
// 
//
// 示例 4： 
//
// 输入：
//[
//  "/\\",
//  "\\/"
//]
//输出：5
//解释：（回想一下，因为 \ 字符是转义的，所以 "/\\" 表示 /\，而 "\\/" 表示 \/。）
//2x2 网格如下：
// 
//
// 示例 5： 
//
// 输入：
//[
//  "//",
//  "/ "
//]
//输出：3
//解释：2x2 网格如下：
//
// 
//
// 
//
// 提示： 
//
// 
// 1 <= grid.length == grid[0].length <= 30 
// grid[i][j] 是 '/'、'\'、或 ' '。 
// 
// Related Topics 深度优先搜索 并查集 图 
// 👍 78 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class UF{
        int id[] ;
        int count;

        public UF(int n){
            id =  new int[n];
            for (int i = 0 ;i < n; i++){
                id[i] = i;
            }
            count = n;
        }

        public int find(int node){
            while(node != id[node]){
                id[node] = id[id[node]];
                node = id[node];
            }

            return node;
        }

        public void union(int p ,int q){
            int rp = find(p);
            int rq = find(q);

            if (rp == rq ) return ;
            id[rp] = id[rq];
            count--;
        }

        public boolean connected(int p ,int q){
            return find(p) == find(q);
        }

        public int getCount(){
            return count;
        }
    }

    public int regionsBySlashes(String[] grid) {
        /**
         * 1。将没个网格分成四个小格子 4*N*N
         * 2.四个小格子按顺时针分别为0,1,2,3
         * 3.当字符为'/'时 0和1在一个区，2，3在一个区，"\" 0和3在一个区，1，2在一个区，" "时,0,1,2,3在一个区
         * 4。当下方的字符时"/"时，
         */
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length()==0){
            return 0;
        }
        int count  = 4 * grid.length * grid[0].length();

        UF uf = new UF(count);
        int row = grid.length;
        int col = grid[0].length();
//System.out.println(uf.getCount());
        for (int i = 0 ;i < row; i++){
            for (int j =0 ;j<col;j++){
                if (grid[i].charAt(j) == '\\'){
                    uf.union(node(i,j,col),node(i,j,col)+1);
                    uf.union(node(i,j,col)+2,node(i,j,col)+3);
                }
                if (grid[i].charAt(j) == '/'){
                    uf.union(node(i,j,col),node(i,j,col)+3);
                    uf.union(node(i,j,col)+2,node(i,j,col)+1);
                }
                if (grid[i].charAt(j) == ' '){
                   // System.out.println(node(i,j,col)+":"+(node(i,j,col)+3));
                    uf.union(node(i,j,col),node(i,j,col)+1);
                    uf.union(node(i,j,col)+2,node(i,j,col)+3);
                    uf.union(node(i,j,col)+1,node(i,j,col)+3);
                }
              //  System.out.println(uf.getCount());
                if (i > 0){
                    uf.union(node(i,j,col)+0,node(i-1,j,col)+2);
                }
                if (i < row -1){
                    uf.union(node(i,j,col)+2,node(i+1,j,col));
                }
                if (j < col -1){
                    uf.union(node(i,j,col)+1,node(i,j+1,col)+3);
                }
                if (j > 0){
                    uf.union(node(i,j,col)+3,node(i,j-1,col)+1);
                }

               // System.out.println(uf.getCount());

            }
        }
        return uf.getCount();
    }

    public int node(int i ,int j,int col){
        return i * col*4 + j*4;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
