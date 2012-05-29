
package com.algorithms.scheduling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

/**
 * @author Kent McHenry
 */
public class FirstEndingSchedulingAlgorithm implements SchedulingAlgorithm {
  
  /**
   * Comparator that sorts using {@link TimeInterval} end time.
   */
  private final Comparator<TimeInterval> END_TIME_COMPARATOR = new Comparator<TimeInterval>() {
    public int compare(TimeInterval a, TimeInterval b) {
      if(a.getEnd().getTimeInMillis() < b.getEnd().getTimeInMillis()){
        return -1;
      }
      if(a.getEnd().getTimeInMillis() > b.getEnd().getTimeInMillis()){
        return 1;
      }
      return 0;
    }
  };

  public List<TimeInterval> accept(Set<TimeInterval> intervals) {

    List<TimeInterval> acceptedIntervals = new ArrayList<TimeInterval>();
    
    // sort the intervals in increasing order of end time
    List<TimeInterval> sorted = new ArrayList<TimeInterval>();
    sorted.addAll(intervals);
    Collections.sort(sorted, END_TIME_COMPARATOR);
    
    // accept the first ending interval while ignoring any that intersect
    // all incrementing of i is done within the j loop
    for (int i = 0; i < sorted.size(); i++) {
      TimeInterval accepted = sorted.get(i);
      acceptedIntervals.add(accepted);
      
      // look ahead and skip any intervals that intersect the accepted item
      for (int j = i+1; j < sorted.size(); j++) {
        TimeInterval next = sorted.get(j);
        if(accepted.intersects(next)){
          // skip this item because it intersects an item that is accepted
          continue;
        } else {
          // move i loop to this item so it will be added (including
          // the i++) and break j loop
          i = j-1;
          break;
        }
      }
    }
    
    return acceptedIntervals;
    
  }

}
