package dynamicPlanning;

/**
 * Created by Imiracle Lee on 2017/8/24.
 */
public class MaxSubString {
    public static void main(String[] args) {
        System.out.println("Max : " + maxSubString(new int[]{0, -2, 3, 5, -1, 2}));
    }

    private static int maxSubString(int[] srcArray) {
        int length = srcArray.length;
        int max = srcArray[0];
        int mid = srcArray[0];
        for (int i = 1; i < length; i++) {
            mid = Math.max(srcArray[i], srcArray[i] + mid);
            max = Math.max(mid, max);
        }
        return max;
    }
}
