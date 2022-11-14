public class PatternUtil {

    public static void main(String[] args) {

        pattern15(8);

    }

    static public void pattern1(int row){

        for (int i = 0; i < row; i++) {

            for (int j = 0; j <= row-i ; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k <= i ; k++) {
                System.out.print("* ");
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

                for (int l = i; l < (row*2)-i ; l++) {
                    System.out.print("* ");
                }

            }

            System.out.println();

        }

    }


    static public void pattern5(int row){

       // System.out.print("* "+row);

        for (int i = row; i>= 1; i--) {

            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }

    }


    static public void pattern6(int row){

        for (int i = 1; i <= row ; i++) {

            for (int j = 0; j <(row-i); j++) {
                System.out.print("  ");
            }

            for (int k = 0; k < i; k++) {
                System.out.print(" *");
            }

            System.out.println();
        }

    }


    static public void pattern7(int row){


        for (int i = 0; i <= row; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }


            for (int j = 0; j < (row-i); j++) {
                System.out.print("* ");
            }

            System.out.println();
        }

     }


    static public void pattern8(int row){

        for (int i = 1; i <= row*2; i++) {

            if(i<=row){
                for (int j = 0; j <i; j++) {
                  System.out.print("* ");
                }
            }else{
                for (int k = (row*2-i); k>=1;k--){
                    System.out.print("* ");
                }
            }

            System.out.println();
        }

     }


    static public void pattern9(int row){

        int space=1;

        for (int i = 1; i <= row*2; i++) {

            if(i<=row){

                for (int j = 0; j < (row-i) ; j++) {
                    System.out.print("  ");
                }
                for (int j = 0; j <i; j++) {
                  System.out.print(" *");
                }

            }else{

                for (int j = 0; j < space; j++) {
                    System.out.print("  ");
                }

                for (int j = 0; j < (row*2-i); j++) {
                    System.out.print(" *");
                }
                space++;

            }

            System.out.println();
        }

     }


    static public void pattern10(int row){

        int lower_star_count=1;

        for (int i = 1; i <= row*2; i++) {

            if(i<=row){

                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }

                for (int j=0;j<=row-i;j++){
                    System.out.print(" *");
                }

            }else{

                for (int j=0;j<=row*2-i;j++){
                    System.out.print(" ");
                }

                for(int k=0;k<lower_star_count;k++){
                    System.out.print(" *");
                }
                lower_star_count++;
            }
            System.out.println();
        }

     }

    static public void pattern11(int row){

        int lower_star_count=1;

        for (int i = 1; i <= row*2; i++) {

            if(i<=row){

                for (int j = 0; j < i; j++) {
                    System.out.print(" ");
                }

                for (int j=0;j<=row-i;j++){

                    System.out.print(((j==0)||(j==row-i)||i==1)?" *":"  ");
                }

            }else{

                for (int j=0;j<=row*2-i;j++){
                    System.out.print(" ");
                }

                for(int k=0;k<lower_star_count;k++){

                    System.out.print(((k==0)||i==row*2 || k<lower_star_count)?" *":"  ");

                  //  System.out.print(" *");
                }
                lower_star_count++;
            }
            System.out.println();
        }

     }

    static public void pattern12(int row){

        for (int i = 1; i <= row; i++) {

            for (int j = 1; j <= row; j++) {

                System.out.print(j%2==0?"0":"1");

            }

            System.out.println();

        }

     }


    static public void pattern13(int row){

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j%2==0?"0":"1");
            }
            System.out.println();
        }

     }


    static public void pattern14(int row){

        for (int i = 1; i <=row ; i++) {

            for (int space = 1; space <=i; space++) {
                System.out.print(" ");
            }

            for (int j = i; j <= row; j++) {
              System.out.print(" "+j);
            }

            System.out.println();
        }

    }


    static public void pattern15(int row){

        int apposite_limit_start=1;

        for (int i = 1; i <row*2 ; i++){

            if(i<=row){
                for (int space = 1; space <=i; space++){
                    System.out.print(" ");
                }
                for (int j = i; j <= row; j++) {
                    System.out.print(" "+j);
                }
            }else{

                for (int space = 0; space <(row-apposite_limit_start); space++){
                    System.out.print(" ");
                }

                for (int j = (row-apposite_limit_start); j <= row; j++) {
                    System.out.print(" "+j);
                }
                apposite_limit_start++;

            }
            System.out.println();
        }

    }


    static public void pattern16(int row) {

        int increase_value = 1;

        for (int i = 0; i < row; i++) {

            for (int j = 0; j < i; j++) {
                System.out.print("  " + increase_value++);
            }

            System.out.println();
        }

    }

}
