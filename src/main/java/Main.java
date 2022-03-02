import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner myObj = new Scanner(System.in);
        ArrayList<Double> myList = new ArrayList<>();
        boolean flag = true;
        double value;
        String input;
        int type = 0;
        double amount = 0.0;
        boolean amountFlag = false;
        String ans;


        System.out.println("Welcome to currency converter");
        while (flag) {
            do {
                System.out.println("Please choose an option (1/2):");
                System.out.println("1. Dollars to Shekels - USD TO ILS"); //USD TO ILS
                System.out.println("2. Shekels to Dollars - ILS TO USD"); //ILS TO USD
                input = myObj.next();
                try {
                    type = Integer.parseInt(input);
                    if (type != 1 && type != 2) {
                        System.err.println("Enter only 1 or 2");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Enter only number");
                }

            } while (type != 1 && type != 2);
            do {
                System.out.println("Please enter an amount to convert");
                input = myObj.next();
                try {
                    amount = Double.parseDouble(input);
                    amountFlag = false;
                } catch (NumberFormatException e) {
                    System.err.println("Enter only number");
                    amountFlag = true;
                }

            } while (amountFlag);

            if (type == 1) {
                Coin usd = CoinFactory.getCoinInstance(CoinEnum.USD);
                if (usd != null) {
                    value = usd.calculate(amount);
                    System.out.println("The converted value is equal" + " " + value);
                    myList.add(value);
                }
            } else { //type == 2
                Coin ils = CoinFactory.getCoinInstance(CoinEnum.ILS);
                if (ils != null) {
                    value = ils.calculate(amount);
                    System.out.println("The converted value is equal" + " " + value);
                    myList.add(value);
                }
            }


            System.out.println("Would you like to continue converting more values?\nwrite Y or N");
            ans = myObj.next();

            if (ans.equalsIgnoreCase("Y")) {
                flag = true;
            } else if (ans.equalsIgnoreCase("N")) {
                flag = false;
                System.out.println("Thanks for using our currency converter");
                for (int i = 0; i < myList.size(); i++) {
                    System.out.println(myList.get(i));

                }


                try {
                    FileWriter myWriter = new FileWriter("Results.txt");
                    for (int i = 0; i < myList.size(); i++) {
                        myWriter.write(myList.get(i) + "\n");
                    }
                    myWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else System.out.println("You can enter only Y or T");
            flag = true;

        }
    }

}

