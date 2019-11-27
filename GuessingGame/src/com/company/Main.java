package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String... args) {
	Scanner sc = new Scanner(System.in);
	boolean gameOver;
	String question;
	String answer;
	boolean positive = true;
	Guesser guesser = new Guesser();

        System.out.println("Загадайте животное");
        do {
            question = guesser.askQuestion();
            System.out.println("Это существо "+question+"?");
            answer = sc.nextLine().toLowerCase();
            if(answer.equals("да")) {
                guesser.getAnswer(positive);
            } else guesser.getAnswer(!positive);
            gameOver = guesser.isGameOver();
        }
        while(!gameOver);
    }
}