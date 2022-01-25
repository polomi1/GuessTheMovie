package com.company;
import java.io.File;
//import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        //loading file
        File file = new File("movies.txt");
        Scanner scanner = new Scanner(file);
        int counterMovie = 0;
        String[] movies = new String[99];
        while (scanner.hasNext()) {
            movies[counterMovie] = scanner.nextLine();
            counterMovie += 1;
        }

        //Choosing the movie
        char[] theMovie = movies[(int) (Math.random() * counterMovie)].toCharArray();
        char[] theHiddenMovie = new char[theMovie.length];
        for (int i = 0; i < theMovie.length; i++) {
            if(theMovie[i]==' '){
                theHiddenMovie[i] = ' ';
            } else {
                theHiddenMovie[i] = '_';
            }
        }

//        System.out.println("You are guessing: " + String.valueOf(theMovie));

        boolean letterGuessed = false;
        String wrongGuessLetters = "";
        int round = 0;
        Scanner scanner2 = new Scanner(System.in);
        while(wrongGuessLetters.length()<10){
            letterGuessed = false;
            System.out.println("You are guessing: " + String.valueOf(theHiddenMovie));
            System.out.println("Round: "+round+".You have guessd ("+wrongGuessLetters.length()+") wrong letters:" +wrongGuessLetters);
            System.out.println("Guess the letter: ");
            char guessedChar = scanner2.next().charAt(0);
            for(int j = 0; j<theMovie.length; j++){
                if(theMovie[j]==guessedChar){
                    theHiddenMovie[j] = theMovie[j];
                    letterGuessed = true;
                }
                if(!letterGuessed && j == theMovie.length-1){
                    wrongGuessLetters += guessedChar;
                }
            }
            round +=1;
            //Winning
            int counter = 0;
            for(int u = 0; u<theMovie.length; u++){
                if(theHiddenMovie[u]=='_'){
                    counter += 1;
                }
            }
            if(counter == 0){
                System.out.println("You win!!!");
                break;
            }
        }
        if(wrongGuessLetters.length()==10){
            System.out.println("You lose :(");
        }
        }

    }