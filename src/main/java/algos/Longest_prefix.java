package algos;

public class Longest_prefix {

    public static void main(String[] args) {

        String[] names = {"flower","tower","shower"};

       //System.out.println("longest_prefix  : " +longestCommonPrefix(names));
    }

    static  public String longestCommonPrefix(String[] strs){

        String initial_word=strs[0];

        for (int i = 0; i < initial_word.length(); i++){

            for (int j = i; j <  initial_word.length(); j++){

                for (int k = j; k <  initial_word.length(); k++) {

                }
            }
        }
        return "";
    }
}
