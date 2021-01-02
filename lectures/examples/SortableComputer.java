/**
 * Auto Generated Java Class.
 */
public class SortableComputer implements Comparable<SortableComputer>{
  public String processor;
  public int numCores;
  public double processorSpeed;
  
  public SortableComputer (String processor, 
                            int numCores,
                            double processorSpeed){
    this.processor = processor;
    this.numCores = numCores;
    this.processorSpeed = processorSpeed;  
  }
  
  public String toString(){
    return this.processor + " : " + this.numCores + " : " + 
      this.processorSpeed;
  }
  
  //compute power
  //power = numCores * processorSpeed
  public double computePower(){
    return numCores * processorSpeed;
  }
  
  //(1) returns 0 if this.computePower() == c.computePower()
  //(2) return > 0 if this.computePower() > c.computePower()
  //(3) return < 0 if this.computePower() < c.computePower()
  @Override
  public int compareTo(SortableComputer c){
    if(this.computePower() == c.computePower()){
      return 0; //(1)
    }
    else if(this.computePower() > c.computePower()){
      return 1; //(2)
    }
    else{
      return -1;
    }
    // return this.computePower() - c.computePower();
  }
  
  
}
