package Coin;

import java.io.Serializable;

public class USD extends Coin implements Serializable {
    final static double usdValue = 3.52;

    @Override
    public double getValue() {
        return usdValue;
    }

    @Override
    public double calculate(double input) {

        return input * getValue();
    }
}
