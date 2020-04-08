package sort.sample.clients;

import edu.princeton.cs.algs4.StdOut;
import sort.MergeSort;
import sort.Student;

public class StudentSorter {
    public static void main(String[] args) {
        Student s1 = new Student("Shanay", "A1");
        Student s2 = new Student("Aravind", "A2");
        Student s3 = new Student("Sonnu", "A4");
        Student s4 = new Student("Mukesh", "A3");
        Student s5 = new Student("Mukund", "A5");
        Student s6 = new Student("Deepak", "A6");
        Student s7 = new Student("Parishi", "A7");
        Student s8 = new Student("Divya", "A8");

        Student[] students = {s1,s3,s4,s2,s5,s7,s8,s6};

        StdOut.println("Before ::");
        for(Student s : students) {
            StdOut.println(s.getName() + " " + s.getSection());
        }

        // Call for sort
        MergeSort.sort(students,Student.BY_SECTION);

        StdOut.println("\nAfter ::");
        for(Student s : students) {
            StdOut.println(s.getName() + " " + s.getSection());
        }
    }
}
