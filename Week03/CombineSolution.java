import java.util.LinkedList;
import java.util.List;

/**
*77 组合
**/
public class CombineSolution {

    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        combineAll(n, 1, k, ret, new LinkedList<Integer>());
        return ret;

    }

    public void combineAll(int n, int currentNum, int k, List<List<Integer>> ret, List<Integer> tmp) {
        //结束条件
        if (tmp.size() == k) {
            ret.add(new LinkedList<>(tmp));
            return;
        }

        //递归
        for (int j = currentNum; j <= n; j++) {
            tmp.add(j);
            combineAll(n, j + 1, k, ret, tmp);
            //清理
            ((LinkedList) tmp).removeLast();
        }
    }

    public static void main(String[] args) {
        CombineSolution solution = new CombineSolution();
        List<List<Integer>> ret = solution.combine(4, 2);
        System.out.println(ret);
    }
}