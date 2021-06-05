class Solution {
    public int islandPerimeter(int[][] grid) {
        
		int sum = 0;

		for (int i = 0; i < grid.length; i++) {
			int up = 0;
			int down = 0;
			int left = 0;
			int right = 0;
			for (int j = 0; j < grid[0].length; j++) {

				if (grid[i][j] == 1) {
					if (i == 0)
						up = 0;
					else {
						up = grid[i - 1][j];
					}

					if (i == grid.length - 1)
						down = 0;
					else {
						down = grid[i + 1][j];
					}

					if (j == 0) {
						left = 0;
					} else {
						left = grid[i][j - 1];
					}

					if (j == grid[0].length - 1) {
						right = 0;
					} else {
						right = grid[i][j + 1];
					}
                    
                    sum += (4 - (up + left + right + down));
				}
                
			}
			
		}

		return sum;
	
    }
}