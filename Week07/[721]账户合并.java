//给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其
//余元素是 emails 表示该帐户的邮箱地址。 
//
// 现在，我们想合并这些帐户。如果两个帐户都有一些共同的邮件地址，则两个帐户必定属于同一个人。请注意，即使两个帐户具有相同的名称，它们也可能属于不同的人，因为
//人们可能具有相同的名称。一个人最初可以拥有任意数量的帐户，但其所有帐户都具有相同的名称。 
//
// 合并帐户后，按以下格式返回帐户：每个帐户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。accounts 本身可以以任意顺序返回。 
//
// 例子 1: 
//
// 
//Input: 
//accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnn
//ybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Ma
//ry", "mary@mail.com"]]
//Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.
//com'],  ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
//Explanation: 
//  第一个和第三个 John 是同一个人，因为他们有共同的电子邮件 "johnsmith@mail.com"。 
//  第二个 John 和 Mary 是不同的人，因为他们的电子邮件地址没有被其他帐户使用。
//  我们可以以任何顺序返回这些列表，例如答案[['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com'
//]，
//  ['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']]仍然会被
//接受。
//
// 
//
// 注意： 
//
// 
// accounts的长度将在[1，1000]的范围内。 
// accounts[i]的长度将在[1，10]的范围内。 
// accounts[i][j]的长度将在[1，30]的范围内。 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 100 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    class UnionFind{
        private int count = 0 ;
        private int[] id ;
        public UnionFind(List<List<String>> accounts){
           int sum = 0;
            for ( int i = 0 ;i <accounts.size() ;i++ ){
                sum+= accounts.get(i).size();
            }
            id = new int[sum];
            for(int i = 0 ;i<sum;i++ ){
                id[i] = i;
                count++;
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
        public void printids(){
            for(int i = 0;i<id.length;i++){
                System.out.print(id[i]+",");
            }
            System.out.print("\n");
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        if ( accounts == null || accounts.size() == 0 ){
            return new ArrayList<List<String>>();
        }

        UnionFind uf = new UnionFind(accounts);
         int row = accounts.size();
         int offset = 0;
         HashMap<String,Integer> emailMap = new HashMap<String,Integer>();
         int count  = uf.getCount();
       // uf.printids();
         for ( int i = 0 ;i <row ;i++ ){
             List<String>  account = accounts.get(i);
             int col = account.size();

             for (int j = 0 ;j < col -1 ;j++){
                     uf.union(offset + 1 + j,offset+j);

             }
             offset += col;
        }
      //  uf.printids();
        //System.out.println(emailMap);

        offset = 0;
        for ( int i = 0 ;i <row ;i++ ){
            List<String>  account = accounts.get(i);
            int col = account.size();
            for (int j = 0 ;j < col  ;j++){
                if (j > 0){
                    if (emailMap.containsKey(account.get(j))){
                        uf.union(offset,emailMap.get(account.get(j)));
                    } else {
                        emailMap.put(account.get(j), offset+j);
                    }
                }
            }
            offset += col;
        }
       // uf.printids();
      //  System.out.println(emailMap);


         Map<Integer,Set<String>> resMap = new HashMap<Integer,Set<String>>();
        Map<Integer,List<String>> resListMap = new HashMap<Integer,List<String>>();
        Map<Integer,String> personMap  = new HashMap<Integer,String>();
        offset = 0;
        for ( int i = 0 ;i <row ;i++ ){
            List<String>  account = accounts.get(i);
            int col = account.size();
            for (int j = 0 ;j <col;j++){
                int rp =    uf.find(offset);
                if ( j > 0 ){
               // System.out.println(offset+":"+rp);
                Set<String>  emailSet =    resMap.get(new Integer(rp));
                    LinkedList<String> resList = (LinkedList)resListMap.get(new Integer(rp));

             if (emailSet == null){
                 emailSet = new HashSet<String>();
                 resMap.put(new Integer(rp),emailSet);
             }
             if(resList == null){
                 resList  = new LinkedList<String>();
                 resListMap.put(new Integer(rp),resList);
             }
              if(!emailSet.contains(accounts.get(i).get(j))){
                  emailSet.add(accounts.get(i).get(j));
                  resList.addFirst(accounts.get(i).get(j));
              }
            }else{
                    personMap.put(new Integer(rp),account.get(j));
                }
                offset++;
            }
        }

        List<List<String>> resList = new LinkedList<List<String>>();

        for(Integer rp : resListMap.keySet() ){
            LinkedList list =    (LinkedList)resListMap.get(rp);
            Collections.sort(list);
            list.addFirst(personMap.get(uf.find(rp)));
            resList.add(list);
        }
        return resList;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
