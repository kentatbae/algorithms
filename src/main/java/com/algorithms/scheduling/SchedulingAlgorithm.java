
package com.algorithms.scheduling;

import java.util.List;
import java.util.Set;


/**
 * @author Kent McHenry
 */
public interface SchedulingAlgorithm {
  
  /**
   * Method for selecting items for <tt>intervals</tt>. Any algorithm should
   * select only a non-intersecting subset of the items contains within
   * <tt>intervals</tt>.
   * 
   * @param interval
   *          A set of {@link TimeInterval}s to select from
   * @return an ordered list of (non-intersecting) accepted {@link TimeInterval}
   *         s.
   */
  public List<TimeInterval> accept(Set<TimeInterval> intervals);
}
