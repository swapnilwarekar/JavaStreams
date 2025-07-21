package in.swapnilwarekar;

import javax.swing.text.html.Option;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamOpsPractice2 {
    public static void main(String[] args) {

        // How to create stream from list.
        List<String> strList = List.of("a", "b", "c", "d");
        Stream<String> strStream = strList.stream();

        // How to create stream from array
        int[] intArray = {1, 2, 3, 4};
        IntStream intStream = Arrays.stream(intArray);

        // Create Stream of
        Stream<String> strStream2 = Stream.of("test", "working", "model", "and", "streams");

        /******** Intermediate operations ******************/
        // They transform/modify stream and return another stream
        // Example: filter, map, sorted

        //filter: filters with condition.
        intStream.filter(i -> i % 2 ==0).forEach(System.out::println);

        //map: converts each element using function.
        List<String> upperlist = strStream2.map(String::toUpperCase).toList();
        System.out.println(upperlist);

        //sorted: sorts element in natural order or defined comparator.
        Stream<String> strStream3 = Stream.of("test", "working", "model", "and", "streams");
        List<String>sortedList = strStream3.sorted((String s1, String s2) -> Integer.compare(s1.length(), s2.length())).toList();
        System.out.println(sortedList);

        // All the intermediate operations.
        // filter, map, flatMap, distinct, sorted, limit, skip, peek
        Stream<String> strStream4 = Stream.of("test", "working", "model", "and", "streams", "also", "operations", "and", "functionality", "with", "attributes");
        List<String> intermediateOpsList = strStream4.filter(s -> s.startsWith("a"))
                .map(String::toUpperCase)
                .distinct()
                .sorted()
                .limit(5)
                .peek(System.out::println)
                .collect(Collectors.toList());
        System.out.println(intermediateOpsList);

        List<String> l1 = List.of("One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten");
        List<String> l2 = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9", "10");
        List<List<String>> nested = List.of(l1, l2);

        List<String> flattened = nested.stream().flatMap(List::stream).toList();
        System.out.println(flattened);

        /********Terminal operations ******************/
        // Final step on the stream instance
        // It will produce the result (Value, Collection, Side Effect)
        // It consumes the stream instance and cannot be reused

        // forEach: Performs action for each element
        flattened.stream().forEach(s -> System.out.println(s.startsWith("T")));

        // collect: Converts the stream into collection
        List<String> upperCaseList = l1.stream().map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(upperCaseList);

        //reduce: Combine result into one e.g. summing of all the elements, first parameter is identity nothing but first combining value.
        Integer sumOfLengths = l1.stream().map(String::length).reduce(0, Integer::sum);
        System.out.println(sumOfLengths);

        //aggregates
        Integer multiplicationOfLengths = l1.stream().map(String::length).reduce(1, (a,b) -> a*b);
        System.out.println(multiplicationOfLengths);

        OptionalDouble avgOfLengths = l1.stream().mapToInt(String::length).average();
        System.out.println(avgOfLengths);

        OptionalInt max = l1.stream().mapToInt(String::length).max();
        System.out.println(max);

        //Count
        Long count = l1.stream().count();
        System.out.println(count);

        //Find First
        System.out.println(l1.stream().findFirst());

        //All Match
        System.out.println(l1.stream().allMatch(s -> s.startsWith("T")));

        //Any Match
        System.out.println(l1.stream().anyMatch(s -> s.startsWith("T")));

        //None Match
        System.out.println(l1.stream().noneMatch(s -> s.startsWith("P")));

        //Partitioning By
        List<Integer> intList = List.of(1,2,3,4,5,6,7,8,9,10);
        Map<Boolean, List<Integer>> partitionedInts = intList.stream().collect(Collectors.partitioningBy(n -> n > 5));
        System.out.println(partitionedInts);

        //Find second largest
        Optional<Integer> secondLargest = intList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println(secondLargest);

        List<Integer> oneToTen = IntStream.rangeClosed(1, 10).boxed().toList();
        System.out.println(oneToTen);
    }
}
