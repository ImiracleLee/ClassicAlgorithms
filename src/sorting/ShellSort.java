package sorting;

import java.util.Arrays;

/**
 * Created by Imiracle Lee on 2017/9/3.
 */
public class ShellSort {
    public static void main(String[] args) {
        shellSort(new int[]{53, 3, 542, 748, 14, 214, 154, 63, 616});
    }

    private static void shellSort(int[] array) {
        int length = array.length;
        for (int gap = length >> 1; gap > 0; gap /= 2) {
            for (int i = gap; i < length; i++) {
                int j, temp = array[i];
                for (j = i - gap; j >= 0 && temp < array[j]; j -= gap) {
                    array[j + gap] = array[j];
                }
                array[j + gap] = temp;
            }
            Arrays.stream(array).forEach(i -> System.out.printf("%-5d", i));
            System.out.println();
        }
    }
}
