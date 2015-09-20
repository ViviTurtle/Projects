public class Exchange {

	public double[][] exchange;
	private boolean floydCalled;

	public Exchange(int amount) {
		exchange = new double[amount][amount];
		for (int i = 0; i < exchange.length; i++) {
			exchange[i][i] = 1;
		}
		floydCalled = false;
	}

	public void setRate(int from, int to, double rate) {
		exchange[from][to] = rate;
	}

	public boolean arbitrageExists() {
		if (!floydCalled) {
			floydWarshall();
			floydCalled = true;
		}
		for (int i = 0; i < exchange.length; i++) {
			if (exchange[i][i] > 1) {
				return true;
			}
		}
		return false;
	}

	public double bestExchangeRate(int from, int to) {
		if (!floydCalled) {
			floydWarshall();
			floydCalled = true;
		}
		return exchange[from][to];
	}

	private void floydWarshall() {
		int a, b;
		for (int i = 0; i < exchange.length; i++) {
			for (int j = 0; j < exchange.length; j++) // rows
			{
				for (int k = 0; k < exchange.length; k++) // column
				{
					if (j != i && k != i
							&& exchange[j][i] * exchange[i][k] > exchange[j][k]) {
						exchange[j][k] = exchange[j][i] * exchange[i][k];
					}
				}
			}
		}
	}
}