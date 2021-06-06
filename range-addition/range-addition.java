class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        
		int[] array = new int[length];
		for (int[] u : updates) {
			for (int i = u[0]; i <= u[1]; i++) {
				array[i] += u[2];
			}
		}

		return array;
	
    }
}