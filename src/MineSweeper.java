import java.util.ArrayList;
import java.util.List;

class MineSweeper {
    private final char[][] board;
    private final int h;
    private final int w;
    private final int nMines;
    private int numberOfQ = 0;
    private int numOfClosedX;

    public MineSweeper(final String board, final int nMines) {
        // Your code here...
        this.nMines = nMines;
        numOfClosedX = nMines;
        String[] s = board.split("\\n");
        h = s.length;
        this.board = new char[h][];
        for (int y = 0; y < h; y++) {
            this.board[y] = s[y].replaceAll(" ", "").toCharArray();
            for (char c : this.board[y]) {
                if (c == '?') numberOfQ++;
            }
        }
        w = this.board[0].length;
    }

    public String solve() {
        // Your code here...
        int numOfQBefore;
        do {
            numOfQBefore = numberOfQ;
            method0();
            if (numOfClosedX == 0) return boardToString();
            method1();
            if (numOfClosedX == 0) return boardToString();
        } while (numOfQBefore != numberOfQ);
        return boardToResult();
    }

    private void method1() {
        int nqt;
        do {
            nqt = numberOfQ;
            pointQuestionNearDigit();
        } while (nqt != numberOfQ);
    }

    private void method0() {
        Point point;
        do {
            point = pointQuestionNearZero();
            if (point != null) {
                board[point.y][point.x] = (char) (Game.open(point.y, point.x) + '0');
                numberOfQ--;
            }
        } while (point != null);
    }

    // search for a point marked ? next to a point marked with a digit
    // where sum of ? and x equals to the digit
    // or count of x equals to the digit
    private void pointQuestionNearDigit() {
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int n = board[y][x];
                if (n > '0' && n < '9') {
                    int numX = 0;
                    List<Point> pointsQ = new ArrayList<>();
                    for (int yy = y - 1; yy <= y + 1; yy++) {
                        for (int xx = x - 1; xx <= x + 1; xx++) {
                            if (yy >= 0 && yy < h && xx >= 0 && xx < w && (yy != y || xx != x)) {
                                if (board[yy][xx] == '?') {
                                    pointsQ.add(new Point(yy, xx));
                                }
                                if (board[yy][xx] == 'x') numX++;
                            }
                        }
                    }
                    if (numX + pointsQ.size() == n - '0') {
                        while (pointsQ.size() > 0) {
                            Point p = pointsQ.remove(pointsQ.size() - 1);
                            board[p.y][p.x] = 'x';
                            numberOfQ--;
                            numOfClosedX--;
                        }
                    }
                    if (numX == n - '0') {
                        while (pointsQ.size() > 0) {
                            Point p = pointsQ.remove(pointsQ.size() - 1);
                            int nq = Game.open(p.y, p.x);
                            board[p.y][p.x] = (char) (nq + '0');
                            numberOfQ--;
                        }
                    }
                }
            }
        }
    }

    // search for a point marked ? next to a point marked 0
    private Point pointQuestionNearZero() {
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (board[y][x] == '0') {
                    for (int yy = y - 1; yy <= y + 1; yy++) {
                        for (int xx = x - 1; xx <= x + 1; xx++) {
                            if (yy >= 0 && yy < h && xx >= 0 && xx < w && (yy != y || xx != x) && board[yy][xx] == '?')
                                return new Point(yy, xx);
                        }
                    }
                }
            }
        }
        return null;
    }

    private String boardToString() {
        if (numberOfQ > 0) {
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    if (board[y][x] == '?') Game.open(y, x);
                }

            }
        }
        return boardToResult();
    }

    private String boardToResult() {
        StringBuilder sb = new StringBuilder();
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                sb.append(board[y][x]).append(" ");
            }
            sb.replace(sb.length() - 1, sb.length(), "\n");
        }
        return sb.substring(0, sb.length() - 1);
    }

    static class Point {
        int y;
        int x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}