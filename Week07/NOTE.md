学习笔记

一。本周学校要点
   1.字典树，前缀树，在字符串搜索中有重要应用。
   2。并查集，用于分类等应用场景。结合DFS威力巨大。
   3。剪枝，启发式搜索，重要减少搜索的规模。减少分之。
   
二。模版回忆：

    DFS 代码模板
    //JAVA递归版本

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root==null){
            return allResults;
        }
        travel(root,0,allResults);
        return allResults;
    }


    private void travel(TreeNode root,int level,List<List<Integer>> results){
        if(results.size()==level){
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        if(root.left!=null){
            travel(root.left,level+1,results);
        }
        if(root.right!=null){
            travel(root.right,level+1,results);
        }
    }
    


    BFS 代码模板 JAVA实现

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
    
        TreeNode(int x) {
            val = x;
        }
     }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if (root == null) {
            return allResults;
        }
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            int size = nodes.size();
            List<Integer> results = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = nodes.poll();
                results.add(node.val);
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
            }
            allResults.add(results);
        }
        return allResults;
    }
    
    
    并查集代码模板--java
    
    class UnionFind { 
    	private int count = 0; 
    	private int[] parent; 
    	public UnionFind(int n) { 
    		count = n; 
    		parent = new int[n]; 
    		for (int i = 0; i < n; i++) { 
    			parent[i] = i;
    		}
    	} 
    	public int find(int p) { 
    		while (p != parent[p]) { 
    			parent[p] = parent[parent[p]]; 
    			p = parent[p]; 
    		}
    		return p; 
    	}
    	public void union(int p, int q) { 
    		int rootP = find(p); 
    		int rootQ = find(q); 
    		if (rootP == rootQ) return; 
    		parent[rootP] = rootQ; 
    		count--;
    	}
    }
    
    
    分治代码模板
    # Python
    def divide_conquer(problem, param1, param2, ...): 
      # recursion terminator 
      if problem is None: 
    	print_result 
    	return 
    
      # prepare data 
      data = prepare_data(problem) 
      subproblems = split_problem(problem, data) 
    
      # conquer subproblems 
      subresult1 = self.divide_conquer(subproblems[0], p1, ...) 
      subresult2 = self.divide_conquer(subproblems[1], p1, ...) 
      subresult3 = self.divide_conquer(subproblems[2], p1, ...) 
      …
    
      # process and generate the final result 
      result = process_result(subresult1, subresult2, subresult3, …)
    	
      # revert the current level states



    递归代码模板--java
    
    // Java
    public void recur(int level, int param) { 
      // terminator 
      if (level > MAX_LEVEL) { 
        // process result 
        return; 
      }
      // process current logic 
      process(level, param); 
      // drill down 
      recur( level: level + 1, newParam); 
      // restore current status 
     
    }
   