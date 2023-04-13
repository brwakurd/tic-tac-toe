import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {
    // Stats for users.
    public static void main(String[] args) {
        int[][] studentsPrototype = new int[5][3];
        int[][] students = readArray(studentsPrototype);

        int[] avg = avgCalc(students);
        int percentageOfSuccess = thirdExam(students);
        int maxAvg = maximumAverage(avg);
        System.out.println("The maximum/highest average is " + maxAvg + "%.");
        System.out.println("Percentage of studens who have passed the third exam is " + percentageOfSuccess + " %.");

        // the fifth question is asking to print all the elements using array overloading if you don't know whats that read this link https://www.mygreatlearning.com/blog/method-overloading-in-java/#:~:text=Method%20overloading%20in%20java%20is,name%2C%20but%20with%20different%20parameters.
        printElements(students);
        printElements(avg);
    }

    static void printElements(int[][] twoDimensional) {
        System.out.println("Printing two dimensionals..");
        for (int i = 0; i < twoDimensional.length; i++) {
            for (int j = 0; j < twoDimensional[i].length; j++) {
                System.out.print(twoDimensional[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void printElements(int[] oneDimensional) {
        System.out.println("Printing one dimensional...");
        for (int i = 0; i < oneDimensional.length; i++) {
            System.out.print(oneDimensional[i]);
        }
    }
    static int maximumAverage(int[] avg) { // Maximum average means, the highest average in the student (like by one student) zortrin m3adal // class nerd
        int maxAvg = avg[0];
        for (int i = 0; i < avg.length; i++) {
            if (avg[i] > maxAvg) {
                maxAvg = avg[i];
            }
        }
        //
        return maxAvg;
    }

    static int thirdExam(int[][] students) {
        int percentageAmt = 100 / students.length;
        int percentageOfSuccess = 0;
        for (int i = 0; i < students.length; i++) {
            if (students[i][2] > 50) {
                percentageOfSuccess += percentageAmt;
            }
        }
        return percentageOfSuccess;
    }

    static int[] avgCalc(int[][] students) {
        int[] avg = new int[students.length];
        for (int i = 0; i < students.length; i++) {
            int sum = 0;
            for (int j = 0; j < students[i].length; j++) {
                sum += students[i][j];
            }
            avg[i] = sum / students[i].length;
        }
        return avg;
    }
    static int[][] readArray(int[][] students) {
        Scanner s = new Scanner(System.in);

        for (int i = 0; i < students.length; i++) {
            System.out.println("Enter the grades for student " + (i+1));
            for (int j = 0; j < students[i].length; j++) {
                students[i][j] = s.nextInt();
            }
        }
        return students;
    }
}