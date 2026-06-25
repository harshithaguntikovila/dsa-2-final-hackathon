public class FenwickTree {

    int[] BIT;
    int n;

    public FenwickTree(int n) {
        this.n = n;
        BIT = new int[n + 1];
    }

    public void update(int index, int value) {
        while (index <= n) {
            BIT[index] += value;
            index += index & (-index);
        }
    }

    public int query(int index) {
        int sum = 0;
        while (index > 0) {
            sum += BIT[index];
            index -= index & (-index);
        }
        return sum;
    }
}