package acmcoder.webank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class WeBank1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a[] = new int[n];
        int b[] = new int[n];
        for(int i = 0;i < n; i++){
            a[i] = scanner.nextInt();
        }
        for(int i = 0; i < n ;i++){
            b[i] = scanner.nextInt();
        }
        int s[] = new int[n];
        s[0] = a[0] - b[0];

        for(int i = 1; i < n;i++){
            s[i] = a[i] - b[i] + s[i - 1];
        }
        int minPos = 0;
        int min = s[0];
        for(int i = 1;i < n;i++){
            if(s[i] < min) {
                minPos = i;
                min = s[i];
            }
        }
        int buff = 0;
        int increat = 1;
        if(min <= 0) {
            while ((increat - min) % (minPos + 1) != 0) increat++;
            buff = (increat - min) / (minPos + 1);
        }
        System.out.println(buff);
    }
}
