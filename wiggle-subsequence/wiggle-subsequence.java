class Solution {
    public int wiggleMaxLength(int[] nums) {
        
		int prevUp = 1;
		int prevDown = 1;

		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > nums[i - 1]) {
				prevUp = prevDown + 1;
			} else if (nums[i] < nums[i - 1]) {
				prevDown = prevUp + 1;
			}
		}

		return Math.max(prevDown, prevUp);
	
    }
}