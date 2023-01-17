class MineSweeper {
    private char[][] board;
    private int h;
    private int w;
    private final int nMines;

    public MineSweeper(final String board, final int nMines) {
        // Your code here...
        this.nMines = nMines;
        String[] s = board.split("\\n");
        h = s.length;
        this.board = new char[h][];
        for (int y = 0; y < h; y++) {
            this.board[y] = s[y].replaceAll(" ", "").toCharArray();
        }
        System.out.println();
    }

    public String solve() {
        // Your code here...
        int n = Game.open(2, 2);

        return "?";
    }
}