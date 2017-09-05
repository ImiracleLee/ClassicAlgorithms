package sorting;

import java.util.Arrays;

/**
 * Created by Imiracle Lee on 2017/9/2.
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] array = {53, 3, 542, 748, 14, 214, 154, 63, 616};
        mergeSort(array);
        Arrays.stream(array).forEach(i -> System.out.printf("%-5d", i));
    }

    private static void mergeSort(int[] array) {
        int length = array.length;
        for (int i = 1; i < length; i *= 2) {
            int j;
            for (j = 0; 2 * i + j - 1 < length; j += (i << 1)) {
                mergeSort(array, j, 2 * i + j - 1);
            }
            if (i + j - 1 < length) {
                mergeSort(array, j, length - 1);
            }
        }
    }

    private static void mergeSort(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) >> 1;
//        mergeSort(array, low, mid);
//        mergeSort(array, mid + 1, high);
        int i = low, j = mid + 1, k = low;
        int[] temp = array.clone();
        while (i <= mid && j <= high) {
            if (temp[i] > temp[j]) {
                array[k] = temp[j];
                j++;
            } else {
                array[k] = temp[i];
                i++;
            }
            k++;
        }
        while (i <= mid) {
            array[k] = temp[i];
            i++;
            k++;
        }
        while (j <= high) {
            array[k] = temp[j];
            j++;
            k++;
        }
    }
}
