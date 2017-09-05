package sorting;

import java.util.Arrays;

/**
 * Created by Imiracle Lee on 2017/9/2.
 */
public class CountSort {
    public static void main(String[] args) {
        countSort(new int[]{2, 4, 6, 3, 5, 2, 1, 4, 5, 2, 5}, 6);
    }

    private static int[] countSort(int[] array, int max) {
        int length = array.length;
        int[] countArray = new int[max + 1];
        for (int i : array) {
            countArray[i] += 1;
        }
        Arrays.stream(countArray).forEach(i -> System.out.printf("%-3d", i));
        System.out.println();
        int sum = 0;
        for (int i = 0; i < max + 1; i++) {
            sum += countArray[i];
            countArray[i] = sum;
        }
        Arrays.stream(countArray).forEach(i -> System.out.printf("%-3d", i));
        System.out.println();
        int[] resultArray = new int[length];
        for (int i = length - 1; i >= 0; i--) {
            resultArray[countArray[array[i]] - 1] = array[i];
            countArray[array[i]]--;
        }
        Arrays.stream(resultArray).forEach(i -> System.out.printf("%-3d", i));
        return resultArray;
    }
}
