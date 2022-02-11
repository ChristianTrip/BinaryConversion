import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    static final Scanner scan = new Scanner(System.in);


// input validation methods ======================================================================================================
    static int validateUserIntInput(int minValue, int maxValue){
        int returnNum = 0;
        boolean run = true;
        while (run) {
            try {
                returnNum = scan.nextInt();
                if (returnNum >= minValue && returnNum <= maxValue){
                    scan.nextLine();
                    run = false;
                }
                else {
                    System.out.println("The number has to be between " + (minValue) + " and " + (maxValue));
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! try a number");
                scan.nextLine();
            }
        }
        return returnNum;
    }

    static int validateBinaryInput(){
        int number = 2;
        while(!containsOnlyBinary(number)){
            number = validateUserIntInput(0, Integer.MAX_VALUE);

            System.out.println("the number can only contain 0's and 1's");

        }
        return number;
    }

    private static boolean containsOnlyBinary(int number){
        String numberAsString = Integer.toString(number);

        for (int i = 0; i < numberAsString.length(); i++) {

            if(!numberAsString.substring(i, i + 1).equals("0") && !numberAsString.substring(i, i + 1).equals("1")){
                return false;
            }
        }
        return true;
    }


// Menues methods ======================================================================================================
    static void mainMenu(){
        System.out.println( "This small program converts" +
                            "\nbase-2 (binary) to base-10 (decimal)" +
                            "\nnumber system and visa versa");
        int choice = 0;
        while(choice != 4){

            System.out.println("1. Convert from binary");
            System.out.println("2. Convert to binary");
            System.out.println("3. View a list of binary numbers");
            System.out.println("4. Exit");
            choice = validateUserIntInput(1, 4);

            switch(choice){
                case 1:
                    convertBinaryNumberMenu();
                    break;
                case 2:
                    convertDecimalNumberMenu();
                    break;
                case 3:
                    printListMenu();
                    break;
                case 4:
                    System.out.println("Farewell");
                    break;
            }
        }

    }

    static void convertBinaryNumberMenu(){
        System.out.println("Insert a positive base-2 number");
        int binaryNumber = validateBinaryInput();
        int decimalValue = BinaryConverter.getDecimalValue(binaryNumber);
        System.out.println(binaryNumber + " = " + decimalValue);
    }

    static void convertDecimalNumberMenu(){
        System.out.println("Insert a positive base-10 whole number");
        int decimalNumber = validateUserIntInput(0, Integer.MAX_VALUE);
        String binaryNumber = BinaryConverter.getBinaryValue(decimalNumber);
        System.out.println(decimalNumber + " = " + binaryNumber);
    }

    static  void printListMenu(){
        System.out.println("Type in the start value in decimal:");
        int start = validateUserIntInput(0, Integer.MAX_VALUE);
        System.out.println("Type in the end value in decimal:");
        int end = validateUserIntInput(0, Integer.MAX_VALUE);
        if (start >= end){
            System.out.println("your start value has to be smaller then you end");
        }
        else{
            BinaryConverter.printList(start, end);
        }
    }


    public static void main(String[] args) {

        mainMenu();

    }
}
