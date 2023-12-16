import Dice.Dice;

import java.util.Random;

public class Console {
    public static void main(String[] args) {
        Random random = new Random();
        Dice dice1 = new Dice();
        System.out.println(dice1.getDiceName());
        for (int i = 1; i <= 20; i++) {
            System.out.print(dice1.roll(random) + " ");
        }
        System.out.println();
        Dice dice2 = new Dice();
        System.out.println(dice2.getDiceName());
        for (int i = 1; i <= 20; i++) {
            System.out.print(dice2.roll(random) + " ");
        }
        System.out.println();
    }
}
