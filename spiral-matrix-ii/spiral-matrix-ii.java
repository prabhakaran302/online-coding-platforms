class Solution {
    public int[][] generateMatrix(int n) {
        
		
		int r1 = 0;
		int r2 = n - 1;

		int c1 = 0;
		int c2 = n - 1;

		int mat[][] = new int[n][n];

		int val = 1;
		while (r1 <= r2 && c1 <= c2) {
			for (int i = r1; i <= c2; i++) {
				mat[r1][i] = val++;
			}

			for (int i = r1 + 1; i <= r2; i++) {
				mat[i][c2] = val++;
			}

			if (r1 < r2 && c1 < c2) {
				for (int i = c2 - 1; i >= c1; i--) {
					mat[c2][i] = val++;
				}

				for (int i = c2 - 1; i > r1; i--) {
					mat[i][c1] = val++;
				}
			}

			r1++;
			r2--;
			c1++;
			c2--;
		}

		return mat;
	
	
    }
}