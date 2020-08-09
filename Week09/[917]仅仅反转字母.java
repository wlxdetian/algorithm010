//给定一个字符串 S，返回 “反转后的” 字符串，其中不是字母的字符都保留在原地，而所有字母的位置发生反转。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入："ab-cd"
//输出："dc-ba"
// 
//
// 示例 2： 
//
// 输入："a-bC-dEf-ghIj"
//输出："j-Ih-gfE-dCba"
// 
//
// 示例 3： 
//
// 输入："Test1ng-Leet=code-Q!"
//输出："Qedo1ct-eeLg=ntse-T!"
// 
//
// 
//
// 提示： 
//
// 
// S.length <= 100 
// 33 <= S[i].ASCIIcode <= 122 
// S 中不包含 \ or " 
// 
// Related Topics 字符串 
// 👍 56 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseOnlyLetters(String S) {
        if (S ==null || S.length() == 0){
            return S;
        }

        int len = S.length();
        char[] buffer = S.toCharArray();
        for (int i =0 ,j = len -1; i < j ; ){
            //System.out.println(isAp(buffer[i])+":"+buffer[i]);
            if (!isAp(buffer[i])){
                i++;
                continue;
            }
            if (!isAp(buffer[j])){
                j--;
                continue;
            }
            if (i >=j){
                break;
            }
           // System.out.println("i="+i+":j="+j);
            char temp = buffer[i];
            buffer[i] = buffer[j];
            buffer[j] = temp;
            i++;
            j--;
          //  System.out.println(new String(buffer));
        }

        return new String(buffer);

    }

    public boolean isAp(char ch){
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
//leetcode submit region end(Prohibit modification and deletion)
