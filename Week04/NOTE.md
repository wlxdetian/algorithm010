学习笔记

1.深度优先算法模版

# Python
def BFS(graph, start, end):
    visited = set() //
	queue = [] 
	queue.append([start]) 
	while queue: 
		node = queue.pop() 
		visited.add(node) 
		process(node) 
		nodes = generate_related_nodes(node) 
		queue.push(nodes)
	# other processing work 
	...

2.广度优先算法模版

  2.1递归形式
     visited = set() 
     def dfs(node, visited):
         if node in visited: # terminator
    	 # already visited 
    	 return 
	     visited.add(node) 
	   # process current node here. 
	    ...
	    for next_node in node.children(): 
		if next_node not in visited: 
			dfs(next_node, visited)

  2.2非递归形式
     def DFS(self, tree): 
	    if tree.root is None: 
		return [] 
	    visited, stack = [], [tree.root]
	    while stack: 
		    node = stack.pop() 
		    visited.add(node)
		    process (node) 
		    nodes = generate_related_nodes(node) 
		    stack.push(nodes) 
	   # other processing work 
	    ...


3.贪心算法
   
    3.1局部最优解.而非全局最优解.


4.二分查找
   4.1 几个条件
    a.要么具有大调递增,要么具有单调递减,或者是某种变形的单调变化.
    b.有边界
    c.可通过索引访问.

   4.2二分查找算法模版
   # Python
   left, right = 0, len(array) - 1 
    while left <= right: 
	  mid = (left + right) / 2 
	  if array[mid] == target: 
		    # find the target!! 
		    break or return result 
	  elif array[mid] < target: 
		    left = mid + 1 
	  else: 
		    right = mid - 1