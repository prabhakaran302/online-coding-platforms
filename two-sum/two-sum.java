class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<nums.length;i++)    {
            if(map.get(nums[i]) != null)    {
                res[0] = map.get(nums[i]);
                res[1] = i;
                return res;
            } else  {
                map.put(target-nums[i],i);
            }
        }
        return res;
    }
}