
package com.algorithms.scheduling;

import java.util.Calendar;

/**
 * @author Kent McHenry
 */
public class TimeInterval {

  private final String id;
  private final Calendar start;
  private final Calendar end;
  
  public TimeInterval(String id, Calendar start, Calendar end){
    this.id = id;
    this.start = start;
    this.end = end;
  }
  
  /**
   * Returns true if this {@link TimeInterval} intersects (inclusive) the 
   * given <tt>interval</tt>
   * 
   * @param interval
   * @return
   */
  public boolean intersects(TimeInterval interval){

    // intersection test if this interval ends after the 
    // given interval starts or if this interval starts
    // before the given interval ends
    if(this.getEnd().getTimeInMillis() < interval.getStart().getTimeInMillis()){
      return false;
    }
    if(this.getStart().getTimeInMillis() > interval.getEnd().getTimeInMillis()){
      return false;
    }
    return true;
    
  }
  
  public String getId(){
    return id;
  }
  
  public Calendar getStart(){
    return start;
  }
  
  public Calendar getEnd(){
    return end;
  }
  
  public long getDuration(){
    return getEnd().getTimeInMillis() - getStart().getTimeInMillis();
  }
  
  public String toString(){
    return getId() + " ["+getStart().getTimeInMillis()+"-"+getEnd().getTimeInMillis()+"]";
  }
}
