package sorting;

import java.util.Arrays;

/**
 * Created by Imiracle Lee on 2017/9/2.
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = {53, 3, 542, 748, 14, 214, 154, 63, 616};
        quickSort(array, 0, array.length - 1);
        Arrays.stream(array).forEach(i -> System.out.printf("%-5d", i));
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int base = division(array, left, right);
        quickSort(array, left, base - 1);
        quickSort(array, base + 1, right);
    }

    private static int division(int[] array, int left, int right) {
        int base = array[left];
        while (left < right) {
            while (left < right && array[right] > base) {
                right--;
            }
            array[left] = array[right];
            while (left < right && array[left] < base) {
                left++;
            }
            array[right] = array[left];
        }
        array[left] = base;
        return left;
    }
}
