import java.util.Scanner;

class StudentInfo {
    String name;
    int age;
    double marks;
    String Course;
    int CourseCredits;
    public StudentInfo(String studentName, int rollNumber, double marks, String courseName, int courseCredits) {
        this.name = studentName;
        this.age = rollNumber;
        this.marks = marks;
        this.Course = courseName;
        this.CourseCredits = courseCredits;
    }
    public boolean checkEligibility() {
        return this.marks >= 50;
    }
    public double calculateFee() {
        return this.CourseCredits * 1500.0;
    }
    public double calculateScholarship() {
        double fee = calculateFee();
        if (this.marks >= 85) {
            return fee * 0.20; // 20% scholarship
        } else if (this.marks >= 70 && this.marks <= 84) {
            return fee * 0.10; // 10% scholarship
        } else {
            return 0.0;        // No scholarship
        }
    }
    public double calculateFinalFee() {
        return calculateFee() - calculateScholarship();
    }
    public void displayStudentInfo() {
        System.out.println("\n--- Student Registration Details ---");
        System.out.println("Student Name       : " + name);
        System.out.println("Roll Number        : " + age);
        System.out.println("Marks              : " + marks);
        System.out.println("Course Name        : " + Course);
        System.out.println("Course Credits     : " + CourseCredits);
        System.out.println("Eligibility Status : Eligible");
        System.out.println("Total Course Fee   : Rs. " + calculateFee());
        System.out.println("Scholarship Amount : Rs. " + calculateScholarship());
        System.out.println("Final Payable Fee  : Rs. " + calculateFinalFee());
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter Roll Number: ");
        int rollNumber = scanner.nextInt();
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter Course Name: ");
        String courseName = scanner.nextLine();
        System.out.print("Enter Course Credits: ");
        int courseCredits = scanner.nextInt();
        StudentInfo student = new StudentInfo(studentName, rollNumber, marks, courseName, courseCredits);
        if (student.checkEligibility()) {
            student.displayStudentInfo();
        } else {
            System.out.println("\nRegistration Failed: Student is not eligible for registration due to low marks (Required: 50 or above).");
        }
        scanner.close();
    }
}
