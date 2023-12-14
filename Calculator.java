import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the total number of subjects: ");
        int numSubjects = input.nextInt();
        int totalMarks = 0;
        for (int i = 1; i <= numSubjects; i++) {
            int marks;
            do {
                System.out.print("Enter marks for Subject " + i + " (out of 100): ");
                marks = input.nextInt();
                if (marks < 0 || marks > 100) {
                    System.out.println("Marks should be between 0 and 100.......try again.");
                }
            } while (marks < 0 || marks > 100);
            totalMarks += marks;
        }
        double averagePercentage = (double) totalMarks / (numSubjects * 100) * 100;
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }
    System.out.println("Total Marks are: " + totalMarks);
        System.out.println("Average Percentage is: " + averagePercentage + "%");
        System.out.println("FiNAL Grade: " + grade);
   input.close();
    }
}
