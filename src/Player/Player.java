package Player;

public class Player {
    private int currentPoint;
    private String name;

    public int getCurrentPoint() {
        return currentPoint;
    }

    public String getName() {
        return name;
    }

    public void setCurrentPoint(int currentPoint) {
        this.currentPoint = currentPoint;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player() {
    }

    public Player(String name) {
        this.name = name;
        this.currentPoint = 0;
    }
}
