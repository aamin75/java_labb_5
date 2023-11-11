package edu.lernia.labb5;

public class Dice extends BoardGameMaterial {
    public int value = 0;

    public Dice() {
        value = (int) Math.random();
    }

    public int diceRoll() {
        value = (int)(Math.random()*6+1);
        return value;
    }

    // this function never used, I will not keep on it?
	/*
	 * public int DieReroll() { return DieRoll(); }
	 */

    public String getString() {
        return "Dice shows " + value;
    }
}
