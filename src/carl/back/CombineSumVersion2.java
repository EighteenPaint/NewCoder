package carl.back;

import java.util.*;

public class CombineSumVersion2 {
    /**
     重复的组合怎么办呢?如何解决重复的组合呢？如果遇到有重复数组怎么办？
     如果第一层不在使用相同的元素，会不会？答：不会。你在元素多的时候没有找到的解，在元素少的时候就更不可能找到了
     那么如何做到在一层呢
     */
    class Solution {
        private List<List<Integer>> results = new ArrayList();
        private LinkedList<Integer> stack = new LinkedList();
        private int target = 0;
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);//内部操作
            this.target = target;
            back(candidates,0,0);
            return results;
        }
        public void back(int[] a, int state,int select){
            if(select == a.length){
                if(state == this.target) results.add(List.copyOf(stack));
                return;
            }
            if(state == this.target){
                results.add(List.copyOf(stack));
                return;
            }
            if(state > target){
                return;
            }
            HashSet<Integer> set = new HashSet();
            for(int i = select;i < a.length;i++){
                if(set.add(a[i])){
                    stack.offerLast(a[i]);
                    back(a,state + a[i],i + 1);
                    stack.pollLast();
                }
            }
        }
    }
}
