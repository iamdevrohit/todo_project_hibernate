public class PatternUtil {

    public static void main(String[] args) {

        pattern4(5);

    }

    static public void pattern1(int row){

        for (int i = 0; i < row; i++) {

            for (int j = 0; j <= row-i ; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k <= i ; k++) {
                System.out.print(" *");
            }

            System.out.println();

        }

    }


    static public void pattern2(int row){

        for (int i = 0; i <= row; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();

        }

    }


    static public void pattern3(int row){

        for (int i = 0; i <= row; i++) {

            for (int j = 0; j < row-i; j++) {
                System.out.print("  ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print(" *");
            }

            System.out.println();

        }

    }

    static public void pattern4(int row){

        int space =1;

        for (int i = 0; i <= row*2; i++) {

            if(i<row){
                for (int j = 0; j <= row-i ; j++) {
                    System.out.print(" ");
                }
                for (int k = 0; k <= i ; k++) {
                    System.out.print(" *");
                }
            }else{

                for (int l = 0; l < (row*2)-i ; l++) {
                    System.out.print(" *");
                }

            }

            System.out.println();

        }

    }


}
