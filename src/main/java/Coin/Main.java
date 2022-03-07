package Coin;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner myObj = new Scanner(System.in);//Setting up a SCANNER
        ArrayList<Double> myList = new ArrayList<>();//Array definition
        //Setting Variables
        boolean flag = true;
        double value;
        String input;
        int type = 0;
        double amount = 0.0;
        boolean amountFlag = false;
        String ans;
        boolean ansFlag = true;

        System.out.println("Welcome to currency converter");
        //The program will run as long as the user wants to continue
        while (flag) {
            do {
                System.out.println("Please choose an option (1/2):");
                System.out.println("1. Dollars to Shekels - Coin.Coin.USD TO Coin.ILS"); //Coin.Coin.USD TO Coin.ILS
                System.out.println("2. Shekels to Dollars - Coin.ILS TO Coin.Coin.USD"); //Coin.ILS TO Coin.Coin.USD
                input = myObj.next();
                try { //Only digits 1 or 2 can be entered
                    type = Integer.parseInt(input);
                    if (type != 1 && type != 2) {
                        System.err.println("Enter only 1 or 2");
                    }
                } catch (NumberFormatException e) {//Only INT entries can be entered
                    System.err.println("Enter only number");
                }

            } while (type != 1 && type != 2);

            do {
                System.out.println("Please enter an amount to convert");
                input = myObj.next();
                try {
                    amount = Double.parseDouble(input);
                    amountFlag = false;
                } catch (NumberFormatException e) {//A test that can only enter numbers
                    System.err.println("Enter only number");
                    amountFlag = true;
                }

            } while (amountFlag);

            if (type == 1) {//In case the user entered a value of 1
                Coin usd = CoinFactory.getCoinInstance(CoinEnum.USD);
                if (usd != null) {
                    value = usd.calculate(amount);
                    System.out.println("The converted value is equal" + " " + value);
                    myList.add(value);
                }
            } else { //In case the user entered a value of 2
                Coin ils = CoinFactory.getCoinInstance(CoinEnum.ILS);
                if (ils != null) {
                    value = ils.calculate(amount);
                    System.out.println("The converted value is equal" + " " + value);
                    myList.add(value);
                }
            }


            while (ansFlag == true) {//Check if the user entered only Y or N values
                System.out.println("Would you like to continue converting more values?\nwrite Y or N");
                ans = myObj.next();
                if (ans.equalsIgnoreCase("Y")) {//In case the user entered Y
                    flag = true;
                    break;
                } else if (ans.equalsIgnoreCase("N")) {//In case the user entered N
                    flag = false;
                    ansFlag = false;
                    System.out.println("Thanks for using our currency converter");

                    for (int i = 0; i < myList.size(); i++) {//Array printing
                        System.out.println(myList.get(i));

                    }
                    //Create a file with a file name that contains the time and date
                    Date date = new Date();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
                    FileWriter myWriter = new FileWriter(dateFormat.format(date) + ".txt");
                    for (int i = 0; i < myList.size(); i++) {//Print the array into the created file
                        myWriter.write(+myList.get(i) + "\n");
                    }
                    myWriter.close();

                } else {//In case the user entered a value other than Y or N
                    System.err.println("You can enter only Y or T");
                    flag = true;
                }
            }
        }
    }
}
