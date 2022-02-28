import java.io.Serializable;

public class ILS extends Coin implements Serializable{
    final static double ilsValue =  0.28;
    @Override
    public double getValue()
    {
        return ilsValue;
    }

    @Override
    public double calculate(double input)
    {

        return input * getValue();
    }
}
