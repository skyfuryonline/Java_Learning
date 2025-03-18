package Lab_1;

import org.w3c.dom.ls.LSInput;
import java.io.IOError;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.Scanner;

public class Lab {
    public static void main(String[] args) {
//        task_1();
//        task_2();
//        task_3();
//        task_4();
//        task_5();
//        task_6();
//        task_7();
    }
    static void task_1(){
        for(int i=1;i<=9;i++){
            for(int j=1;j <= i;j++){
                //按行进行观察，第一个元素从1到i，第二个元素是当前行的位置
                System.out.print(j+"x"+i+"="+i*j+" ");
            }
            System.out.println();
        }
    }
    static void task_2(){
        int n = 5;
        for(int i=1;i<=n;i++){
            //第i行的空格数=最后一行星数-当前星数=2*n-1-(2*i-1)=2(n-i)
            int space = 2*(n-i);

            for(int k = 1;k<=space/2;k++)
                System.out.print(" ");
            for (int k = 1;k<=2*i-1;k++)
                System.out.print("*");
            for (int k = 1;k<=space/2;k++)
                System.out.print(" ");
            System.out.println();
        }
    }
    static void task_3(){
        Scanner scan = new Scanner(System.in);
        float salary = scan.nextFloat();
        float res = salary-3500;
        if(res<=0)
            System.out.println("tax is "+0);
        else{
            if(res<=1500)
                System.out.println("tax is "+res*0.03);
            else if(res<=4500)
                System.out.println("tax is "+(res*0.1-105));
            else if(res<=9000)
                System.out.println("tax is "+(res*0.2-555));
            else if(res<=35000)
                System.out.println("tax is "+(res*0.25-1005));
            else if(res<=55000)
                System.out.println("tax is "+(res*0.3-2755));
            else if(res<=80000)
                System.out.println("tax is "+(res*0.35-5505));
            else{
                System.out.println("tax is "+(res*0.45-13505));
            }
        }
    }
    static void task_4(){
        int n = 10000;
        boolean [] nums = new boolean[n+1];

        //类似vector的数组
        ArrayList<Integer>list = new ArrayList<>();
        //初始假设所有下标对应的数都是素数
        Arrays.fill(nums,true);
        for(int i=2;i<=n;i++){
            if(nums[i]){
                list.add(i);
                //如果一个数是素数，则它的倍数一定不是素数
                for(int j=i*i;j<=n;j+=i){
                    nums[j]=false;
                }
            }
        }
        System.out.println("平均值是： "+list.stream().reduce(0,Integer::sum)/n);

        int len = list.size();
        for(int i=len-1;i>=0;i--){
            if(list.get(i)<8000){
                System.out.println("小于 8000 的最大素数是："+ list.get(i));
                break;
            }
        }
        for(int i=0;i<len;i++){
            if(list.get(i)>1000){
                System.out.println("大于 1000 的最小素数是："+ list.get(i));
                break;
            }
        }
//        /*
//        平均值是： 573
//        小于 8000 的最大素数是：7993
//        大于 1000 的最小素数是：1009
//        */
    }
    static void task_5(){
        int [][] matrix = new int [5+1][6+1];
        for(int i=0;i<5;i++){
            matrix[i][6] = -10000;
        }
        for(int j=0;j<6;j++){
            matrix[5][j] = 10000;
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<6;j++){
                matrix[i][j]=i*i-(j-i)*(j-i)+10;
                matrix[i][6] = Math.max(matrix[i][6], matrix[i][j]);
                matrix[5][j] = Math.min(matrix[5][j], matrix[i][j]);
            }
        }
        System.out.println("数组中每行最大值如下：");
        for(int i=0;i<5;i++){
            System.out.print(matrix[i][6]+" ");
        }
        System.out.println();
        System.out.println("数组中每列最小值如下：");
        for(int j=0;j<6;j++){
            System.out.print(matrix[5][j]+" ");
        }
        /*
        数组中每行最大值如下：
        10 11 14 19 26
        数组中每列最小值如下：
        10 9 6 1 -6 -15
        */
    }
    static void task_6(){
        //使用动态规划：C(n,k) = C(n-1,k-1)+C(n-1,k)
        int n = 30,k = 7;
//        double [][] C = new double [30+1][7+1];
        double [][] C = new double [n+1][k+1];
        for(int i=0;i<=n;i++) {
            C[i][0] = 1;
        }
        for(int j=0;j<=k;j++){
            C[j][j] = 1;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                if(i>=j && i-1>=j){
                    C[i][j]=C[i-1][j-1]+C[i-1][j];
                }
            }
        }
        System.out.println("从"+n+"个数中选"+k+"个数，有："+C[n][k]+" 种选法");
        //从30个数中选7个数，有：2035800.0 种选法
    }
    static void task_7(){
        int n = 100;
        //存储分母
        ArrayList<Double> list = new ArrayList<>();
        for(int i=1;i<=n;i++){
            list.add(2*i-1.0);
        }
        double pi = 0.0;
        for(int i=0;i<n;i++){
            pi += 1/list.get(i)*Math.pow(-1,i);
        }
        System.out.println("估算的pi的值是： "+4*pi);
        //n=100,估算的pi的值是： 3.1315929035585537
        //n=1000,估算的pi的值是： 3.140592653839794
        //n=10000,估算的pi的值是： 3.1414926535900345
    }
    static void task_8(){

    }
}
