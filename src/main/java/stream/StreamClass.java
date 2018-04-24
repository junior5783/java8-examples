package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamClass {
    public static void main (String... args){
        Integer[] values = {2,3,4,22,5,5,8,0,1,4,10,8,10};
        System.out.printf("Original values %s%n", Arrays.asList(values));

        List<Integer> greaterThan4 = Arrays.stream(values)
                .filter(value -> value > 4)
                .sorted()
                .collect(Collectors.toList());

        System.out.printf("%s%n", greaterThan4.stream().sorted().collect(Collectors.toList()));
    }
}
