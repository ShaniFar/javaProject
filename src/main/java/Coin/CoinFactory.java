package Coin;

import Coin.Coin;

public class CoinFactory {
    public static Coin getCoinInstance(CoinEnum coin) {
        switch (coin) {
            case ILS:
                return new ILS();
            case USD:
                return new USD();
            default:
                return null;
        }
    }
}
