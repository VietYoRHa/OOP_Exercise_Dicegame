package Player;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class VirtualPlayer extends Player{
    private String failMessage;
    public static int seqVPlayer = 0;
    private static List<String> lstFailMessage = Arrays.asList("Error 404: Success not found", "Mission: Failure", "Oops", "Nooooo");
    private Random random = new Random();

    public VirtualPlayer() {
        this.failMessage = lstFailMessage.get(random.nextInt(lstFailMessage.size()));
        seqVPlayer++;
        String vPlayerName = "VirtualPlayer" + seqVPlayer;
        this.setName(vPlayerName);
    }

    public String getFailMessage() {
        return failMessage;
    }
}
