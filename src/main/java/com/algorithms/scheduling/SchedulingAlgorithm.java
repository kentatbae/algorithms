
package com.algorithms.scheduling;

import java.util.List;
import java.util.Set;


/**
 * @author Kent McHenry
 */
public interface SchedulingAlgorithm {

  public List<TimeInterval> accept(Set<TimeInterval> interval);
}
