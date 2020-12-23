package Lesson3.PingPong;

public class Ball {
    private int kicks = 0;
    private static Ball instance = new Ball();
    private String side = "";

    private Ball() {}

    static Ball getBall() {
        return instance;
    }

    public synchronized void kick(String playerName) {
        kicks++;
        side = playerName;
        System.out.println(kicks + " " + side);
    }

    public String getSide() {
        return side;
    }

    public boolean isInGame() {
        return kicks<15;
    }
}
