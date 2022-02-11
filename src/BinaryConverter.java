public final class BinaryConverter {


    public static int getDecimalValue(int binaryNumber){

        String toString = Integer.toString(binaryNumber);
        int length = toString.length();
        int decimalValue = 0;

        for (int i = 0; i < length; i++) {
            int remainder = binaryNumber % 10;
            int powIndex = (int)Math.pow(2, i);
            decimalValue += remainder * powIndex;
            binaryNumber /= 10;
        }
        return decimalValue;
    }

    public static String getBinaryValue(int decimalNumber){

        if(decimalNumber <= 0){
            return "0";
        }

        String binaryValue = "";


        while (decimalNumber != 0){
            int remainder = decimalNumber % 2;
            binaryValue += Integer.toString(remainder);
            decimalNumber = decimalNumber / 2;
        }


        return reverseString(binaryValue);
    }

    private static String reverseString(String input){

        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) {
            reversed += input.charAt(i);
        }

        return reversed;
    }

    public static void printList(int start, int end){

        System.out.println("Base-10 | Base-2");
        for (int i = start; i <= end; i++) {
            System.out.println(i + "       =    " + getBinaryValue(i));
        }
        System.out.println();
    }

}
