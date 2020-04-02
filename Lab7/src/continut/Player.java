package continut;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Random;

public class Player implements java.lang.Runnable {
    private String name;
    private Game game;

    Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    private boolean TakeToken() throws NullPointerException, InterruptedException {
        Random rand = new Random();
        int num = rand.nextInt(26);
        if (num >= 0 && num <= 26)
            for (Token p : game.getBoard().getTokenList())
                if (p.getValue() == num) {
                    game.getBoard().removeToken(num);
                    System.out.println(game.getBoard());
                    game.setBoard(game.getBoard());
                    return true;
                }
        return true;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Este randul playerului: " + this.getName());
                if (!TakeToken()) {
                    break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //implement the run() method, that will repeatedly create and submit words
    //implement the toString() method
}