package Player;

import java.util.Arrays;
import java.util.List;

public class VirtualPlayer extends Player{
    private String failMessage;
    private static int seqVPlayer = 0;
    private static List<String> lstFailMessage = Arrays.asList("Error 404: Success not found", "Mission: Failure", "Oops", "Nooooo");

    public VirtualPlayer() {
        this.failMessage = lstFailMessage.get(seqVPlayer);
        seqVPlayer++;
        String vPlayerName = "VirtualPlayer" + seqVPlayer;
        this.setName(vPlayerName);
    }

    public String getFailMessage() {
        return failMessage;
    }
}
