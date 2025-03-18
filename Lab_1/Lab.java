package Lab_1;

import java.util.Scanner;

public class Lab {
    public static void main(String[] args) {
        task_1();
        task_2();
        task_3();
        task_4();
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

    }
}
