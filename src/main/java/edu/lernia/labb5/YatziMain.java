package edu.lernia.labb5;

import java.util.Scanner;

public class YatziMain {
    public static Dice[] dice;
    public static boolean beginGameIsOn = true;
    public static int iteration; 
    public static int maxIter = 3;
    public static int diceNum = 5; 
    

    private static void runRound() {
    	for(int i=0;i<dice.length;i++) {
            dice[i].diceRoll();
            //ds[i].value = 5; //Test if yatzi work
            System.out.println(i + ": " + dice[i].getString());
        }
    }
    
    public static boolean isYATZI() {
    	boolean flag = true; 
    	for(int j=1;j<dice.length;j++) {
             if(dice[j].value!=dice[j-1].value) {
                 //Set flag to false
                 flag = false;
             }
         }
         return flag;
    }
    
    public static void initiateDice() {
    	dice = new Dice[diceNum];
        for(int i=0;i<dice.length;i++) {
            dice[i] = new Dice();
        }
    }
    
    private static void playGame() {
        //We will continue until the game is over
        while(beginGameIsOn == true) {
            iteration = 0;
            System.out.println("Welcome to Yatzi!");
            while(iteration < maxIter) {
                System.out.println("Starting turn " + (iteration+1) + " of " + maxIter + ", rolling dice.");
                runRound();
                //YATZI
                boolean flag = isYATZI();
                
                if(flag == true) {
                    System.out.println("You got YATZI! in " + dice[0].value + "'s");
                    return;
                } else {
                    //Here we check if there is no Yatzy: then we check what turn we are on and asks the player if we want to continue or not
                    if(iteration != maxIter-1) {
                        System.out.println("Want to throw again? (y for yes, anything else for no)");
                        Scanner sc = new Scanner(System.in);
                        if(sc.next().equals("y")) {
                            ++iteration;
                        } else {
                            beginGameIsOn = !beginGameIsOn;
                            break;
                        }
                    } else {
                        System.out.println("Game over! Want to play again?");
                        Scanner sc = new Scanner(System.in);
                        if(sc.next().equals("y")) {
                            iteration = 0;
                        } else {
                            beginGameIsOn = !beginGameIsOn;
                            break;
                        }
                    }
                }
            }
        }    	
    }
    
    public static void main(String[] args) {

        initiateDice();
        playGame();

    }
}
