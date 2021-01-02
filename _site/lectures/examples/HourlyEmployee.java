public class HourlyEmployee implements Employee{
  private String name;
  private double payRate;
  
  public HourlyEmployee(String name, double payRate){
    this.name = name;
    this.payRate = payRate;
  }
  
  @Override
  public String getName(){
    return name; 
  }
  
  @Override
  public double weeklyPay(){
    return 40 * payRate;
  }
  
}