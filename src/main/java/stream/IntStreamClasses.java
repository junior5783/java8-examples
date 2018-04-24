package stream;

import java.util.stream.IntStream;

public class IntStreamClasses {
    public static void main (String... args){
        /** IntStream.of(Array).sum()*/
        int[] array = {2,1,3,4,5,24,8,9};
        int total = java.util.stream.IntStream.of(array).sum();
        System.out.println(total);

        /**Lambda function*/
        IntStream.of(array).forEach(value -> System.out.printf("%s%d%n", "Valor Lambda expression : ", value));

        /**Reduce*/
        System.out.printf("Sum via deduce method : %d%n", IntStream.of(array).reduce(0, (x,y) -> x + y));
        System.out.printf("Product via deduce method : %d%n", IntStream.of(array).reduce(1, (x,y) -> x * y));

        IntStream.of(array)
                .filter(value -> value % 2 == 0 )
                .map(value-> value* 10)
                .sorted()
                .forEach(value -> System.out.printf("%d%n", value));
    }
}


