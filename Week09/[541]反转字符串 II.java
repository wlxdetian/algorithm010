//给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。 
//
// 
// 如果剩余字符少于 k 个，则将剩余字符全部反转。 
// 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。 
// 
//
// 
//
// 示例: 
//
// 输入: s = "abcdefg", k = 2
//输出: "bacdfeg"
// 
//
// 
//
// 提示： 
//
// 
// 该字符串只包含小写英文字母。 
// 给定字符串的长度和 k 在 [1, 10000] 范围内。 
// 
// Related Topics 字符串 
// 👍 84 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseStr(String s, int k) {


        if (s == null || s.length() == 0 ){
            return s;
        }
      //  if(|| s.length() < k)
        int len = s.length();
        char[] buffer = s.toCharArray();

        int range = 2 * k;
        int left = 0;
        //循环字符数组
        for (int i = 0 ;i < len;i++){

            //去2*k的范围
             if (left + k >=len){
                 //System.out.println(new String(buffer)+"gggggg,left ="+ left +", right = "+ (len-1));
                 reverseStr(buffer,left,len-1);
                 break;
             }
             if (left + 2* k >= len -1){
                // System.out.println(new String(buffer)+"cccccc,left ="+ left +", right = "+ (left+k-1));
                 reverseStr(buffer,left,left+k-1);
                 break;
             }
             reverseStr(buffer,left ,left+k-1);
             left += 2 * k ;
             i = left;
        }

        return new String(buffer);

    }
    public void reverseStr(char buffer[] ,int left ,int right){
       // System.out.println(new String(buffer)+",left ="+ left +", right = "+ right);
        for(int i  = left ,j = right; i< j ;i++, j--){
            char temp = buffer[i];
            buffer[i] = buffer[j];
            buffer[j] = temp;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
