package Lesson3.PingPong;

public class PingPongThread extends Thread {

    public PingPongThread(String name) {
        this.setName(name);
    }

    @Override
    public void run() {
        Ball ball = Ball.getBall();
        while (ball.isInGame()) {
            kickBall(ball);
        }
    }

    private void kickBall(Ball ball) {
        if (!ball.getSide().equals(getName())) {
            ball.kick(getName());
        }
    }
}
