class Student {
    private String firstName;
    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

   //Your code goes here
    public void printFullName() {
        System.out.println(firstName + " " + lastName);
    }
}

public class Tasksheet122 {
    public static void main(String[] args) {
        // Creating an array of students
        Student[] students = new Student[] {
            new Student("Morgan", "Freeman"),
            new Student("Brad", "Pitt"),
            new Student("Kevin", "Spacey"),
        };

        // Iterating over the students and calling the printFullName method
        for (Student s : students) {
            s.printFullName();
        }
    }
}
