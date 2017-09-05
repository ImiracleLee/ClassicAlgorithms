package sorting;

import java.util.Arrays;

/**
 * Created by Imiracle Lee on 2017/9/2.
 */
public class RadixSort {
    public static void main(String[] args) {
        radixSort(new int[]{53, 3, 542, 748, 14, 214, 154, 63, 616}, 1000);
    }

    private static int[] radixSort(int[] array, int max) {
        int length = array.length;
        int[][] bucketArray = new int[10][length];
        int[] countArray = new int[10];
        for (int n = 1; n < max; n *= 10) {
            for (int i : array) {
                int r = (i / n) % 10;
                bucketArray[r][countArray[r]] = i;
                countArray[r]++;
            }
//            Arrays.stream(radixArray).forEach(a -> {
//                Arrays.stream(a).forEach(i -> System.out.printf("%-6d", i));
//                System.out.println();
//            });
            int count = 0;
            for (int i = 0; i < 10; i++) {
                if (countArray[i] > 0) {
                    for (int j = 0; j < countArray[i]; j++) {
                        array[count] = bucketArray[i][j];
                        count++;
                    }
                    countArray[i] = 0;
                }
            }
        }
        Arrays.stream(array).forEach(i -> System.out.printf("%-5d", i));
        return array;
    }
}
