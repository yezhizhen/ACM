package knapsack_0_1;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] cost = { 0, 3, 5, 7, 1, 4, 6, 9, 33 };
		int[] scores = { 0, 1, 7, 9, 1, 5, 7, 13, 50 };
		int n = cost.length - 1;
		int cost_constraint = 39;
		int[][] dp = new int[n + 1][cost_constraint + 1];
		int[][] choice = new int[n + 1][cost_constraint + 1];
		for (int i = 1; i <= n; i++) {
			// dp[i][c]
			for (int c = 1; c <= cost_constraint; c++) {
				if (cost[i] > c) {
					dp[i][c] = dp[i - 1][c];
				} else {
					if (dp[i - 1][c] < dp[i - 1][c - cost[i]] + scores[i]) {
						dp[i][c] = dp[i - 1][c - cost[i]] + scores[i];
						choice[i][c] = i;
					} else {
						dp[i][c] = dp[i - 1][c];
					}

				}
			}
		}
		System.out.println("Max value: " + dp[n][cost_constraint]);
		// print result set
		int temp = cost_constraint;
		int i = n;

		while (temp > 0 && i > 0) {
			if (choice[i][temp] != 0) {
				System.out.println(scores[choice[i][temp]]);
				//System.out.print("i: " + i + "\n");
				temp -= cost[i]; // 39-33=6
				// 31
			}
			i--;
		}
	}
}
