/**
 * Auto Generated Java Class.
 */
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class StudentSortingDemo {
    public static void main(String[] args) {
        Student[] students = new Student[5];
        students[0] = new Student("John", "Smith", 1234, 0.85);
        students[1] = new Student("Sarah", "Brown", 0000, 0.83);
        students[2] = new Student("Jackie", "Brown", 4321, 0.95);
        students[3] = new Student("Aaron", "Aaronson", 9999, 0.67);
        students[4] = new Student("Steve", "Holt", -3, 0.02);
        
        //Student a = new Student("Jackie", "Brown", 4321, 0.95);
        //Student b = new Student("Sarah", "Brown", 0000, 0.83);
        
        //System.out.println(a.compareTo(b));
        
        Arrays.sort(students);
        
        for(int i = 0; i < 5; i++){
          System.out.println(students[i]);
        }
        
       System.out.println("======= List =======");
        
        List studentsList = new ArrayList();
        studentsList.add(new Student("John", "Smith", 1234, 0.85));
        studentsList.add(new Student("Sarah", "Brown", 0000, 0.83));
        studentsList.add(new Student("Jackie", "Brown", 4321, 0.95));
        studentsList.add(new Student("Aaron", "Aaronson", 9999, 0.67));
        studentsList.add(new Student("Steve", "Holt", -3, 0.02));
        
        Collections.sort(studentsList);
        
        for (int i = 0; i < studentsList.size(); i++) {
            System.out.println(studentsList.get(i));
        }
    }
}