package com.algorithms.interview;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class MarbleDropTest {

  @Test
  public void test(){
    
    int buildingHeight = 1000000;
    
    for (int i = 1; i <= buildingHeight; i++) {
      
      int lowestBreakingFloor = i;
      
      MarbleDrop marbleDrop = new MarbleDrop(buildingHeight, lowestBreakingFloor);
      Assertions.assertThat(marbleDrop.findLowestBreakFloorWithInfiniteMarbles())
        .as("lowest floor that breaks marble")
          .isEqualTo(lowestBreakingFloor);
      Assertions.assertThat(marbleDrop.getDroppedMarbles())
        .as("number of dropped marbles")
           .isLessThanOrEqualTo((int)Math.round(Math.log(buildingHeight) / Math.log(2)));
    }
  }
}
