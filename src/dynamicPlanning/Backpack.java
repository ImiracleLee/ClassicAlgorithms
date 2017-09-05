package dynamicPlanning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Imiracle Lee on 2017/8/24.
 */
public class Backpack {
    public static void main(String[] args) {
        System.out.println("Max Value : "
                + backpack(new int[]{3, 5, 2, 7, 4, 1}, new int[]{2, 4, 1, 6, 5, 1}, 10));
    }

    private static int backpack(int[] volume, int[] value, int maxVolume) {
        int length = volume.length;
        int[][] maxValue = new int[length + 1][maxVolume + 1];
        String[][] vv = new String[length + 1][maxVolume + 1];
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < maxVolume + 1; j++) {
                if (volume[i] > j) {
                    maxValue[i + 1][j] = maxValue[i][j];
                    vv[i + 1][j] = vv[i][j];
                } else {
                    maxValue[i + 1][j] = Math.max(maxValue[i][j], maxValue[i][j - volume[i]] + value[i]);
                    if (maxValue[i][j - volume[i]] + value[i] > maxValue[i][j]) {
                        vv[i + 1][j] = vv[i + 1][j - volume[i]] + volume[i] + ":" + value[i] + " ";
                    }
                }
            }
            Arrays.stream(maxValue[i]).forEach(ints -> System.out.printf("%-5d", ints));
            System.out.println();
//            Arrays.stream(vv[i]).forEach(ints -> {
//                if (ints == null)
//                    System.out.printf("%-10s", "[]");
//                else
//                    System.out.printf("%-10s", "[" + ints.replace("null", "") + "]");
//            });
//            System.out.println();
        }
        Arrays.stream(maxValue[length]).forEach(ints -> System.out.printf("%-5d", ints));
        System.out.println();
        return maxValue[length][maxVolume];
    }
}
