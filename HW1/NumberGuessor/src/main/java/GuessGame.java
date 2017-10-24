import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.io.*;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;

public class GuessGame {
    @Getter @Setter private static double bestScore;
    private final static int DEFAULT_MAX = 50;

    private static void play(int max){

        Random random = new Random();
        int number = random.nextInt(abs(max));
        int i = 0;
        Integer guess = -1;
        Scanner scan = new Scanner(System.in);

        System.out.println("Make your guess:");
        while (number != guess){
            i++;
            guess = Integer.parseInt(scan.nextLine());
            if (guess < number){
                System.out.println("try bigger");
            }
            else if (guess > number){
                System.out.println("try smaller");
            }
        }
        double score = max/i;
        if (score > bestScore) bestScore = score;

        System.out.println("You get the right number");
        System.out.println("Congrats!");
        System.out.printf("Your score is %.3f %n", score);
    }

    private static int readMax() {
        JFrame frame = new JFrame("frame");
        //defaut value
        int max = DEFAULT_MAX;
        try {
            max = Integer.parseInt(JOptionPane.showInputDialog(frame, "Please enter max number to guess:"));
        }
        catch (Exception e){
            System.out.println("Invalid input argument, you should use only positive integer for the input.4");
            System.out.println("Used default value 50.");
        }

        return max;
    }

    private static void printBestScore(){
        System.out.printf("Best score: %.3f %n", bestScore);
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scan = new Scanner(System.in);
        String resp = "y";

        while (resp.equals("y")) {
            play(readMax());
            printBestScore();
            System.out.println("Do you want to play again?(y/n)");
            resp = scan.nextLine();
        }

        System.exit(0);
    }

}
