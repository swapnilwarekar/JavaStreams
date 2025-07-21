package in.swapnilwarekar;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamOpsPractice {
    public static void main(String[] args) {

        List<String> fruitList = Arrays.asList("apple", "kiwi", "banana", "mango", "pineapple");

        fruitList.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println(fruitList);

        List<Employee> employees = Arrays.asList(
                new Employee(1, "A", "IT", 60000d),
                new Employee(2, "B", "HR", 75000d),
                new Employee(3, "C", "IT", 80000d),
                new Employee(4, "D", "HR", 80000d),
                new Employee(5, "E", "IT", 90000d)
        );

         Map<String, List<Employee>> secondHighest = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream().sorted(
                                        Comparator.comparingDouble(Employee::getSalary).reversed()
                                ).skip(1).limit(1).toList()
                        )
                )
        );

        System.out.println(secondHighest);

        List<Integer> integerList = Arrays.asList(13, 14, 13, 30, 15, 30, 18, 20, 30, 20, 40, 80, 70, 23, 24, 25);

        Map<Integer, Long> intCount = integerList.stream().collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(intCount);


        Map<String, List<Employee>> thirdHighest = employees.stream().collect(
                Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream().sorted(
                                        Comparator.comparingDouble(Employee::getSalary).reversed()
                                ).skip(2).limit(1).toList()
                        )
                )
        );
        System.out.println(thirdHighest);
    }
}
