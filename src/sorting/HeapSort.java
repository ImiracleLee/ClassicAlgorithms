package sorting;

import java.util.Arrays;

/**
 * Created by Imiracle Lee on 2017/9/3.
 */
public class HeapSort {
    public static void main(String[] args) {
        heapSort(new int[]{1, 3, 4, 5, 2, 6, 9, 7, 8, 0});
    }

    private static int[] heapSort(int[] array) {
        int length = array.length;
        for (int i = length >> 1; i >= 0; i--) {
            heapAdjust(array, i, length);
        }
        for (int i = length - 1; i > 0; i--) {
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            heapAdjust(array, 0, i);
            Arrays.stream(array).forEach(a -> System.out.printf("%-3d", a));
            System.out.println();
        }
        return array;
    }

    private static void heapAdjust(int[] array, int parent, int length) {
        int temp = array[parent];
        int child = (parent << 1) + 1;
        while (child < length) {
            if (child + 1 < length && array[child] < array[child + 1]) {
                child++;
            }
            if (temp >= array[child]) {
                break;
            }
            array[parent] = array[child];
            parent = child;
            child = (child << 1) + 1;
        }
        array[parent] = temp;
    }

    private static void printPart(int[] list, int begin, int end) {
        for (int i = 0; i < begin; i++) {
            System.out.print("\t");
        }
        for (int i = begin; i <= end; i++) {
            System.out.print(list[i] + "\t");
        }
        System.out.println();
    }

}
