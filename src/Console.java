import Referee.Referee;

public class Console {
    public static void main(String[] args) {
        Referee referee = new Referee();
        referee.addVPlayer(4);
        referee.start();
    }
}
