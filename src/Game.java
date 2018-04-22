class Strat {
	public int score, length;
	public int x, y;
	
	Strat(int score, int length, int x, int y) {
		this.score = score;
		this.length = length;
		this.x = x;
		this.y = y;
	}
	
	Strat(Strat oth) {
		score = oth.score;
		length = oth.length;
		x = oth.x;
		y = oth.y;
	}
	
	boolean compare(Strat oth) {
		if (score > oth.score)
			return true;
		if (score == oth.score) {
			if (score == 1) {
				return length < oth.length;
			} else {
				return length > oth.length;
			}
		}
	
		return false;
	}
}

public class Game {

	int[][] board;
	int chosenPiece;
	boolean[] used;
	int rem;
	
	static int[] best;
	
	Game() {
		board = new int[4][4];
		used = new boolean[16];
		rem = 16;
		
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				board[i][j] = 0;
		
		for (int i = 0; i < 16; i++)
			used[i] = false;
		
		chosenPiece = 0;
	}
	
	Game(Game oth) {
		board = new int[4][4];
		used = new boolean[16];
		rem = oth.rem;
		
		for (int i = 0; i < 4; i++)
			for (int j = 0; j < 4; j++)
				board[i][j] = oth.board[i][j];
		
		for (int i = 0; i < 16; i++)
			used[i] = oth.used[i];
		
		chosenPiece = oth.chosenPiece;
	}
	
	private boolean isFull() {
		return rem == 0;
	}
	
	public boolean play(int x, int y) {
		if (board[x][y] != 0)
			return false;
		
		board[x][y] = chosenPiece;
		chosenPiece = 0;
		return true;
	}
	
	public boolean choose(int piece) {
		if (used[piece])
			return false;
		
		used[piece] = true;
		rem--;
		chosenPiece = piece + 1;
		return true;
	}
	
	public boolean isDone() {
		int d1mask1 = 15, d2mask1 = 15;
		int d1mask2 = 0, d2mask2 = 0;
		
		for (int i = 0; i < 4; i++) {
			if (board[i][i] == 0) {
				d1mask1 = 0;
				d1mask2 = 15;
			} else {
				d1mask1 &= board[i][i] - 1;
				d1mask2 |= board[i][i] - 1;
			}
			if (board[i][3-i] == 0) {
				d2mask1 = 0;
				d2mask2 = 15;
			} else {
				d2mask1 &= board[i][3-i] - 1;
				d2mask2 |= board[i][3-i] - 1;
			}
			
			int rmask1 = 15, cmask1 = 15;
			int rmask2 = 0, cmask2 = 0;
			for (int j = 0; j < 4; j++) {
				if (board[i][j] == 0) {
					rmask1 = 0;
					rmask2 = 15;
				} else {
					rmask1 &= board[i][j] - 1;
					rmask2 |= board[i][j] - 1;
				}
				if (board[j][i] == 0) {
					cmask1 = 0;
					cmask2 = 15;
				} else {
					cmask1 &= board[j][i] - 1;
					cmask2 |= board[j][i] - 1;
				}
			}
						
			if (rmask1 > 0)
				return true;
			if (cmask1 > 0)
				return true;
			if (rmask2 < 15)
				return true;
			if (cmask2 < 15)
				return true;
		}
		
		return d1mask1 > 0 || d2mask1 > 0 || d1mask2 < 15 || d2mask2 < 15;
	}
	
	private static Strat findBest(Game g, int limit) {
		return findBest(g, limit, false);
	}
	
	private static Strat findBest(Game g, int limit, boolean debug) {
		if (g.isDone()) {
			return new Strat(1, 0, 0, 0);
		}
		if (g.isFull()) {
			return new Strat(0, 0, 0, 0);
		}
		if (limit == 0) {
			return new Strat(0, 0, 0, 0);
		}
		
		Game t = new Game(g);
		
		Strat best = new Strat(-2, 0, 0, 0);
		
		if (g.chosenPiece > 0) {			
			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					if (t.play(i, j)) {
						Strat r = findBest(t, limit-1);
				//		r.score *= -1;
						
						if (r.compare(best)) {
							best = new Strat(r);
							best.length++;
							best.x = i;
							best.y = j;
						}
						
						t = new Game(g);
					}
					
					if (best.score == 1)
						return best;
				}
			}
		}
		else {
			for (int i = 0; i < 16; i++) {
				if (t.choose(i)) {
					Strat r = findBest(t, limit-1);
					r.score *= -1;
					if (r.compare(best)) {
						best = new Strat(r);
						best.length++;
						best.x = i;
					}
					
					t = new Game(g);
				}
				
				if (best.score == 1)
					return best;
			}
		}
		
		if (best.score == -2) {
			System.out.println("sictim");
		}
		
		return best;
	}
	
	static String[] tags = {
			"BW",
			"ST",
			"RS",
			"SH"
	};
	
	static int toMask(String s) {
		int p = 0;
		for (int k = 0; k < 4; k++) {
			if (s.charAt(k) == tags[k].charAt(1)) {
				p |= 1 << k;
			}
		}
		
		return p;
	}
	
	static String toStr(int mask) {
		String s = "";
		for (int i = 0; i < 4; i++) {
			if ((mask & (1<<i)) > 0)
				s += tags[i].charAt(1);
			else
				s += tags[i].charAt(0);
		}
		return s;
	}
	
	static void api_play(String[][] board, String piece) {
		System.out.println("given: " + piece);
		Game g = new Game();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j].equals("E"))
					continue;
				
				int mask = toMask(board[i][j]);
				g.board[i][j] = mask + 1;
				g.used[mask] = true;
				g.rem--;
			}
		}
		g.chosenPiece = toMask(piece) + 1;
		
		int limit = 5 + (16 - g.rem) / 2;
		
		Strat best = findBest(g, limit);
		
		System.out.println("played score: " + best.score);
		g.play(best.x, best.y);
		
		
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (g.board[i][j] == 0) {
					board[i][j] = "E";
				} else {
					board[i][j] = toStr(g.board[i][j]-1);
				}
			}
		}
		
		printBoard(board);
		
	}
	
	static String api_choose(String[][] board) {
		Game g = new Game();
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (board[i][j].equals("E")) {
					g.board[i][j] = 0;
				} else {
					int mask = toMask(board[i][j]);
					g.board[i][j] = mask + 1;
					g.used[mask] = true;
					g.rem--;
				}
			}
		}
		int limit = 5 + (16 - g.rem) / 2;

		Strat best = findBest(g, limit);
		System.out.println("chosed score: " + best.score);

		
		return toStr(best.x);
	}
	
	public static void printBoard(String[][] b) {
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(b[i][j] + '\t');
			}
			System.out.println("");
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[][] board = {
				{"E", "E", "E", "E"},
				{"E", "E", "E", "E"},
				{"E", "E", "E", "E"},
				{"E", "E", "E", "E"},			
		};
		
		while(true) {
			String p = api_choose(board);
			api_play(board, p);
			printBoard(board);
		}
	}

}
