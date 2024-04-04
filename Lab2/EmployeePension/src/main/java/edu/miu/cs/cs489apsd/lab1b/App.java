package edu.miu.cs.cs489apsd.lab1b;

import edu.miu.cs.cs489apsd.lab1b.entity.Employee;
import edu.miu.cs.cs489apsd.lab1b.entity.PensionPlan;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {


        PensionPlan p1 = new PensionPlan("EX1089",LocalDate.of(2023,01,17),
                100.00);
        PensionPlan p2 = new PensionPlan("SM2307",LocalDate.of(2019,11,04),
                1555.50);


        Employee daniel =new Employee(1,"Daniel","Agar",
                LocalDate.of(2018,01,17),
                105945.50,p1);
        Employee benard =new Employee(2,"Benard","Shaw",
                LocalDate.of(2019,04,03),
                197750.00,null);
        Employee carly =new Employee(3,"Carly","Agar",
                LocalDate.of(2014,05,16),
                842000.75,p2);
        Employee wesley =new Employee(4,"Wesley","Schneider",
                LocalDate.of(2019,05,02),
                74500.00,null);


        List<Employee> employeeList = List.of(daniel,benard,carly,wesley);

        List<Employee> sortedList = employeeList.stream().
                sorted(Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary,Comparator.reverseOrder())
                ).collect(Collectors.toList());




    printList(sortedList);
        System.out.println(" Monthly Upcoming Enrollees ");
    printUpcomingEnrolles(sortedList);



    }

    private static void printUpcomingEnrolles(List<Employee> sortedList) {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfNextMonth = today.plusMonths(1).withDayOfMonth(1);
        LocalDate lastDayOfNextMonth = firstDayOfNextMonth.plusMonths(1).minusDays(1);
        System.out.println("[");
        sortedList.stream().
                filter(s -> s.getPensionPlan() == null)
                .filter(employee -> employee.getEmploymentDate().plusYears(5).isBefore(lastDayOfNextMonth.plusDays(1)))
                .filter(employee -> employee.getEmploymentDate().plusYears(5).isAfter(firstDayOfNextMonth.minusDays(1)))

                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .forEach(s -> System.out.println(s.toJSONString()));
        System.out.println("]");

    }

    private static void printList(List<Employee> sortedList) {
        System.out.println("[");

        sortedList.stream().forEach(s -> System.out.println(s.toJSONString()));
        System.out.println("]");

    }
}
