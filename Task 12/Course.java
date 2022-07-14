public class Course {
  String courseName;
  int numOfStudents;

  String courseLecturer;

  public Course(String courseName, int numOfStudents, String courseLecturer) {
    this.courseName = courseName;
    this.numOfStudents = numOfStudents;
    this.courseLecturer = courseLecturer;
  }

  public String toString() {
    String result = "(" + courseName + ", ";
    result += courseLecturer + ", ";
    result += numOfStudents + ")";
    return result;
  }

  public String getCourseName() {
    return courseName;
  }

  public int getNumOfStudents() {
    return numOfStudents;
  }

  public String getCourseLecturer() {
    return courseLecturer;
  }

  public void setCourseName(String courseName) {
    this.courseName = courseName;
  }

  public void setNumOfStudents(int numOfStudents) {
    this.numOfStudents = numOfStudents;
  }

  public void setCourseLecturer(String courseLecturer) {
    this.courseLecturer = courseLecturer;
  }

}
