/*
 * GradeCalculator.java
 * Authors: Cynthia He, Laurenz Holcik, and Evan Howell
 * Submission Date:
 *
 * Purpose: A Java application that helps a student calculate his/her current grade in 
 * the course as well as finding the average score (s)he will need to achieve a certain letter grade.
 *
 * Statement of Academic Honesty:
 *
 * The following code represents my own work. I have neither
 * received nor given inappropriate assistance. I have not copied
 * or modified code from any source other than the course webpage
 * or the course textbook. I recognize that any unauthorized
 * assistance or plagiarism will be handled in accordance with
 * the University of Georgia's Academic Honesty Policy and the
 * policies of this course. I recognize that my work is based
 * on an assignment created by the Department of Computer Science
 * at the University of Georgia. Any publishing
 * or posting of source code for this project is strictly
 * prohibited unless you have written consent from the Department
 * of Computer Science at the University of Georgia.
 */

import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {

        // variables
        String desiredGrade;
        String currentGrade;
        String currentLetter;
        int weightExam1 = 0;
        int weightExam2 = 0;
        int weightFinalExam = 0;
        int weightLabs = 0;
        int weightProjects = 0;
        int weightAttend = 0;
        int weightQuiz = 0;
        int totalWeight = 0;
        int scoreExam1 = 0;
        int scoreExam2 = 0;
        int scoreFinalExam = 0;
        int scoreLabs = 0;
        int scoreProjects = 0;
        int scoreAttend = 0;
        int scoreQuiz = 0;
        double avgToFinalLetterGrade = 0.0;
        double currentScore = 0.0;
        double finalOverallScore = 0.0;
        double totalKnownGradeWeight = 0.0;
        double weightXScore = 0.0;

        // user input - enter letter grade
        Scanner input = new Scanner(System.in);
        System.out.print("What letter grade do you want to achieve for the course? ");
        desiredGrade = input.nextLine().toUpperCase();

        // print grading scale
        System.out.println("Grading Scale: ");
        System.out.println("A \t 90 - 100");
        System.out.println("B \t 80 - 89");
        System.out.println("C \t 70 - 79");
        System.out.println("D \t 60 - 69");
        System.out.println("F \t below 	60");

        // prompt user if they entered an invalid grade
        if (!desiredGrade.equals("A") && !desiredGrade.equals("B") && !desiredGrade.equals("C")
                && !desiredGrade.equals("D") && !desiredGrade.equals("D")) {
            System.out.println("Input Error");
            System.exit(0);
        }

        // user input - enter percentage weights
        System.out.println("Enter Percentage Weights:");
        System.out.print("Exam 1: \t");
        weightExam1 = input.nextInt();
        System.out.print("Exam 2: \t");
        weightExam2 = input.nextInt();
        System.out.print("Final Exam: \t");
        weightFinalExam = input.nextInt();
        System.out.print("Labs: \t\t");
        weightLabs = input.nextInt();
        System.out.print("Projects: \t");
        weightProjects = input.nextInt();
        System.out.print("Attendance: \t");
        weightAttend = input.nextInt();
        System.out.print("Quizzes: \t");
        weightQuiz = input.nextInt();

        // if weights add up to 100
        totalWeight = weightExam1 + weightExam2 + weightFinalExam + weightLabs + weightProjects + weightAttend + weightQuiz;
        if (totalWeight != 100) {
            System.out.println("Weights don't add up to 100, program exiting...");
            System.exit(0);
        }

        // prompt user to enter scores out of a 100
        System.out.println("Enter your scores out of a 100:");

        // prompt user to enter exam 1 score
        System.out.print("Do you know your Exam 1 score? ");
        currentGrade = input.next().toUpperCase();
        if ("Y".equals(currentGrade) || "YES".equals(currentGrade)) {
            System.out.print("Score received on exam 1: ");
            scoreExam1 = input.nextInt();

            // prompt user to enter exam 2 score
            System.out.print("Do you know your Exam 2 score? ");
            currentGrade = input.next().toUpperCase();
            if ("Y".equals(currentGrade) || "YES".equals(currentGrade)) {
                System.out.print("Score received on exam 2: ");
                scoreExam2 = input.nextInt();

                // prompt user to enter final exam score
                System.out.print("Do you know your Final Exam score?");
                currentGrade = input.next().toUpperCase();
                if ("Y".equals(currentGrade) || "YES".equals(currentGrade)) {
                    System.out.print("Score received on final exam: ");
                    scoreFinalExam = input.nextInt();
                }
                else {
                    weightFinalExam = 0;
                }
            }
            else {
                weightExam2 = 0;
                weightFinalExam = 0;
            }
        }
        else {
            weightExam1 = 0;
            weightExam2 = 0;
            weightFinalExam = 0;
        }
        // prompt user to enter lab average
        System.out.print("Do you know your lab average? ");
        currentGrade = input.next().toUpperCase();
        if ("Y".equals(currentGrade) || "YES".equals(currentGrade)) {
            System.out.print("Average Lab Grade: ");
            scoreLabs = input.nextInt();
        }
        else {
            weightLabs = 0;
        }

        // prompt user to enter project average
        System.out.print("Do you know your project average? ");
        currentGrade = input.next().toUpperCase();
        if ("Y".equals(currentGrade) || "YES".equals(currentGrade)) {
            System.out.print("Average Project Grade: ");
            scoreProjects = input.nextInt();
        }
        else {weightProjects = 0;
        }

        // prompt user to enter quiz average
        System.out.print("Do you know your quiz average? ");
        currentGrade = input.next().toUpperCase();
        if ("Y".equals(currentGrade) || "YES".equals(currentGrade)) {
            System.out.print("Average Quiz Grade: ");
            scoreQuiz = input.nextInt();
        }
        else {
            weightQuiz = 0;
        }

        // prompt user to enter attendance average
        System.out.print("Do you know your attendance average? ");
        currentGrade = input.next().toUpperCase();
        if ("Y".equals(currentGrade) || "YES".equals(currentGrade)) {
            System.out.print("Average Attendance Grade: ");
            scoreAttend = input.nextInt();
        }
        else {
            weightAttend = 0;
        }

        // calculate current score & current letter grade
        weightXScore = weightExam1 * scoreExam1 + weightExam2 * scoreExam2 + weightFinalExam * scoreFinalExam + weightLabs * scoreLabs
                + weightProjects * scoreProjects + weightAttend * scoreAttend + weightQuiz * scoreQuiz;
        totalKnownGradeWeight = weightExam1 + weightExam2 + weightFinalExam + weightLabs + weightProjects + weightAttend + weightQuiz;
        currentScore = weightXScore / totalKnownGradeWeight;

        if (currentScore >= 90.0) {
            currentLetter = "A";
        }
        else if (currentScore >= 80.0 && currentScore < 90.0) {
            currentLetter = "B";
        }
        else if (currentScore >= 70.0 && currentScore < 80.0) {
            currentLetter = "C";
        }
        else if (currentScore >= 60.0 && currentScore < 70.0) {
            currentLetter = "D";
        }
        else {
            currentLetter = "F";
        }

        // print current score & letter grade
        System.out.printf("Current Grade Score: %1.2f\n" , currentScore);
        System.out.println("Your current letter grade is a " + currentLetter);

        // final letter grade output
        if (desiredGrade.equals("A")) {
            finalOverallScore = 90.0;
        }
        else if (desiredGrade.equals("B")) {
            finalOverallScore = 80.0;
        }
        else if (desiredGrade.equals("C")) {
            finalOverallScore = 70.0;
        }
        else if (desiredGrade.equals("D")) {
            finalOverallScore = 60.0;
        }
        else if (desiredGrade.equals("F")) {
            finalOverallScore = 0.0;
        }

        // prompt user if they already have the desired letter grade
        if (currentScore >= finalOverallScore) {
            System.out.println("Congratulations! You received the " + desiredGrade + " that you wanted!");
            System.exit(0);
        }

        // calculate average to final letter grade
        avgToFinalLetterGrade = (100 * finalOverallScore - weightXScore) / (100 - totalKnownGradeWeight);

        // print average to final letter grade if achievable
        if (avgToFinalLetterGrade <= 100) {
            System.out.printf("You have to score an average greater than or equal to %1.2f in the remaining grade "
                    + "items to receive an " + desiredGrade + " in the course", avgToFinalLetterGrade);
        }
        else {
            System.out.println("Sorry, you cannot receive an " + desiredGrade + " in the course");
        }
    }

}
