package com.algorithms.interview;

/**
 * @author Kent McHenry
 */
public class MarbleDrop {

  private final int buildingHeight;
  private final int lowestBreakFloor;
  private int droppedMarbles;
  
  /**
   * 
   * @param buildingHeight
   * @param lowestBreakFloor
   */
  public MarbleDrop(int buildingHeight, int lowestBreakFloor){
    this.buildingHeight = buildingHeight;
    this.lowestBreakFloor = lowestBreakFloor;
    this.droppedMarbles = 0;
  }
  
  /**
   * Finds the lowest floor that breaks the marble within log2(n) steps where
   * n is the building height.
   * 
   * @return the lowest floor that breaks the marble
   */
  public int findLowestBreakFloorWithInfiniteMarbles(){
    
    int bottom = 1;
    int top = buildingHeight;
    int currentFloor = top/2;
    // successively halving gives a most log(n) steps
    while(true){
      // if top and bottom are equal break loop
      if(top == bottom) return currentFloor;
      // move lower in building
      if(marbleBreaks(currentFloor)){
        // current floor breaks marble, may be the lowest such floor
        top = currentFloor;
        // can't move below bottom
        currentFloor = Math.max(bottom, (top + bottom) / 2);
      } 
      // move higher in building  
      else {
        // confirm that current does not break the marble
        // no longer need to consider it
        bottom = currentFloor + 1;
        // can't move above top
        currentFloor = Math.min(top, (top + bottom) / 2);
      }
    }
  }
  
  /**
   * TODO left as exercise for the bold
   * @return
   */
  public int findLowestBreakFloorWithTwoMarbles(){
    return -1;
  }
  
  /**
   * Returns the number of marbles that were dropped
   * @return
   */
  public int getDroppedMarbles(){
    return droppedMarbles;
  }
  
  /**
   * Returns true if the the marble breaks when dropped from the given floor.
   * Each call to this method increase the <tt>droppedMarbles</tt> count.
   * @param floor
   * @return
   */
  private boolean marbleBreaks(int floor){
    droppedMarbles++;
    return floor >= lowestBreakFloor;
  }
}
