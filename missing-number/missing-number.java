class Solution {
    public int missingNumber(int[] nums) {
        
		
		int sum = (nums.length * (nums.length + 1)) / 2;
		int s = 0;
		for (int i : nums)
			s += i;

		return sum - s;
	
	
    }
}