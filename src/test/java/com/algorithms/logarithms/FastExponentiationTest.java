package com.algorithms.logarithms;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class FastExponentiationTest {

  @Test
  public void testPower(){
    long a = 2;
    long n = 0;
    for (int i = 0; i < 23; i++) {
      n = i;
      Assertions.assertThat(FastExponentation.power(a,n))
        .as("power(a,n)")
          .isEqualTo(Math.round(Math.pow(a,n)));
    }
  }
}
