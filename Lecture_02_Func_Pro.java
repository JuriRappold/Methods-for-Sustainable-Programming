import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Collectors;


import java.security.SecureRandom;
import java.util.Arrays;
import java.util.IntSummaryStatistics;

public class Lecture_02_Func_Pro {
    public static void main(String[] args){
        SecureRandom randomNumbers = new SecureRandom();
        //Chpt: 17.2
        //summing first 10 ints w/ for loop (called external iteration)
        int total = 0;
        for(int number = 1; number<=10; number++){
            total+=number;
        }

        //summing first 10 ints w/ stream (called internal iteration)
        int stream_total = IntStream.rangeClosed(1,10)
                                    .sum();
        //System.out.println("For-Loop total: "+ total);
        //System.out.println("Stream Total: "+ stream_total);

        //Chpt: 17.3
        //sum of all even numbers up to & including 20
        /*System.out.println(IntStream.rangeClosed(1,10)
                                    .map((int x) -> {return x * 2;}) //--> intermediate op
                                    .sum()); //--> terminal & reductive op*/
        /*
        (int x) -> {return x * 2;} ==> lambda expression
        (x) -> {return x * 2;} ==> omitted type of parameter
        (x) -> x*2; ==> simplified lambda, only possible if the body ( {statements;} ) has only one statement
        x -> x*2 ==> if only one parameter, one can omit the paranthesis
         */

        //another intermediate operation filter, this operation can be done w/o the filtering operation(Task 17.8)
        /*System.out.println(IntStream.rangeClosed(1,10)
                                    .filter(x -> x%2==0)//filters out the even numbers and passes them to the next step in the pipeline
                                    .map(x -> x*3)
                                    .sum());

        System.out.println(IntStream.rangeClosed(1,10)
                                    .map(x -> {
                                        int y=0;
                                        if(x%2==0) {
                                            y = x * 3;
                                        }
                                        return y;
                                    })
                                    .sum());*/
        //Each Element goes through each intermediate operation before the next element "begins"
        //only for streams w/ a terminal op?
        /*System.out.print(IntStream.rangeClosed(1, 10)
                .filter(
                        x -> {
                            System.out.printf("%nfilter: %d%n", x);
                            return x % 2 == 0;
                        })
                .map(
                        x -> {
                            System.out.println("map: " + x);
                            return x * 3;
                        })
                .sum());*/
        //17.6
        /*System.out.println("Random Numbers:");
        randomNumbers.ints(10,1,7).forEach(System.out::println);
        System.out.printf("%nRandom Numbers: %s", randomNumbers.ints(10,1,7)
                                                                .mapToObj(String::valueOf)
                                                                .collect(Collectors.joining(", ")));//terminal
*/
        /*
        randomNumbers == IntStream
        both are data sources creating streams

        .collect(Collectors.joining(", ")));
        is smart enough to not put a ", " behind the last element
         */
        //17.7
        /*
        int[] values = {0,4,2,1,5,7,6,9,3};
        IntStream test = IntStream.of(values); // cool
        System.out.printf("\nOriginal Values: %s",test.mapToObj(String::valueOf).collect(Collectors.joining("; ")));
        //Does a terminal operation close a stream? yes
        System.out.printf("\nCount: %d", IntStream.of(values).count());
        System.out.printf("\nMin: %d", IntStream.of(values).min().getAsInt());
        System.out.printf("\nMax: %d", IntStream.of(values).max().getAsInt());
        System.out.printf("\nSum: %d", IntStream.of(values).sum());
        System.out.printf("\nAvg: %.9f%n",IntStream.of(values).average().getAsDouble());
        System.out.printf("\nSum w/ reduce method: %d", IntStream.of(values).reduce(0,(x,y) -> x+y));
        System.out.printf("\nSum w/ reduce method & method reference: %d\n", IntStream.of(values).reduce(0, Integer::sum));

        //summaryStatistics
        IntSummaryStatistics testing = IntStream.of(values).summaryStatistics();
        System.out.printf("\nMax: %d",testing.getMax());
        System.out.printf("\nMin: %d", testing.getMin());
        System.out.printf("\nAvg: %.9f", testing.getAverage());
        System.out.printf("\nSum: %d", testing.getSum());
        System.out.printf("\nCount: %d", testing.getCount());
        */
        //17.11
        /*String[] string = {"Blue", "red", "green", "Yellow", "PURPLE", "white", "BLACK","Juri"};
        System.out.printf("strings less than n: %s\n", Arrays.stream(string)
                                                          .filter(s -> s.compareToIgnoreCase("n")<0)
                                                          .sorted(String.CASE_INSENSITIVE_ORDER)
                                                          .collect(Collectors.toList()));
        String[] strings = new String[4];
        int index = 0;
        for(int i = 0; i<string.length;i+=2) {
            if(String.CASE_INSENSITIVE_ORDER.compare(string[i], string[i + 1])<0){
                strings[index]=string[i];
                index++;
            }
        }
        System.out.println(Arrays.toString(strings));*/
        Predicate<Integer> storing_boolean_lamda = i -> i%2==0;
        IntPredicate is_even = i -> i%2==0;//same thing as above, but doesn*t work w/ .filter?
        Predicate<Integer> greaterThanFive = i -> i>5;
        //generates random numbers & stores them in a List<Integer>
        List<Integer> integerList = randomNumbers.ints(10,1,20).boxed().toList();
        System.out.println(integerList);
        //prints only the even number
        System.out.println(integerList.stream().filter(storing_boolean_lamda).sorted().collect(Collectors.toList()));
        System.out.println(integerList.stream().filter(storing_boolean_lamda.and(greaterThanFive)).sorted().collect(Collectors.toList()));

    }
}

