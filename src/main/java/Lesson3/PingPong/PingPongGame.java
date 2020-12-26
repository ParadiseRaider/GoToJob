package Lesson3.PingPong;

public class PingPongGame {
    PingPongThread player1 = new PingPongThread("Ping");
    PingPongThread player2 = new PingPongThread("Pong");

    Ball ball;

    public PingPongGame() {
        ball = Ball.getBall();
    }

    public void startGame() {
        player1.start();
        player2.start();
    }
}
