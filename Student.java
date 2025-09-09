
public record Student(String name, int age, String grade) {
    @Override
    public String toString(){
        return String.format("\nName: %s; Age: %d; Grade: %s", name, age, grade);
    }
}
