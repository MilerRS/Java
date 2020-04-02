package continut;

import java.util.ArrayList;
import java.util.List;


public class Board {
    private final List<Token> tokenList;

    Board() {
        tokenList = new ArrayList<>();
    }

    public List<Token> getTokenList() {
        return tokenList;
    }

    synchronized final void addToken (Token pioni ) throws NullPointerException {
        if ( pioni == null ) {
            throw new NullPointerException("Acest token nu are o valoare existenta!");
        }
        tokenList.add(pioni);
        System.out.println("Tokenul " + pioni.getValue() + " a fost introdus pe tabla ");
    }
    synchronized final void removeToken (int numar ) throws NullPointerException {
        tokenList.remove(numar);
        System.out.println("Tokenul " + numar + " a fost scos de pe tabla.");

    }

    @Override
    public String toString() {
        return "Board " + tokenList;
    }
}