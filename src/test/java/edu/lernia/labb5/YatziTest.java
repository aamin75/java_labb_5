package edu.lernia.labb5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class YatziTest {
	
    @Test
    void isYatziWhenAllDiceMatches() {
        Dice[] dice = new Dice[5];
    	YatziMain.initiateDice();
        for(int i = 0; i < dice.length; i++) {
        	dice[i]= new Dice();
            dice[i].value = 6;
        }
        //Assert something?
        assertTrue(YatziMain.isYATZI());
        
    }


	@Test
    void isNotYatziWhenOneDieIsNotMatchingTheOther() {
        Dice[] dice = new Dice[5];
        YatziMain.initiateDice();
        for(int i = 0; i < dice.length-1; i++) {
        	dice[i]= new Dice();
            dice[i].value = 6;
        }
        dice[dice.length-1]= new Dice();
        dice[dice.length-1].value = 1;
        //Assert something?
        assertTrue(YatziMain.isYATZI());
    }
}
