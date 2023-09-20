package tests;

import java.io.FileNotFoundException;

public class CheckCoffeeMachine {
    public static void main(String[] args) {

        int amountOfCoffee = 5;

        /*
        if amount of coffee is less than 10 ml,
        throw NoCoffeeException
         */

        try {

            if (amountOfCoffee < 10) {
                throw new NoCoffeeException("Out of coffee!!!");
            } else {
                System.out.println("Coffee machine has enough coffee");
            }
        }catch (NoCoffeeException e){

        }catch (Exception e){

        }


        if (amountOfCoffee == 100){
            throw new IndexOutOfBoundsException();
        }






    }
}
