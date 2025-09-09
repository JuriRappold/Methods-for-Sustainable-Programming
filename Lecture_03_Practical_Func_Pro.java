import java.util.List;
import java.util.function.*;

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



    }

}
