public class TestOutput {
    public static void main(String[] args) {
        int x = 11111111;
        int r = Integer.parseInt(Integer.toHexString(x & 0xff),16);
        System.out.println(r);
        byte e[] = Integer.toBinaryString(r).getBytes();
        System.out.println(e);
    }
}
