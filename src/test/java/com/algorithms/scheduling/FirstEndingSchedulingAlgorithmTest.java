
package com.algorithms.scheduling;

import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.fest.assertions.Assertions;

import com.algorithms.scheduling.FirstEndingSchedulingAlgorithm;
import com.algorithms.scheduling.TimeInterval;

/**
 * @author Kent McHenry
 */
public class FirstEndingSchedulingAlgorithmTest {

  
  @org.junit.Test
  public void testFromBook(){
    
    //           1         2         3         4         5         6         7
    // 01234567890123456789012345678901234567890123456789012345678901234567890123456789
    //          Tarjan of the Jungle            Four Volume Problems
    //         |--------------------|       |--------------------------|
    //                                                         Process Terminated
    //                            Steiners Tree              |--------------------|
    //                            |-----------|   Programming Challenges
    //   The Presidents Algorist                 |--------------|
    //  |-----------------------|                                    Calculated Bets
    //                       Halting State                         |-----------------|            
    //                        |--------|
    //    Discrete Mathematics
    //     |----------------|
    //           1         2         3         4         5         6         7
    // 01234567890123456789012345678901234567890123456789012345678901234567890123456789
    
    Set<TimeInterval> intervals = new HashSet<TimeInterval>();
    intervals.add(new TimeInterval("Tarjan of the Jungle", instantiate(8L), instantiate(29L)));
    intervals.add(new TimeInterval("Four Volume Problems", instantiate(37L), instantiate(64L)));
    intervals.add(new TimeInterval("Steiners Tree", instantiate(27L), instantiate(39L)));
    intervals.add(new TimeInterval("Process Terminated", instantiate(54L), instantiate(75L)));
    intervals.add(new TimeInterval("The Presidents Algorist", instantiate(1L), instantiate(25L)));
    intervals.add(new TimeInterval("Programming Challenges", instantiate(42L), instantiate(57L)));
    intervals.add(new TimeInterval("Halting State", instantiate(23L), instantiate(32L)));
    intervals.add(new TimeInterval("Calculated Bets", instantiate(60L), instantiate(78L)));
    intervals.add(new TimeInterval("Discrete Mathematics", instantiate(4L), instantiate(21L)));
    
    FirstEndingSchedulingAlgorithm algorithm = new FirstEndingSchedulingAlgorithm();
    List<TimeInterval> answer = algorithm.accept(intervals);
    
    for(TimeInterval ti : answer){
      System.out.println(ti.getId());
    }
    
    
    Assertions.assertThat(answer)
      .as("accepted intervals")
        .hasSize(4);
    Assertions.assertThat(answer.get(0).getId())
      .as("0th item")
        .isEqualTo("Discrete Mathematics");
    Assertions.assertThat(answer.get(1).getId())
      .as("1st item")
        .isEqualTo("Halting State");
    Assertions.assertThat(answer.get(2).getId())
      .as("2nd item")
        .isEqualTo("Programming Challenges");
    Assertions.assertThat(answer.get(3).getId())
      .as("3rd item")
        .isEqualTo("Calculated Bets");
    
  }
  
  private Calendar instantiate(long l){
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(l);
    return cal;
  }
}
