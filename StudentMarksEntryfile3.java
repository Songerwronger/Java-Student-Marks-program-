import java.util.Scanner;

public class StudentMarksEntryfile3 {

    public static void main(String[] args) {

        // My custom variables for the program
        final int NUM_STUDENTS = 15;
        final int NUM_SUBJECTS = 6;
        final String[] SUBJECT_NAMES = {"English Literature", "Geography", "History", "Business Studies", "Maths", "English Language"};

        // Create a 2D array to store student marks 
        int[][] studentMarks = new int[NUM_STUDENTS][NUM_SUBJECTS];

        // Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // Loop through each student and subject_
        for (int student = 0; student < NUM_STUDENTS; student++) {
            for (int subject = 0; subject < NUM_SUBJECTS; subject++) {
                boolean validInput = false;
                while (!validInput) {
                    System.out.print("Enter marks for Student " + (student + 1) + " - " + SUBJECT_NAMES[subject] + ": ");
                    if (scanner.hasNextInt()) {
                        int marks = scanner.nextInt();
                        if (marks >= 0 && marks <= 100) {
                            studentMarks[student][subject] = marks;
                            validInput = true;
                        } else {
                            System.out.println("Invalid input. Marks must be between 0 and 100.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter an integer.");
                        scanner.next(); // Consume the invalid input if the number isnt a whole number
                    }
                }
            }
            System.out.println(); // Add an extra line between students
        }

        // Display the complete table of marks
        System.out.println("Complete Table of Marks:");
        for (int student = 0; student < NUM_STUDENTS; student++) {
            System.out.println("Student " + (student + 1) + ":");
            for (int subject = 0; subject < NUM_SUBJECTS; subject++) {
                System.out.println(SUBJECT_NAMES[subject] + ": " + studentMarks[student][subject]);
            }
            System.out.println(); // Add an extra line between students
        }

        // Identify and print the top students in Maths and English Language
        findTopStudents(studentMarks, SUBJECT_NAMES);

        // Calculate and print the average marks and grades for each student
        calculateAndPrintStudentGrades(studentMarks, SUBJECT_NAMES);

        // Close user input the Scanner
        scanner.close();
    }

    public static void findTopStudents(int[][] studentMarks, String[] subjectNames) {
        // Custom variables
        int highestMathScore = -1;
        int highestEnglishScore = -1;
        String topMathStudent = "";
        String topEnglishStudent = "";
        int topMathScore = -1;
        int topEnglishScore = -1;
    
        // Loop through each student and saving their score 
        for (int student = 0; student < studentMarks.length; student++) {
            int mathScore = studentMarks[student][4]; // index of 4 and 5 
            int englishScore = studentMarks[student][5]; 
    
            // Replacing the old highest marks with the new to keep track of which student has the highest marks in maths
            if (mathScore > highestMathScore) {
                highestMathScore = mathScore;
                topMathStudent = "Student " + (student + 1);
                topMathScore = mathScore;
            }
    
            // Replacing the old highest marks with the new to keep track of which student has the highest marks in english language 
            if (englishScore > highestEnglishScore) {
                highestEnglishScore = englishScore;
                topEnglishStudent = "Student " + (student + 1);
                topEnglishScore = englishScore;
            }
        }
    
        // Prints the students with the highest marks in both Maths and English Language 
        System.out.println("Top Student in Maths: " + topMathStudent + " with a score of " + topMathScore);
        System.out.println("Top Student in English Language: " + topEnglishStudent + " with a score of " + topEnglishScore);

        System.out.println(); // Blank line

    }





    public static void calculateAndPrintStudentGrades(int[][] studentMarks, String[] subjectNames) {
        // Print table header
        System.out.printf("%-15s%-20s%-13s%n", "Student", "Average Marks", "Grade");
    
        // Loop through each student
        for (int student = 0; student < studentMarks.length; student++) {
            int totalMarks = 0;
            // Calculate the total marks for the student
            for (int subject = 0; subject < studentMarks[student].length; subject++) {
                totalMarks += studentMarks[student][subject];
            }
            // Calculate the average marks
            double averageMarks = (double) totalMarks / studentMarks[student].length;
    
            // Determine the grade based on the average marks
            String grade;
            if (averageMarks >= 80) {
                grade = "A";
            } else if (averageMarks >= 70) {
                grade = "B";
            } else if (averageMarks >= 60) {
                grade = "C";
            } else if (averageMarks >= 50) {
                grade = "D";
            } else {
                grade = "E";
            }
    
            System.out.println(); // Blank line


            // Print the student number, average marks, and grade in a formatted table
            System.out.printf("%-15s%-20d%-13s%n", "Student " + (student + 1), (int)averageMarks, grade);


        }
    }
}



































