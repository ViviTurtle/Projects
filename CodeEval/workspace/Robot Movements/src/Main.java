public class Main {
	private static final int four = 4;
	int x = 0;
	int y = 0;

	public static void main(String args[]) {
		LinkedMap map = new LinkedMap[four][four];
		for (int i = 0; i < four; i++) {
			map[0][i].change("up");
			map[i][0].change("left");
			map[3][i].change("down");
			map[i][3].change("right");
		}
		System.out.println(countPossibility());
	}
	
	private static long countPossibility()
	{
		int count = 0;
		for (int i = 0; i < four; i++)
		{
			for (int j = 0; j < four; j++)
			{
				if
				
				if (map[j][i].up)
				{
					return 0;
				}
			}
		}
	}

	class LinkedMap {

		public LinkedMap(int x, int y)
		{
			for (int i = 0; i < x; i++)
			{
				for (int j = 0 ; j < y; j++)
				{
					add();
				}
			}
		}
		
		class Node()
	
		{
			
		
	
		public boolean up;
		public boolean down;
		public boolean left;
		public boolean right;
		public void change(String direction) {
			if (direction.equals("up")) {
				up = false;
			}
			if (direction.equals("down")) {
				down = false;
			}
			if (direction.equals("left")) {
				left = false;
			}
			if (direction.equals("right")) {
				right = false;
			}
		}
		public boolean goUp()
		{
			if (up)
			{
				return true;
			}
			return false;
		}
		public boolean goDown()
		{
			if (down)
			{
				return true;
			}
			return false;
		}
		public boolean goLeft()
		{
			if (left)
			{
				return true;
			}
			return false;
		}
		public boolean goRight()
		{
			if (right)
			{
				return true;
			}
			return false;
		}
	}
}
