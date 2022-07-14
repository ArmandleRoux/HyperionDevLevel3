import java.util.Collections;
import java.util.ArrayList;

public class Main {

  static ArrayList<Course> courses1 = new ArrayList<>();

  public static void main(String[] args) {

    // Adding courses.
    courses1.add(new Course("Java", 100, "Jason Clark"));
    courses1.add(new Course("JavaScript", 150, "Jason Clark"));
    courses1.add(new Course("C++", 30, "Robert Knowledge"));
    courses1.add(new Course("C#", 90, "Peter Sharp"));
    courses1.add(new Course("Python", 150, "Micheal Serpent"));

    drawLine();
    for(Course course : courses1) {
      System.out.println(course.toString());
    }

    // Sort by students
    drawLine();
    sortListByStudents(courses1);

    for(Course course : courses1) {
      System.out.println(course.toString());
    }

    // Swap elements at position 1 and 2.
    Course temp = courses1.get(1);
    courses1.set(1, courses1.get(0));
    courses1.set(0, temp);

    drawLine();
    System.out.println(courses1.get(0).toString());
    System.out.println(courses1.get(1).toString());
    drawLine();

    // Adding courses to second list
    ArrayList<Course> courses2 = new ArrayList<>();
    Collections.addAll(courses2,
            new Course("Java Intermediate", 50, "Jason Clark"),
            new Course("JavaScript Intermediate", 100, "Jason Clark"),
            new Course("C++ Intermediate", 10, "Robert Knowledge"),
            new Course("C# Intermediate", 50, "Peter Sharp"),
            new Course("Python Intermediate", 120, "Micheal Serpent"));

    // Add all Course objects in courses1 to course2
    courses2.addAll(courses1);

    courses2.add(new Course("Java 101", 55, "Dr. P Green"));
    courses2.add(new Course("Advanced Programming", 93, "Prof. M Milton"));

    // Sorting by course name.
    drawLine();
    sortListByCourse(courses2);
    for (Course course : courses2) {
      System.out.println(course.toString());
    }
    drawLine();

    // Search for "Java 101"
    for (Course course : courses2) {
      if (course.getCourseName().equals("Java 101")) {
        System.out.println("Index: " + courses2.indexOf(course));
      }
    }

    // Determine whether arrayLists have elements in common.
    drawLine();
    if (!Collections.disjoint(courses1, courses2)) {
      System.out.println("disjoint result: " + Collections.disjoint(courses1, courses2));
      System.out.println("courses1 and courses2 have elements in common.");
    }

    // Find course with max students
    drawLine();
    Course maxStudents = courses2.get(0);
    for (int i =1; i < courses2.size(); i++) {
      if(maxStudents.getNumOfStudents() < courses2.get(i).getNumOfStudents()) {
        maxStudents = courses2.get(i);
      }
    }
    if (maxStudents != null) {
      System.out.println("Most students:" + maxStudents.toString());
    }

    // Find course with least students.
    drawLine();
    Course minStudents = courses2.get(0);
    for (int i =1; i < courses2.size(); i++) {
      if(minStudents.getNumOfStudents() > courses2.get(i).getNumOfStudents()) {
        minStudents = courses2.get(i);
      }
    }
    if (minStudents != null) {
      System.out.println("Least students:" + minStudents.toString());
    }

  }

  /* Method sorts arrayList of Course objects by the Number of students. */
  public static void sortListByStudents(ArrayList<Course> courses) {
    for (int i = courses.size() - 1; i >= 0; i--) {
      for(int x = 1; x<=i ; x++) {
        if (courses.get(x -1).getNumOfStudents()
              > courses.get(x).getNumOfStudents()) {
          Course temp = courses.get(x-1);
          courses.set(x -1, courses.get(x));
          courses.set(x, temp);
        }
      }
    }
  }

  /* Method sorts arrayList of Course objects by the Name of course. */
  public static void sortListByCourse(ArrayList<Course> courses) {
    for (int i = (courses.size() - 1); i >= 0; i--) {
      for (int j = 1; j <= i; j++) {
        if (courses.get(j - 1).getCourseName().compareTo(courses.get(j).getCourseName()) > 0) {
          Course temp = courses.get(j - 1);
          courses.set(j - 1, courses.get(j));
          courses.set(j, temp);
        }
      }
    }
  }

  // Method draws line to console.
  public static void drawLine() {
    System.out.println("---------------------------------------------------------");
  }

}
