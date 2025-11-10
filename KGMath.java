package Recursion;

public class KGMath {
    public static void main(String[] args) {
        System.out.println(Math.abs(-33));
        System.out.println(Math.ceil(5.08));
        System.out.println(Math.floor(99.9));
        System.out.println(Math.round(44.986));
        System.out.println(Math.max(44,66));
        System.out.println(Math.min(648,877));
        System.out.println(Math.pow(3.8,0.9));
        System.out.println(Math.sqrt(64.0));
        System.out.println(Math.exp(5.6));
        System.out.println(Math.log(1.4));
        System.out.println(Math.sin(30.0));
        System.out.println(Math.random());

        // if we want to print the multiple times the new and unique random number

        for(int i=0; i<10; i++){
             int random=(int) Math.round(Math.random() *100);
            System.out.println(random);
        }
    }
}
