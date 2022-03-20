package com.ds.Recursion;

public class Pow {
    
    public static double myPow(double x, int n) {

    	double res = 0.0;
       if(n > 0 )
       res =  helper(x, n);else {
    	   res = 1/helper(x, -n);
       }
        return res;
    }

    public static double helper(double x, int n){

        if(n == 0) return 1;

        if(n % 2 == 0){

            return helper(x*x,n/2) ;
        }else{
            return x*helper(x, (n-1)) ;
        }

    }

    public static void main(String[] args){

        System.out.println(myPow(2.00000,20));



    }
}