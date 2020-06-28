import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PermuteSolution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ret = new LinkedList<List<Integer>>();
        permuteAll(nums, ret, new LinkedList<Integer>());
        return ret;
    }

    public void permuteAll(int[] nums, List<List<Integer>> ret, LinkedList<Integer> tmp) {
        if (tmp.size() == nums.length) {
            ret.add(new LinkedList<>(tmp));
            return;
        }

        for (int j = 0; j < nums.length; j++) {
            boolean flag = false;
            for (Integer n : tmp) {
                if (n == nums[j]) {
                    flag = true;
                }
            }
            if (!flag) {
                tmp.add(nums[j]);
                permuteAll(nums, ret, tmp);
                System.out.println(tmp);
                tmp.removeLast();
            }
        }
    }

    public static void main(String args[]) {

        PermuteSolution solution = new PermuteSolution();
        int[] nums = { 1, 2, 3 ,4,5};

        List<List<Integer>> ret = solution.permute(nums);
        System.out.println(ret);

    }

}