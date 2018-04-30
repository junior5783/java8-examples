package stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StreamClass {
    public static void main (String... args){
        Integer[] values = {2,3,4,22,5,5,8,0,1,4,10,8,10};
        String[] strings = {"Red","orange","Yellow","green","ana","nip"};
        Person[] persons = {
                new Person("Junior","Sanchez", 27, 1500.00),
                new Person("Abel", "Encalada",17, 1200.00),
                new Person("Abel", "Encalada",17, 1100.00),
                new Person("Emanuel","Tesen", 22,8000.00),
                new Person("Olenka","Carmen",25, 7300.00)
        };

        /**Integer Stream*/
        //integerStream(values);

        /**Strings Stream*/
        //stringsStream(strings);

        /**Object Stream*/
        //objectStream(persons);

        /**Object Stream with predicate*/
        //predicate(persons);

        /** Sorted by 2 fields*/
        //sorted(persons);

        /**distinct*/
        distinct(persons);

    }

    public static void distinct (Person[] persons) {
        List<Person> list = Arrays.asList(persons);
        list.stream()
                .map(Person::getName)
                .distinct()
                .sorted()
                .forEach(System.out::println);


    }

    public static void sorted ( Person[] persons ) {
        Function<Person, String> byFirstName = Person::getName;
        Function<Person, String> byLastName = Person::getLastName;
        // Function<Person, String> byLastName = (Person p) -> {return p.getLastName();};

        Comparator<Person> lastThenFirst = Comparator
                .comparing(byLastName)
                .thenComparing(byFirstName);

        List<Person> list = Arrays.asList(persons);
        System.out.printf("%nPerson in ascending order by FirstName and LastName: %n");
        list.stream()
                .sorted(lastThenFirst)
                .forEach(System.out::println);

        List<Person> list2 = Arrays.asList(persons);
        System.out.printf("%nPerson in descending order by FirstName and LastName: %n");
        list2.stream()
                .sorted(lastThenFirst.reversed())
                .forEach(System.out::println);

    }

    public static void predicate( Person[] persons ) {
        Predicate<Person> salaryGreaterTo1000 =
                p -> (p.getSalary()>1000 && p.getAge() > 22);

        List<Person> listPerson= Arrays.asList(persons);

        listPerson.stream()
                .filter(salaryGreaterTo1000)
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .forEach(System.out::println);

        System.out.printf("%n First person found : %s",
            listPerson.stream()
                    .filter(salaryGreaterTo1000)
                    .sorted(Comparator.comparing(Person::getSalary).reversed())
                    .findFirst()
                    .get());
    }

    public static void objectStream(Person[] persons){
        List<Person> listPersons = Arrays.asList(persons);
        listPersons.stream().forEach(System.out::println);
    }

    public static void integerStream(Integer[] values){
        System.out.printf("Original values %s%n", Arrays.asList(values));

        List<Integer> greaterThan4 = Arrays.stream(values)
                .filter(value -> value > 4)
                .sorted()
                .collect(Collectors.toList());
        System.out.printf("%s%n", greaterThan4.stream().sorted().collect(Collectors.toList()));
    }

    public static void  stringsStream (String[] strings){
        System.out.printf("String %s%n", Arrays.stream(strings)
                .map(String::toUpperCase)                       /**String::toUpperCase => (String s) -> {return s.toUpperCase();}*/
                .collect(Collectors.toList()));

        System.out.printf("String %s%n", Arrays.stream(strings)
                .filter(s->s.compareToIgnoreCase("m") > 0)
                .sorted(String.CASE_INSENSITIVE_ORDER)
                .collect(Collectors.toList()));

        System.out.printf("String %s%n", Arrays.stream(strings)
                .filter(s->s.compareToIgnoreCase("m") > 0)
                .sorted(String.CASE_INSENSITIVE_ORDER.reversed())
                .collect(Collectors.toList()));
    }
}
