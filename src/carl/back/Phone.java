package carl.back;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Phone {
    public ArrayList<char[]> dict = new ArrayList<>();
    public LinkedList<Character> stack = new LinkedList<>();
    public ArrayList<String> results = new ArrayList<>();
    public static void main(String[] args) {
//        Phone phone = new Phone();
//        phone.init();
//        String digi = "2";
//        phone.soultion(digi,digi.length(),0);
//        System.out.println(Arrays.toString(phone.results.toArray()));
        System.out.println(Arrays.asList(1,2,3).equals(Arrays.asList(1,2,3)));

    }
    public void soultion(String digt,int enough,int current){
        if(stack.size() == enough){ //够不够都不会继续往下了
            StringBuilder builder = new StringBuilder();
            for(char ch:stack){
                builder.append(ch);
            }
            results.add(builder.toString());
            return;
        }
        int index = digt.charAt(current) - '0';
        if(index == 1) return;
        char[] nexta = dict.get(index);

        for(int i = 0;i < nexta.length;i++){
            stack.offerLast(nexta[i]);
            soultion(digt,enough,current + 1);
            stack.pollLast();
        }
    }
    public void init(){
        dict.add(new char[]{'#'});//1
        dict.add(new char[]{'#'});
        dict.add("abc".toCharArray());//2
        dict.add("def".toCharArray());//3
        dict.add("ghi".toCharArray());
        dict.add("jkl".toCharArray());
        dict.add("mno".toCharArray());
        dict.add("pqrs".toCharArray());
        dict.add("tuv".toCharArray());
        dict.add("wxyz".toCharArray());
    }
}
