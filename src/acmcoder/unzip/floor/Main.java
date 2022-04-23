package acmcoder.unzip.floor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        int[] a = new int[length];
        for(int i = 0;i < length;i++){
            a[i] = scanner.nextInt();
        }


        ArrayList arrayList = new ArrayList();
        for(int i = 0;i < length;i++){
            arrayList.add(counts(i,a));
        }
        arrayList.stream().forEach(System.out::print);
    }
    public static int counts(int index,int[] a){
        int pre = 0 ;
        int count = 1;
        for(int i = index - 1; i >= 0; i--){
            if(a[i] >= pre) {count++;pre = a[i];}
        }
        pre = 0;
        for(int i = index + 1;i < a.length;i++){
            if(a[i] >= pre) {count++;pre = a[i];}
        }
        return count;
    }

}
class Solution{
    public int counts(int index,int[] a){
        int count = 1;
        for(int i = index - 1; i >= 0; i--){
            while(a[i] <= a[index]) count++;
        }
        for(int i = index + 1;i < a.length;i++){
            while(a[i] <= a[index]) count++;
        }
        return count;
    }
}