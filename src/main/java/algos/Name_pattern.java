package algos;

public class Name_pattern {

    public static void main(String[] args) {

    }

    static void print_name(String name) {

        for (int i = 0; i < name.length() * 2; i++) {

            if (i < name.length()) {
                for (int j = 0; j <= i; j++) {
                    System.out.print(name.charAt(j) + " ");
                }
                System.out.println();
            } else {

                int j_limit = (name.length() - 1) - (i - (name.length() - 1));
                for (int j = 0; j <= j_limit; j++) {
                    System.out.print(name.charAt(j) + " ");
                }
                System.out.println();

            }

        }

    }
}
