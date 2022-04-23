package carl.back;

import java.util.*;

/**
 * 本demo实现的是组合问题，选择都是固定的
 */
public class Combine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int group = scanner.nextInt();
        int[] a = new int[length];
       for(int i = 0;i < length;i++){
           a[i] = i + 1;
       }
       Solution solution = new Solution();
       solution.combine(a,0,group);
       ArrayList result = solution.getResults();
        System.out.println(Arrays.toString(result.toArray()));
    }
}
class Solution{
    public LinkedList<Integer> stack = new LinkedList<>();
    public ArrayList<List<Integer>> results = new ArrayList();

    public static int target = 9;

    public ArrayList<List<Integer>> getResults() {
        return results;
    }

    public void combine(int[] a, int select, int enough){
        if(stack.size() == enough){
            int sum = 0;
            for(int i:stack){
                sum+=i;
            }
            if(sum == target){
                results.add(List.copyOf(stack));
            }
        }
        for(int i = select;i < a.length;i++){
            stack.offerLast(a[i]);
            combine(a,i+1,enough);
            stack.pollLast();
        }
    }
    public boolean cut(){
        return false;
    }
}