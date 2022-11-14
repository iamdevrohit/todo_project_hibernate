package algos;

import com.mysql.cj.log.Log;

import java.util.Arrays;

public class Plusone {

    public static void main(String[] args) {

        int[] digits = {9,8,7,6,5,4,3,2,1,0};

       System.out.println("plus one : "+ Arrays.toString(plusOne(digits)));
    }

    static public int[] plusOne(int[] digits) {

        String combine_value ="";

        for (int i = 0; i < digits.length; i++) {
            combine_value+=digits[i];
        }
        combine_value=""+(Integer.parseInt(combine_value)+1);

        int [] converted_digit = new int[combine_value.length()];

        for (int i = 0; i < combine_value.length(); i++) {
            converted_digit[i]=Integer.parseInt(""+combine_value.charAt(i));
        }

        return converted_digit;
    }
}
