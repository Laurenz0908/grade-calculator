# Grade Calculator
## Introduction
This is a Java application that helps a student calculate his/her current grade in the course as well as
finding the average score (s)he will need to achieve a certain letter grade.

## Requirements
The final grade for the course will be based on the student's performance in Exam 1, Exam 2, Final Exam,
Labs, Quizzes, Projects and Attendance. The program prompts the user for the final letter grade (s)he
wants to obtain for the course. Then, the program should prompt the user to enter the weight each grading
item carries.

Afterwards, the program prompts the user if (s)he knows the score for each grading item in the course.
If the user enters "y" or "yes" (ignoring capitalization), the program asks him/her the score for that
grading item. Any other response is treated as a "no". The scores for each grading item are out of 100.
When prompting the user for the exam scores, the program should not prompt the user for exam 2 or the
final exam if the user does not know the score for exam 1. Similarly, if exam 2 is not known then the
program does not prompt for the final exam score.

Once the user has entered his/her desired final letter grade, the weights of all grading items and his/her
known scores, the program calculates and displays the current grade based on the current scores.

Then, the user's current letter grade is determined by checking the range his/her current score falls in
the course's grade scale. The program will display the current score and grade letter for the user.
Moreover, if the user has entered a score for all the course grading items, the program should indicate
in the message that score and letter grade corresponds to his/her final score and final letter.

The desired letter grade is achievable if the average score for the remaining grading item is not greater
than a 100. If the user's desired letter grade is achievable in this semester for the student, the
program prints the average score for the student to get that final letter grade. Otherwise, it prints
that the user cannot achieve that letter grade for the course.

## Formulas
*currentScore = sumOf((weightx * scorex)/totalKnownGradeWeight)*
* **weightx**: the weight of grading item *x*
* **scorex**: the score achieved in the grading item *x*
* **totalKnownGradeWeight**: sum of weights of the grading items of known scores

*avgToFinalLetterGrade = ((100 * finalOverallScore - sumOf(weightx * scorex))/(100 - totalKnownGradeWeight)*
* **finalOverallScore**: minimum score in the range of the letter grade the user wants to achieve in the course
* **weightx**: the weight of grading item *x*
* **scorex**: the score achieved in the grading item *x*
* **totalKnownGradeWeight**: sum of weights of grading items with known scores
