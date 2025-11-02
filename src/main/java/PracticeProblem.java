public class PracticeProblem {

	public static void main(String args[]) {

	}
	public static int searchMazeMoves(String[][] maze) {
		if (maze == null || maze.length == 0) return -1;
		int startRow = maze.length - 1;
		int startCol = 0;
		if (!"S".equals(maze[startRow][startCol])) {
			return -1;
		}
		return dfsHelperMoves(maze, startRow, startCol, 0);
	}
	public static int dfsHelperMoves(String[][] maze, int curRow, int curCol, int moves) {
		// basecase
		if ("F".equals(maze[curRow][curCol])) {
			return moves;
		}
		if ("*".equals(maze[curRow][curCol])) {
			return -1;
		}
		int upPts = -1;
		if (curRow > 0) {
			upPts = dfsHelperMoves(maze, curRow - 1, curCol, moves + 1);
		}
		int rightPts = -1;
		if (curCol < maze[0].length - 1) {
			rightPts = dfsHelperMoves(maze, curRow, curCol + 1, moves + 1);
		}
		if (upPts != -1 && rightPts != -1) {
			return Math.min(upPts, rightPts);
		} else if (upPts != -1) {
			return upPts;
		} else if (rightPts != -1) {
			return rightPts;
		} else {
			return -1; // unreachable
		}
	}
	// calc
	public static int noOfPaths(String[][] maze) {
		if (maze == null || maze.length == 0) return 0;
		int startRow = maze.length - 1;
		int startCol = 0;
		if (!"S".equals(maze[startRow][startCol])) {
			return 0;
		}
		return dfsHelperPaths(maze, startRow, startCol);
	}
	public static int dfsHelperPaths(String[][] maze, int curRow, int curCol) {
		// v1.0 no check path==minPath
		if ("F".equals(maze[curRow][curCol])) {
			return 1;
		}
		if ("*".equals(maze[curRow][curCol])) {
			return 0;
		}
		int pathCount = 0;
		if (curRow > 0) { // up
			pathCount += dfsHelperPaths(maze, curRow - 1, curCol);
		}
		// right
		if (curCol < maze[0].length - 1) {
			pathCount += dfsHelperPaths(maze, curRow, curCol + 1);
		}
		return pathCount;
	}
	
}
