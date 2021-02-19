package leetcode15;

import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 1, 2, -1, -4};
		
		System.out.println("Input: " + Arrays.toString(nums));
		
		FindSetOfThreeSumToZeroFunction solution = new FindSetOfThreeSumToZeroFunction();
		
		System.out.println("Solution set: " + solution.threeSum(nums));
	}
}
