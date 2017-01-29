package leetcode;

import java.util.HashMap;
import java.util.Map;

public class lc1 {

	/*
	source: https://leetcode.com/problems/two-sum/ 
	
	Given an array of integers, return indices of the two numbers such that they add up to a specific target.

	You may assume that each input would have exactly one solution.
	
	Example:
	Given nums = [2, 7, 11, 15], target = 9,
	
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
	 */
	
	public static void main(String[] args) {
		int[] nums = new int[] {2, 7, 11, 15};
		lc1 sol = new lc1();
		int[] result = sol.twoSum(nums, 9);
		System.out.print(result[0]+ ", " + result[1]);
	}
	
	/* *
	 * Input is not sorted, put the value the number and the index in a map, value as key, index as value.
	 * For each number A, find if there exists another number B equals to (target - A). If such B exists, 
	 * return their indices as result. Otherwise, put the A and its index into map.
	 */
	public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < nums.length; i++) {
            if(map.get(target - nums[i]) != null) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        } 
        return result;
    }

}
