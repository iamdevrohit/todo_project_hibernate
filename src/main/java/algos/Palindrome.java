package algos;

public class Palindrome {

    public static void main(String[] args) {

        System.out.println("isPalindrome : "+ isPalindrome(1000002));


    }

    static public boolean isPalindrome(int x) {


        if(String.valueOf(x).length()==1){
            return true;
        }

        String reverse_number ="";
        int number_length = String.valueOf(x).length()-1;


        while (number_length>=0){
            reverse_number+= String.valueOf(x).charAt(number_length);
            number_length--;
        }


        return reverse_number.equalsIgnoreCase(String.valueOf(x));


    }
}
