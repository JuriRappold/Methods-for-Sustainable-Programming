import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Lecture_03_Practical_Func_Pro {
    public static void main(String[] args){
        System.out.println("Hello and welcome!");
        System.out.println("");

        var students = List.of(
                new Student("Anna", 20, "4"),
                new Student("Kalle", 29, "3"),
                new Student("Max", 22, "U"),
                new Student("Eva", 19, "U"),
                new Student("Olle", 24, "4"),
                new Student("Jenny", 33, "5"),
                new Student("Per", 21, "3"),
                new Student("Tomas", 18, "4")
        );
        //finding all students w/ grade 4 - imperative programming:
        System.out.println("All students w/ Grade 4:");
        for(int index = 0; index < students.size(); index++){
            if(students.get(index).grade().equals("4")){
                System.out.println(students.get(index).name());
            }
        }

        //finding all students w/ grade 4- imperative w/ for-each loop
        System.out.println("");
        System.out.println("All students w/ Grade 4:");
        for(var student : students){
            if(student.grade().equals("4")){
                System.out.println(student.name());
            }
        }

        //finding all students w/ grade 4 - declarative programming (func pro)
        System.out.println("");
        System.out.println("All students w/ Grade 4:");
        students.stream().filter(s -> s.grade().equals("4")).map(s ->s.name()).forEach(System.out::println);

        //finding all students w/ grade 4 - declarative programming (func pro) w/ predicate variable
        System.out.println("");
        System.out.println("All students w/ Grade 4:");
        Predicate<Student> hasGradeFour = s -> s.grade().equals("4");
        Function<Student, String> mapGradeToName = s -> s.name(); //IDE Vorschlag: method reference: Student::name
        students.stream().filter(hasGradeFour).map(mapGradeToName).forEach(System.out::println);

        //Avg passing grade:
        Function<Student,String> getGrades = Student::grade;
        Predicate<String> passingGrade = s -> !s.equals("U");
        Function<String, Integer> toInt = Integer::parseInt;

/*
        List<Integer> passingGrades = students.stream().map(getGrades).filter(passingGrade).map(toInt).toList();
        IntStream average = (IntStream) passingGrades.stream();
        System.out.println(average.summaryStatistics());
*/
        Optional<Integer> sum_grades = students.stream()
                                               .map(getGrades)
                                               .filter(passingGrade)
                                               .map(toInt)
                                               .reduce((i, sum) -> {
                                                    sum+=i;
                                                    return sum;
                                                  }
                                               );
        Optional<Integer> count_grades = Optional.of(students.stream()
                                                 .map(getGrades)
                                                 .filter(passingGrade)
                                                 .toList().size());
        if(sum_grades.isPresent() && count_grades.isPresent()){
            int sum = sum_grades.get();
            int count = count_grades.get();
            System.out.printf("\nAverage Passing Grade: %d",(int)sum/count);
        }
    }

}
