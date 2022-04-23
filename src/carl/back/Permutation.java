package carl.back;

import java.util.*;

public class Permutation {
    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        ArrayList list = (ArrayList) permutation.permuteUnique(new int[]{1,1,2});
        System.out.println(Arrays.toString(list.toArray()));

    }
    private ArrayList<List<Integer>> results = new ArrayList();
    private LinkedList<Integer> stack = new LinkedList();
    private HashSet<Integer> set = new HashSet();
    public List<List<Integer>> permuteUnique(int[] nums) {
        back(nums,nums.length,set);
        return results;
    }
    public void back(int[] a,int enough,HashSet set){
        if(stack.size() == enough){
            results.add(List.copyOf(stack));
            System.out.println(Arrays.toString(stack.toArray()));
            return;
        }
        HashSet<Integer> layerSet = new HashSet();
        for(int i = 0;i < a.length;i++){
            if(set.add(i)){
                if(layerSet.add(a[i])) {
                    stack.offerLast(a[i]);//入栈
                    back(a, enough, set); //递归
                    stack.pollLast(); //回溯
                }
                set.remove(i);//如果没有移除掉会产生什么情况
            }

        }
        /**
         * 这是一个错误的典型例子，前面判断成功，但是后面判断失败，但是前面的没有回滚
         *       for(int i = 0;i < a.length;i++){
         *             if(set.add(i) && layerSet.add(a[i])){
         *
         *                     stack.offerLast(a[i]);//入栈
         *                     back(a, enough, set); //递归
         *                     stack.pollLast(); //回溯
         *
         *                 set.remove(i);//如果没有移除掉会产生什么情况
         *             }
         *
         *         }
         */

    }
}
