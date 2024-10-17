class Student {
    private String name;
    private String id;
    private String[] courses;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.courses = null;
    }

    public void addCourses(String[] courseList) {
        this.courses = new String[courseList.length];
        for (int i = 0; i < courseList.length; i++) {
            this.courses[i] = courseList[i];
        }
    }

    public String toString() {
        String courseString = "";
        if (courses.length > 0) {
            courseString = courses[0];
            for (int i = 1; i < courses.length; i++) {
                courseString += ", " + courses[i];
            }
        }
        return "Student Name: " + name + ", ID: " + id + ", Courses: " + courseString;
    }
}

public class StudentTester {
    public static void main(String[] args) throws Exception {
        Student s1 = new Student("John","123");
        Student s2 = new Student("Eric","124");
        
        String[] courseList = {"English", "History", "Mathematics"};
        s1.addCourses(courseList);
        courseList[0] = "Chemistry";
        s2.addCourses(courseList);

        System.out.println(s1); // Output: Student Name: John, ID: 123, Courses: English, History, Mathematics
        System.out.println(s2); // Output: Student Name: Eric, ID: 124, Courses: Chemistry, History, Mathematics
    }
}