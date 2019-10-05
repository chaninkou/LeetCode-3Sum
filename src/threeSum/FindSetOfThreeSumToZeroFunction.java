package threeSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSetOfThreeSumToZeroFunction {
	public List<List<Integer>> threeSum(int[] nums) {
		// Sort the array first
		Arrays.sort(nums);
		
		List<List<Integer>> result = new ArrayList<>();
		
		for (int i = 0; i + 2 < nums.length; i++) {
			// Since the array is sorted the next entries sum to 0 could never happen.
			if (nums[i] > 0){
				break;
			}
			
			// skip same result
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			
			int j = i + 1;
			int k = nums.length - 1;
			
			int target = -nums[i];
			
			while (j < k) {
				if (nums[j] + nums[k] == target) {
					
					result.add(Arrays.asList(nums[i], nums[j], nums[k]));
					
					j++;
					
					k--;
					while (j < k && nums[j] == nums[j - 1]){
						j++; // skip same result
					}
					while (j < k && nums[k] == nums[k + 1])
					{
						k--; // skip same result
					}
				} else if (nums[j] + nums[k] > target) {
					k--;
				} else {
					j++;
				}
			}
		}
		return result;
	}
}
