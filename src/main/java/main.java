import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
public class main
{
    public static void main(String[] args) {
        System.out.println("Welcome to currency converter");
         boolean a = true;
           while (a = true) {
        System.out.println("Please choose an option (1/2):");
        System.out.println("1. Dollars to Shekels - USD TO ILS"); //USD TO ILS
        System.out.println("2. Shekels to Dollars - ILS TO USD"); //ILS TO USD
        Scanner myObj = new Scanner(System.in);
        int type = myObj.nextInt();
        System.out.println("Please enter an amount to convert");
        Scanner myObj1 = new Scanner(System.in);
        double amount = myObj.nextDouble();
        ArrayList<Double>myList = new ArrayList<Double>();
        for (int i = 0; i <=myList.size();i++) {
            if (type == 1) {
                Coin newUSD = CoinFactory.getCoinInstance(CoinEnum.USD);
                USD usd = new USD();
                double Value = usd.calculate(amount);

                System.out.println("The converted value is equal" + " " + Value);
                myList.add(Value);
            }
             else if (type == 2) {
                Coin newILS = CoinFactory.getCoinInstance(CoinEnum.ILS);
                ILS ils = new ILS();
                double Value = ils.calculate(amount);
                System.out.println("The converted value is equal" + " " + Value);
                myList.add(Value);
            }
            System.out.println("Would you like to continue converting more values?");
            Scanner s1 = new Scanner(System.in);
            boolean ans = s1.nextBoolean();
            if (ans == true)
            {
                a = true;
            }
            else if (ans == false)
            {
                a = false;
                System.out.println("Thanks for using our currency converter");
                for (int j = 0 ; j> myList.size();j++)
                {
                    System.out.println(myList.get(j));
                }
                File result = new File("result");
                for (int k = 0 ; k> myList.size();k++)
                {
                    double str = myList.get(k);

                }

            }
        }
        }

}
}
