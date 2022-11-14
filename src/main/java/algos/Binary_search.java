package algos;

public class Binary_search {

    public static void main(String[] args) {

        Integer[] single_array = {8,5,3,2,1};
//        int target = 3;
//
//        int found_inx=searchBS(array,target);
//
//        System.out.print("found result index "+found_inx);

        Integer[][] array = {
                {5,6,10,12},
                {13,14,18,20},
                {21,22,23,24},
                {23,24,27,30}
        };

        int target = 24;

       // System.out.println("found index : "+Arrays.toString(searchBS2DM(array,target)));
        System.out.println("found index : "+searchBS(single_array,2));
    }


    static int searchBS(Integer[] array, int target){

        int start_index= 0;
        int end_index=array.length-1;

        boolean is_asending=array[start_index]<array[end_index];

        while (start_index<=end_index){

            int middle=start_index+(end_index-start_index)/2;

            if(is_asending){

                if(target < array[middle]){

                    end_index=middle-1;

                }else if(target > array[middle]){

                    start_index=middle+1;

                }else{
                    return middle;
                }

            }else{
                if(target > array[middle]){

                    end_index=middle-1;

                }else if(target < array[middle]){

                    start_index=middle+1;

                }else{
                    return middle;
                }
            }



        }
        return -1;
    }

    static int[] searchBS2DM(Integer[][] maxtric ,int target){

        int row= 0;
        int col = maxtric.length-1;

        while (row<maxtric.length && col>=0){

            if(maxtric[row][col]==target){
                return new int[]{row,col};
            }
            else if(target>maxtric[row][col]){
                row++;
            }else {
                col--;
            }

        }
        return new int[]{-1,-1};

    }



}
