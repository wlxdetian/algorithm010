//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1: 
//
// 输入:
//[
//['1','1','1','1','0'],
//['1','1','0','1','0'],
//['1','1','0','0','0'],
//['0','0','0','0','0']
//]
//输出: 1
// 
//
// 示例 2: 
//
// 输入:
//[
//['1','1','0','0','0'],
//['1','1','0','0','0'],
//['0','0','1','0','0'],
//['0','0','0','1','1']
//]
//输出: 3
//解释: 每座岛屿只能由水平和/或竖直方向上相邻的陆地连接而成。
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 
// 👍 679 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
//1.通过并查集解题
//2.深度优先
//3.广度优先
class Solution {
    class UnionFind{
        private int count = 0 ;
        private int[] id ;
        public UnionFind(char[][] grid){
            int row = grid.length;
            int col = grid[0].length;
            id = new int[row*col];
            for ( int i = 0 ;i < row ;i++ ){
                for(int j = 0 ;j< col ;j++){
                    if(grid[i][j] == '1'){
                        id[i*col+j] = i*col+j;
                        count++;
                    }
                }
            }
        }
        public int getCount(){
            return   this.count;
        }
        public int find(int p){
            while (p != id[p]){
                id[p] = id[id[p]];
                p = id[p];
            }
            return p;
        }

        public void union(int p ,int q){
            int rp = find(p);
            int rq = find(q);
            if(rq == rp) return ;
            id[rp] = rq;
            count--;
        }
    }
    public int numIslands(char[][] grid) {

        //1.构造并查集
        //2将二维转换为一维  grid.length*grid[0].length;
        //grid[i][j] = i*grid[0].length+j;
        if (grid == null || grid.length==0 || grid[0] == null || grid[0].length == 0){
            return 0;
        }


        int row = grid.length;
        int col = grid[0].length;
        int num =row * col;
        UnionFind uf = new UnionFind(grid);

        //循环数字，查找陆地
        for (int i = 0 ; i < row ; i++ ){
            for (int j = 0 ; j < col ; j++){
                //判断当前格子是否为陆地
                if ( grid[i][j] == '1'){
                    //判断下面的格式是否是陆地
                    if (i +1 < row && grid[i+1][j] == '1'){
                        uf.union(i*col+j,(i+1)*col+j);
                    }
                    //判断左边的格式是否是陆地
                    if ( j + 1 < col && grid[i][j+1] =='1'){
                        uf.union(i*col+j,i*col +j+1);
                    }

                }
            }
        }
        return uf.getCount();

    }
}
//leetcode submit region end(Prohibit modification and deletion)
