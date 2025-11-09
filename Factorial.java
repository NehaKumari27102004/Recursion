package Recursion;

import java.util.*;
public class Factorial {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter the number:");
        int num=sc.nextInt();
        long result=factorialIterative(num);
        System.out.println("The factorial of this number is:" + result);
        long result2=factorial(num);
        System.out.println("According to the recursion the factorial of number is:" + result2);
    }

    public static long factorialIterative(int num){
        long result=1;
        for(int i=1; i<=num; i++){
            result *=i;
        }

        return (result);
    }

    public static long factorial(int num){

        System.out.println("function call the number is " + num);
        if(num==1){
            return 1;
        }else{
            return(num * factorial(num-1));
        }

    }
}
