
package com.algorithms.scheduling;

import java.util.Calendar;

import org.fest.assertions.Assertions;


/**
 * @author Kent McHenry
 */
public class TimeIntervalTest {

  @org.junit.Test
  public void testIntervalIntersections(){
    
    TimeInterval interval = new TimeInterval("test", instantiate(10L), instantiate(30L));
    

    //                      1         2         3
    //            0123456789012345678901234567890123456789
    //                      s-------------------e
    // case a         |---|
    // case b         |-----|
    // case c           |------|
    
    TimeInterval a = new TimeInterval("a", instantiate(4L), instantiate(8L));
    TimeInterval b = new TimeInterval("b", instantiate(4L), instantiate(10L));
    TimeInterval c = new TimeInterval("c", instantiate(6L), instantiate(12L));
   
    
    Assertions.assertThat(interval.intersects(a)).as("test case [a]").isFalse();
    Assertions.assertThat(interval.intersects(b)).as("test case [b]").isTrue();
    Assertions.assertThat(interval.intersects(c)).as("test case [c]").isTrue();
    
    //                      1         2         3
    //            0123456789012345678901234567890123456789
    //                      s-------------------e
    // case d               |---|
    // case e               |-------------------|
    // case f               |--------------------|
    // case g              |--------------------|
    // case h                               |---|
    
    TimeInterval d = new TimeInterval("d", instantiate(10L), instantiate(14L));
    TimeInterval e = new TimeInterval("e", instantiate(10L), instantiate(30L));
    TimeInterval f = new TimeInterval("f", instantiate(10L), instantiate(31L));
    TimeInterval g = new TimeInterval("g", instantiate(9L),  instantiate(30L));
    TimeInterval h = new TimeInterval("g", instantiate(26L), instantiate(30L));
    
    Assertions.assertThat(interval.intersects(d)).as("test case [d]").isTrue();
    Assertions.assertThat(interval.intersects(e)).as("test case [e]").isTrue();
    Assertions.assertThat(interval.intersects(f)).as("test case [f]").isTrue();
    Assertions.assertThat(interval.intersects(g)).as("test case [g]").isTrue();
    Assertions.assertThat(interval.intersects(h)).as("test case [h]").isTrue();
    
    
    //                      1         2         3
    //            0123456789012345678901234567890123456789
    //                      s-------------------e
    // case i                                     |---|
    // case j                                   |-----|
    // case k                                |------|
    TimeInterval i = new TimeInterval("i", instantiate(32L), instantiate(36L));
    TimeInterval j = new TimeInterval("j", instantiate(30L), instantiate(36L));
    TimeInterval k = new TimeInterval("k", instantiate(27L), instantiate(34L));
    
    Assertions.assertThat(interval.intersects(i)).as("test case [i]").isFalse();
    Assertions.assertThat(interval.intersects(j)).as("test case [j]").isTrue();
    Assertions.assertThat(interval.intersects(k)).as("test case [k]").isTrue();
  }
  
  private Calendar instantiate(long l){
    Calendar cal = Calendar.getInstance();
    cal.setTimeInMillis(l);
    return cal;
  }
}
