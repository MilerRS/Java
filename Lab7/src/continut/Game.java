package continut;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board tabla;
    private final List<Player> players = new ArrayList<>();

    public Game() {
        tabla= new Board();
        Token pioni;
        for(int m=1;m<=26;m++) {
            pioni = new Token(m);
            tabla.addToken(pioni);
        }
        tabla.addToken(new Token(0));
        tabla.addToken(new Token(0));
        System.out.println(tabla);
    }

    public void addPlayer(Player player) {
        players.add(player);
        player.setGame(this);
    }

    public Board getBoard() {
        return tabla;
    }

    public void setBoard(Board tabla) {
        this.tabla = tabla;
    }

    public boolean checkBoard()
{
    if (tabla.getTokenList().isEmpty())
        return false;
    return true;
}
    public void start() {
        for (Player p : players) {
            new Thread(p).start();
        }
    }
}