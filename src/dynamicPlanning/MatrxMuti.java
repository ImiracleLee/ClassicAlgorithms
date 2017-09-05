package dynamicPlanning;

import java.util.Arrays;

/**
 * Created by Imiracle Lee on 2017/9/2.
 */
public class MatrxMuti {
    public static void main(String[] args) {
        matrxMuti(new int[]{10, 20, 50, 1, 100, 4, 20, 2});
    }

    private static int matrxMuti(int[] array) {
        int length = array.length;
        int[][] minArray = new int[length - 1][length - 1];
        //length-2为矩阵数
        for (int i = 0; i < length - 2; i++) {
            for (int j = 0; j < length - i - 2; j++) {
                int t = i + j + 1;
                minArray[j][t] = Integer.MAX_VALUE;
                for (int k = j; k < t; k++) {
                    minArray[j][t] = Math.min(minArray[j][t],
                            minArray[j][k] + minArray[k + 1][t] + array[j] * array[k + 1] * array[t + 1]);
                }
            }
        }
        Arrays.stream(minArray).forEach(a -> {
            Arrays.stream(a).forEach(i -> System.out.printf("%-6d", i));
            System.out.println();
        });
        return 0;
    }
}
