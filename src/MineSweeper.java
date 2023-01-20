import java.util.ArrayList;
import java.util.List;

class MineSweeper {
    private final char[][] board;
    private final int h;
    private final int w;
    private int numberOfQ = 0;
    private int numOfClosedX;
    Point[] closedPoints;
    int[] mines;

    public MineSweeper(final String board, final int nMines) {
        // Your code here...
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
            method2();
        } while (numOfQBefore != numberOfQ);
        return boardToResult();
//        return boardToString();
    }

    private void method2() {
        closedPoints = getClosedPoints();
        mines = initialMines();
        boolean[] validPoints = new boolean[closedPoints.length];
        do {
            fillBoardWithX();
            if (isValid()) {
                for (int i : mines) {
                    validPoints[i] = true;
                }
            }
            fillBoardWithQ();
        } while (getNextMines());
        for (int i = 0; i < validPoints.length; i++) {
            if (!validPoints[i]) {
                int y = closedPoints[i].y;
                int x = closedPoints[i].x;
                board[y][x] = (char) (Game.open(y, x) + '0');
            }
        }
    }

    private boolean isValid() {
        for (Point p : closedPoints) {
            for (int y = p.y - 1; y <= p.y + 1; y++) {
                for (int x = p.x - 1; x <= p.x + 1; x++) {
                    if (y >= 0 && y < h && x >= 0 && x < w && (y != p.y || x != p.x) && board[y][x] > '0' && board[y][x] < '9') {
                        int numX = 0;
                        for (int yy = y - 1; yy <= y + 1; yy++) {
                            for (int xx = x - 1; xx <= x + 1; xx++) {
                                if (yy >= 0 && yy < h && xx >= 0 && xx < w && (yy != y || xx != x) && board[yy][xx] == 'x')
                                    numX++;
                            }
                        }
                        if (board[y][x] != numX + '0') return false;
                    }
                }
            }
        }
        return true;
    }

    private void fillBoardWithQ() {
        for (int i : mines) {
            Point p = closedPoints[i];
            board[p.y][p.x] = '?';
        }
    }

    private void fillBoardWithX() {
        for (int i : mines) {
            Point p = closedPoints[i];
            board[p.y][p.x] = 'x';
        }
    }

    private boolean getNextMines() {
        int movable = -1;
        for (int i = mines.length - 1; i >= 0; i--) {
            if (isMovable(i)) {
                movable = i;
                break;
            }
        }
        if (movable == -1) return false;
        mines[movable]++;
        if (movable != mines.length - 1)
            for (int i = movable + 1; i < mines.length; i++) {
                mines[i] = mines[i - 1] + 1;
            }
        return true;
    }

    private boolean isMovable(int elm) {
        if (mines[elm] == closedPoints.length - 1) return false;
        if (elm == mines.length - 1) return true;
        return mines[elm] + 1 != mines[elm + 1];
    }

    private int[] initialMines() {
        int[] mines = new int[numOfClosedX];
        for (int i = 0; i < numOfClosedX; i++) {
            mines[i] = i;
        }
        return mines;
    }

    private Point[] getClosedPoints() {
        List<Point> closedPoints = new ArrayList<>();
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (board[y][x] == '?') closedPoints.add(new Point(y, x));
            }
        }
        return closedPoints.toArray(new Point[0]);
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
                                if (board[yy][xx] == '?') pointsQ.add(new Point(yy, xx));
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
                    if (board[y][x] == '?') board[y][x] = (char) (Game.open(y, x) + '0');
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