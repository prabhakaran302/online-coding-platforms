class Solution {
    public int subtractProductAndSum(int n) {
        
		int sum = 0;
		int prod = 1;
        
		while (n > 0) {
			int rem = n % 10;
			sum += (rem);

			if (prod != 0)
				prod *= rem;


			n /= 10;
		}

        
		return prod - sum;
	
    }
}