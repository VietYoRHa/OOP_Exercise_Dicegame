package Dice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Dice {
    private int diceID;
    private String diceName;
    private List<Integer> diceFace = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));
    private List<Integer> remainDiceFace;
    private static int seqDice = 0;

    public Dice() {
        diceFace.remove(seqDice);
        remainDiceFace = diceFace;
        seqDice++;
        String name = "Dice " + seqDice;
        this.diceName = name;
        this.diceID = seqDice;
    }

    public String getDiceName() {
        return diceName;
    }

    public int roll(Random random){
        double randomVal = random.nextDouble();
        if (randomVal < 0.2) return diceID;
        else {
            int randomIdx = random.nextInt(remainDiceFace.size());
            return remainDiceFace.get(randomIdx);
        }
    }
}
