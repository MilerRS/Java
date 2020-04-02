package continut;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Token {
    private final Integer value;

    public Token(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Token " + value;
    }
}
