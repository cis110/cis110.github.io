import org.junit.Test;
import static org.junit.Assert.*;

//Liskov substitution principle
//Everywhere an object of type a is needed
//an object of a subtype of A can be substituted
public class EmployeeTest{
  
  //Test SalariedEmployee constructor
  @Test
  public void testSalariedEmployeeConstructor(){
    Employee se = new SalariedEmployee("Alex", 1000);
    assertNotNull(se);
  }
  
  //Test Hourly Employee Constructor
  @Test
  public void testHourlyEmployeeConstructor(){
    Employee he = new HourlyEmployee("Emily", 25.3);
    assertNotNull(he);
  }
  
  //Test SalariedEmployee getName
  @Test
  public void testSalariedEmployeeGetName(){
    Employee ds = new SalariedEmployee("Daniel", 1000);
    assertEquals("Daniel", ds.getName());
  }
  
  //Test HourlyEmployee getName
  @Test
  public void testHourlyEmployeeGetName(){
    Employee jl = new HourlyEmployee("Juliette", 24.5);
    assertEquals("Juliette", jl.getName());
  }
  
  //Test SalariedEmployee weeklyPay
  @Test
  public void testSalariedEmployeeWeeklyPay(){
   Employee en = new SalariedEmployee("Emmanuel", 1100);
   assertEquals(1100, en.weeklyPay(), 0.001);
  }
  
  //Test hourlyEmployee weeklyPay
  @Test
  public void testHourlyEmployeeWeeklyPay(){
    Employee gb = new HourlyEmployee("Gabrielle", 20);
    assertEquals(800, gb.weeklyPay(), 0.001);
  }
  
  @Test
  public void testTotalWeeklyPay(){
    Employee[] employees = new Employee[2];
    Employee gb = new HourlyEmployee("Gabrielle", 20);
    Employee en = new SalariedEmployee("Emmanuel", 1100);
    employees[0] = gb;
    employees[1] = en;
    double total = 0;
    for(int i = 0; i < 2; i++){
      total = total + employees[i].weeklyPay();
    }
    assertEquals(1900, total, 0.001);
  }
  
  
}