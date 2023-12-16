import Player.Player;
import Referee.Referee;

import java.util.Scanner;

public class Console {
    private static Referee referee = new Referee();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int userOption;
        do{
            menu();
            userOption = scanner.nextInt();
            scanner.nextLine(); // Erase "Enter" char
            switch (userOption){
                case 1:
                    newGame();
                    break;
                case 2:
                    System.out.println("Goodbye !");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again !");
            }
        } while (userOption != 2);
        scanner.close();
    }

    private static void menu(){
        System.out.println("****************************************");
        System.out.println("*               DICE GAME              *");
        System.out.println("****************************************");
        System.out.println("1. Start new game");
        System.out.println("2. Exit");
        System.out.print("Your option: ");
    }

    private static void newGame(){
        int userInput;
        String name;
        referee.clearPlayer();
        do {
            System.out.print("\nNumber of players (from 0 to " + Referee.MAX_PLAYER + "): ");
            userInput = scanner.nextInt();
            scanner.nextLine();
        } while (userInput < 0 || userInput > Referee.MAX_PLAYER);
        for (int i = 0; i < userInput; i++){
            System.out.print("Player " + (i + 1) + " name: ");
            name = scanner.nextLine();
            referee.addPlayer(new Player(name));
        }
        referee.addVPlayer(Referee.MAX_PLAYER - userInput);
        referee.start();
    }
}
