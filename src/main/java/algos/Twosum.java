package algos;

import net.bytebuddy.implementation.bytecode.Throw;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Twosum {


    public static void main(String[] args) {

        int[] nums = {15,0,8,7,4,98,10};
        int target = 98;

        System.out.println("found index : " + Arrays.toString(twoSum(nums, target)));

    }

    static int[] twosum(int[] nums, int target) {

        int start_point = 0;
        int start_index = start_point + 1;
        int end_index = nums.length - 1;
        while (start_point < end_index) {
            while (start_index <= end_index) {
                if (nums[start_point] + nums[start_index] == target) {
                    return new int[]{start_point, start_index};
                }
                start_index++;
            }
            start_point++;
            start_index=start_point+1;
        }
        return new int[]{-1, -1};
    }


    static public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                System.out.println("hdhdhd : "+ map.get(complement));
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        // In case there is no solution, we'll just return null
        return null;
    }
}
