package algos;

import java.util.HashMap;

public class RomantoInteger {

    public static void main(String[] args) {


        System.out.println("roman : "+romanToInt("mcmxciv"));


    }

    static public int romanToInt(String s) {

        String roman_digit =s.toUpperCase();

        HashMap<String, Integer> romanMap = new HashMap<String, Integer>();
        romanMap.put("I", 1);
        romanMap.put("V", 5);
        romanMap.put("X", 10);
        romanMap.put("L", 50);
        romanMap.put("C", 100);
        romanMap.put("D", 500);
        romanMap.put("M", 1000);

        int value = 0;

        for (int i = roman_digit.length()-1; i >=0 ; i--) {

            switch (""+roman_digit.charAt(i)){

                case "I":
                    if(value>=4){
                        value-=romanMap.get(""+roman_digit.charAt(i));
                    }else{
                        value+=romanMap.get(""+roman_digit.charAt(i));
                    }
                    break;

                case "V":
                    value+=romanMap.get(""+roman_digit.charAt(i));
                    break;

                case "X":
                    if(value>=100){
                      value-=romanMap.get(""+roman_digit.charAt(i));
                    }else{
                        value+=romanMap.get(""+roman_digit.charAt(i));
                    }
                    break;

                case "L":
                    value+=romanMap.get(""+roman_digit.charAt(i));
                    break;

                case "C":
                    if(value>=500){
                        value-=romanMap.get(""+roman_digit.charAt(i));
                    }else{
                        value+=romanMap.get(""+roman_digit.charAt(i));
                    }
                    break;

                case "D":
                    value+=romanMap.get(""+roman_digit.charAt(i));
                    break;

                case "M":
                    if(value>=1000){
                        value-=romanMap.get(""+roman_digit.charAt(i));
                    }else{
                        value+=romanMap.get(""+roman_digit.charAt(i));
                    }
                    break;

            }
        }
        return value;

    }

}
