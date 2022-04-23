package carl.back;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {
    class Solution {
        public List<List<Integer>> results = new ArrayList();
        private LinkedList<Integer> stack = new LinkedList();
        private int target;
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.target = target;
            back(candidates,0,0);
            return results;
        }
        public void back(int[] a, int state,int select){
            if(select == a.length){ //没有可选
                if(state == target) results.add(List.copyOf(stack));
                return;
            }
            if(state == target){
                results.add(List.copyOf(stack));
                return;
            }
            if(state > target){
                return;
            }
            for(int i = select;i < a.length;i++){
                stack.offerLast(a[i]);
                back(a,state + a[i],i);
                stack.pollLast();
            }
        }
    }
}
/**
 可以重复取的情况,但是组合不能重复,组合技巧就是不回头组合，排列就是需要回头组合
 */
