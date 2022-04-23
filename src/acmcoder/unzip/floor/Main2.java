package acmcoder.unzip.floor;


import java.util.ArrayList;

import java.util.Collections;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int length = n*n;
        int[] a = new int[length];
        for(int i = 0;i < length;i++){
            a[i] = scanner.nextInt();
        }
        int groupLength = scanner.nextInt();
        int[] groups = new int[groupLength];
        for(int i = 0; i < groupLength;i++){
            groups[i] = (int)Math.pow(2,scanner.nextInt());
        }
        for(int i = 0;i < groupLength;i++){
            reverse(groups[i],a);
            System.out.print(cuples(a));
            if(i != groupLength - 1) System.out.print(" ");
        }

    }
    public static int cuples( int[] a){
        int count = 0;
        for(int i = 0; i < a.length;i++){
            for(int j = i + 1;j < a.length;j++){
                if(a[j] < a[i]) count++;
            }
        }
        return count;
    }
    public static void reverse(int group,int[] a){
        ArrayList<Integer> list = new ArrayList(group);
        for(int i = 0;i < a.length;i+= group){
            for(int j = 0;j < group; j++)
                list.add(a[i + j]);
            Collections.reverse(list);
            for(int j = 0;j < group; j++)
                a[i + j] = list.get(j);
            list.clear();
        }
//        System.out.println(Arrays.toString(a));

    }
}
