package lc_bit;

public class ReverseBit_190 {
    public static void main(String[] args) {
        int n = 11110100;
        int res = reverseBits(n);
        String s = "00000010100101000001111010011100";

        System.out.println(s.length());
    }
    // you need treat n as an unsigned value
    public static int reverseBits(int n) {
        int res = 0, power = 7;
        while (n != 0) {
            res += (n & 1) << power;
            n = n >> 1;
            power --;
        }
        return res;
    }
}
