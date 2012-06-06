package com.algorithms.logarithms;

public class FastExponentation {

  public static int steps = 0;
  
  public static long power(long a, long n){
    steps++;
    // recursion base case a^0 == 1
    if(n == 0) return 1;
    long x = power(a, Math.round(Math.floor(n/2)));
    if(n%2 == 0) {
      return x * x;
    } else {
      return a * x * x;
    }
  }
  
  public static void resetSteps(){
    steps = 0;
  }
}
