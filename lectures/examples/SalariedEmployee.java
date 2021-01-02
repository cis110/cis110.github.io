public class SalariedEmployee implements Employee{
    private String name;
    private double payRate;
    
    public SalariedEmployee(String name, double payRate){
      this.name = name;
      this.payRate = payRate;
    }
    
    @Override
    public String getName(){
      return name;
    }
    
    @Override
    public double weeklyPay(){
      return payRate;
    }
  
  
  
  
}