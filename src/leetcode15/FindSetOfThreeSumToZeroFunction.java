package leetcode15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSetOfThreeSumToZeroFunction {
	// It has to be O(N^2)
	public List<List<Integer>> threeSum(int[] nums) {
		// List of ArrayList to store the answer
		List<List<Integer>> result = new ArrayList<>();
		
		if(nums.length == 0 || nums == null){
			return result;
		}
		
		// Sort the array, so we could have two pointer from left and right going toward middle
		// O(nlogn) right away
		Arrays.sort(nums);
		
		// Nums.length - 2 so it won't go over bound, we are searching for 2 element after current element to add up to current element
		for(int i = 0; i < nums.length - 2; i++){
			// We want to skip duplicates, starting from i = 1, or else out of bound
			if(i == 0 || (i > 0 && nums[i] != nums[i - 1])){
				int low = i + 1;
				
				int high = nums.length - 1;
				
				// This is the target we are trying to find in order to get sum of 0, since -4 + 4 = 0
				int sum = 0 - nums[i];
				
				while(low < high){
					// Since our target is the sum, 2 elements that add up to sum in order to get zero
					if(nums[low] + nums[high] == sum){
						// Arrays.asList is a special method to add in a list
						result.add(Arrays.asList(nums[i], nums[low], nums[high]));
						
						// Skip duplicates
						while(low < high && nums[low] == nums[low + 1]){
							low++;
						}
						
						// Skip duplicates
						while(low < high && nums[high] == nums[high - 1]){
							high--;
						}
						
						// update both pointers
						low++;
						high--; 
					} else if (nums[low] + nums[high] > sum){ // if the sum < right side
						// Skip duplicates
                        while(low < high && nums[high] == nums[high - 1]){
                            high--;
                        }
                        
						// Update the right pointer, since the right most is the biggest
						high--;
					} else { // sum > right side
						// Skip duplicates
						while(low < high && nums[low] == nums[low + 1]){
							low++;
						}
						
						low ++;
					}			
				}
			}
		}
		
		return result;
	}
}
