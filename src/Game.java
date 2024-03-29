public class Game {
    static int[][] b = {
        {1, 1, 0, 0, 0, 0},
        {9, 1, 0, 0, 0, 0},
        {1, 1, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {1, 2, 1, 1, 0, 0},
        {9, 2, 9, 1, 0, 0},
        {1, 2, 1, 1, 1, 1},
        {2, 2, 1, 0, 1, 9},
        {9, 9, 2, 1, 2, 1},
        {3, 3, 3, 9, 1, 0},
        {1, 9, 2, 1, 1, 0},
        {1, 2, 2, 1, 0, 0},
        {0, 1, 9, 1, 0, 0},
        {0, 1, 1, 1, 0, 0},
        {0, 0, 0, 0, 0, 0},
        {0, 1, 1, 1, 0, 0},
        {1, 2, 9, 1, 0, 0},
        {1, 9, 2, 1, 0, 0},
        {1, 2, 2, 1, 0, 0},
        {1, 2, 9, 1, 0, 0},
        {1, 9, 2, 1, 0, 0},
        {1, 1, 1, 0, 0, 0}
    };

    public static int open(int row, int column) {
        int r = b[row][column];
        if (r == 9) {
            System.out.println(row + " " + column);
            System.exit(9);
        }
        return r;
    }
}

//            {0, 2, 9},
//            {0, 2, 9}

// {1, 9, 1, 1, 9, 1},
// {2, 2, 2, 1, 2, 2},
// {2, 9, 2, 0, 1, 9},
// {2, 9, 2, 1, 2, 2},
// {1, 1, 1, 1, 9, 1},
// {0, 0, 0, 1, 1, 1}

//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 9, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0},
//            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 2, 9, 2, 1, 9, 1, 0},
//            {1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 2, 9, 1, 0, 0, 0, 0, 2, 9, 2, 1, 1, 1, 0},
//            {1, 9, 1, 1, 1, 1, 0, 1, 9, 2, 1, 1, 0, 0, 1, 9, 2, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0},
//            {1, 2, 2, 3, 9, 2, 0, 1, 1, 2, 9, 1, 0, 0, 1, 2, 2, 1, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1},
//            {0, 1, 9, 3, 9, 2, 0, 0, 0, 1, 1, 1, 0, 1, 2, 3, 9, 1, 0, 0, 0, 0, 0, 1, 9, 1, 0, 0, 1, 9},
//            {0, 1, 1, 3, 3, 3, 2, 1, 1, 1, 1, 2, 1, 2, 9, 9, 2, 2, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 2, 1},
//            {0, 0, 0, 1, 9, 9, 2, 9, 1, 1, 9, 2, 9, 2, 3, 3, 3, 2, 9, 1, 0, 1, 1, 1, 0, 0, 2, 9, 2, 0},
//            {0, 1, 1, 2, 2, 2, 3, 2, 2, 1, 1, 2, 1, 1, 1, 9, 2, 9, 2, 1, 0, 1, 9, 1, 0, 0, 2, 9, 2, 0},
//            {1, 2, 9, 1, 0, 1, 2, 9, 1, 0, 0, 0, 1, 1, 2, 2, 3, 2, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1, 0},
//            {1, 9, 2, 1, 0, 1, 9, 3, 2, 1, 0, 0, 1, 9, 1, 1, 9, 2, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0},
//            {1, 1, 2, 1, 2, 2, 2, 2, 9, 1, 0, 0, 1, 1, 1, 1, 2, 9, 1, 0, 0, 0, 1, 9, 2, 1, 0, 0, 0, 0},
//            {1, 1, 2, 9, 2, 9, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 2, 1, 1, 0, 0, 0, 1, 2, 9, 1, 0, 0, 0, 0},
//            {1, 9, 3, 2, 2, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 9, 1, 0, 0, 0, 0, 0, 1, 2, 2, 1, 0, 0, 0, 0},
//            {1, 2, 9, 1, 0, 0, 0, 0, 0, 1, 9, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 9, 1, 0, 0, 0, 0, 0}

//        {1, 1, 0, 0, 0, 0},
//        {x, 1, 0, 0, 0, 0},
//        {1, 1, 0, 0, 0, 0},
//        {0, 0, 0, 0, 0, 0},
//        {1, 2, 1, 1, 0, 0},
//        {x, 2, x, 1, 0, 0},
//        {1, 2, 1, 1, 1, 1},
//        {2, 2, 1, 0, 1, x},
//        {x, x, 2, 1, 2, 1},
//        {3, 3, 3, x, 1, 0},
//        {1, x, 2, 1, 1, 0},
//        {1, 2, 2, 1, 0, 0},
//        {0, 1, x, 1, 0, 0},
//        {0, 1, 1, 1, 0, 0},
//        {0, 0, 0, 0, 0, 0},
//        {0, 1, 1, 1, 0, 0},
//        {1, 2, x, 1, 0, 0},
//        {1, x, 2, 1, 0, 0},
//        {1, 2, 2, 1, 0, 0},
//        {1, 2, x, 1, 0, 0},
//        {1, x, 2, 1, 0, 0},
//        {1, 1, 1, 0, 0, 0}

//  init         aft met0                  expected
//  ? ? 0 0 0 0  ? 1 0 0 0 0  1 1 0 0 0 0  1 1 0 0 0 0
//  ? ? 0 0 0 0  ? 1 0 0 0 0  x 1 0 0 0 0  x 1 0 0 0 0
//  ? ? 0 0 0 0  1 1 0 0 0 0  1 1 0 0 0 0  1 1 0 0 0 0
//  0 0 0 0 0 0  0 0 0 0 0 0  0 0 0 0 0 0  0 0 0 0 0 0
//  ? ? ? ? 0 0  1 2 1 1 0 0  1 2 1 1 0 0  1 2 1 1 0 0
//  ? ? ? ? 0 0  ? ? ? 1 0 0  x 2 x 1 0 0  x 2 x 1 0 0
//  ? ? ? ? ? ?  ? ? 1 1 1 1  1 2 1 1 1 1  1 2 1 1 1 1
//  ? ? ? 0 ? ?  ? ? 1 0 1 ?  2 2 1 0 1 x  2 2 1 0 1 x
//  ? ? ? ? ? ?  ? ? 2 1 2 1  x x 2 1 2 1  x x 2 1 2 1
//  ? ? ? ? ? 0  ? ? ? ? 1 0  3 3 3 x 1 0  3 3 3 x 1 0
//  ? ? ? ? ? 0  ? ? ? 1 1 0  1 x 2 1 1 0  1 x 2 1 1 0
//  ? ? ? ? 0 0  1 2 ? 1 0 0  1 2 2 1 0 0  1 2 2 1 0 0
//  0 ? ? ? 0 0  0 1 ? 1 0 0  0 1 x 1 0 0  0 1 x 1 0 0
//  0 ? ? ? 0 0  0 1 1 1 0 0  0 1 1 1 0 0  0 1 1 1 0 0
//  0 0 0 0 0 0  0 0 0 0 0 0  0 0 0 0 0 0  0 0 0 0 0 0
//  0 ? ? ? 0 0  0 1 1 1 0 0  0 1 1 1 0 0  0 1 1 1 0 0
//  ? ? ? ? 0 0  1 2 ? 1 0 0  1 2 x 1 0 0  1 2 x 1 0 0
//  ? ? ? ? 0 0  ? ? ? 1 0 0  ? ? 2 1 0 0  1 x 2 1 0 0
//  ? ? ? ? 0 0  ? ? ? 1 0 0  ? ? 2 1 0 0  1 2 2 1 0 0
//  ? ? ? ? 0 0  ? ? ? 1 0 0  ? ? x 1 0 0  1 2 x 1 0 0
//  ? ? ? ? 0 0  ? ? 2 1 0 0  ? ? 2 1 0 0  1 x 2 1 0 0
//  ? ? ? 0 0 0  ? ? 1 0 0 0  ? ? 1 0 0 0  1 1 1 0 0 0
