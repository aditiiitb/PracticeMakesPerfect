public class Program {

	public static void main(String[] args) {
		int W = 6;

		int[] weights = { 1, 2, 3 };
		int[] prices = { 10, 50, 30 };

		int s = Knapsackrecursive(weights, prices, W, weights.length - 1);
		System.out.println(s);
	}

	public static int Knapsackrecursive(int[] weights, int[] prices, int W,
			int n) {
		if (W == 0 || n < 0)
			return 0;
		if (weights[n] > W)
			return Knapsackrecursive(weights, prices, W, n - 1);
		else {
			return Math.max(
					Knapsackrecursive(weights, prices, W, n - 1),
					prices[n]
							+ Knapsackrecursive(weights, prices,
									W - weights[n], n - 1));
		}
	}
}