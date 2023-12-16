package Referee;

import Dice.Dice;
import Player.Player;
import Player.VirtualPlayer;

import java.util.ArrayList;
import java.util.Random;

public class Referee {
    private ArrayList<Player> lstPlayer = new ArrayList<>();
    private ArrayList<Dice> lstDice = new ArrayList<>();
    private int turn;
    private int order;
    private boolean isGameOver;
    private Random random = new Random();

    public void addPlayer(Player player){
        lstPlayer.add(player);
    }

    public void addVPlayer(int numVPlayer){
        for (int i = 0; i < numVPlayer; i++){
            lstPlayer.add(new VirtualPlayer());
        }
    }

    public void start(){
        for (int i = 0; i < 4; i++){
            lstDice.add(new Dice());
        }
        turn = 0;
        isGameOver = false;
        order = -1;
        while(!isGameOver){
            nextPlayer();
        }
        System.out.println("Game Over !");
        gameOver();
    }

    public void nextPlayer(){
        turn++;
        order++;
        if (order == 4) order = 0;
        int chooseDice = random.nextInt(4);
        int resultDice = lstDice.get(chooseDice).roll(random);
        int curTotalPoint = lstPlayer.get(order).getCurrentPoint() + resultDice;
        if (curTotalPoint == 21){
            lstPlayer.get(order).setCurrentPoint(curTotalPoint);
            isGameOver = true;
        } else if (curTotalPoint > 21){
            lstPlayer.get(order).setCurrentPoint(0);
        } else {
            lstPlayer.get(order).setCurrentPoint(curTotalPoint);
        }
        System.out.println("Turn " + turn + ": Player " + lstPlayer.get(order).getName() + " choose (" + lstDice.get(chooseDice).getDiceName() + "), Roll Result: " + resultDice + ", Total Point: " + lstPlayer.get(order).getCurrentPoint());
    }

    public void gameOver(){
        System.out.println("\nDASHBOARD");
        System.out.println("----------------------------------------");
        for (int i = 0; i < 4; i++){
            System.out.println((i + 1) + ". " + lstPlayer.get(i).getName() + " - Total Point: " + lstPlayer.get(i).getCurrentPoint());
        }
        System.out.println("Winner: " + lstPlayer.get(order).getName());
        System.out.println("----------------------------------------");
        for (int i = 0; i < 4; i++){
            if (i == order) continue;
            if (lstPlayer.get(i) instanceof VirtualPlayer){
                System.out.println(lstPlayer.get(i).getName() + ": " + ((VirtualPlayer) lstPlayer.get(i)).getFailMessage());
            }
        }
    }
}
