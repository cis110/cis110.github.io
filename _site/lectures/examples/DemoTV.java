public class DemoTV {
  public static void main(String[] args) {
    TV tv1 = new TV();
    
    System.out.print("Setting TV to channel 20...");
    boolean success = tv1.setChannel(20);
    if (success) System.out.println("Success");
    else         System.out.println("Failed");
    
    System.out.println("The current channel is "+ tv1.getChannel());
    
    System.out.print("Setting TV to channel 200000...");
    success = tv1.setChannel(200000);
    if (success) System.out.println("Success");
    else         System.out.println("Failed");
    
    System.out.println("The current channel is "+ tv1.getChannel());
  }
}

class TV {
  private int channel;
  
  public TV() {
    channel = 03;
  }
  
  public boolean setChannel(int channel) {
      if (isValidChannel(channel)) {
          this.channel = channel;
          return true;
      }
      return false;
  }
  
  private boolean isValidChannel(int channel) {
    return channel > 0 && channel <= 200;
  }
  
  public int getChannel() { return channel; }
  
 
}