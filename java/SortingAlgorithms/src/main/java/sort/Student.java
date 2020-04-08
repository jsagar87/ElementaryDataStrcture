package sort;

import java.util.Comparator;

public class Student implements Comparable{

    private String name;

    private String section;

    public Student(String name,String section) {
        this.name = name;
        this.section = section;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSection() {
        return section;
    }

    public void setSection(String section) {
        this.section = section;
    }

    public static final Comparator<Student> BY_NAME = new ByName();
    public static final Comparator<Student> BY_SECTION = new BySection();

    public int compareTo(Object o) {
        Student that = (Student) o;
        return this.name.compareTo(that.name);
    }

    private static class ByName implements Comparator<Student> {
        public int compare(Student v, Student w) {
            return v.name.compareTo(w.name);
        }
    }

    private static class BySection implements Comparator<Student> {
        public int compare(Student v, Student w) {
            return v.section.compareTo(w.section);
        }
    }
}
