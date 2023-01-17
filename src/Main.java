public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        String b = "0 2 x\n0 2 x";
        int n = 2;

        MineSweeper ms = new MineSweeper(b, n);
        System.out.println(ms.solve());
    }
}