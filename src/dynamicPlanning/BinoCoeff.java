package dynamicPlanning;

import java.util.Arrays;

/**
 * 动态规划  计算二项式系数
 * Created by Imiracle Lee on 2017/8/22.
 */
public class BinoCoeff {
    public static void main(String[] args) {
        System.out.println("输出8的二项式系数：" + Binomial(18, 17));
        System.out.println("输出8的二项式系数：" + myBinomial(18, 7));
    }

    public static int Binomial(int n, int k) {
        //计算二项式系数C(n,k)
        int[][] result = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {   //按行来填矩阵
            for (int j = Math.max(0, i + k - n); j <= Math.min(i, k); j++) {   // min(i,k)是这一行需要填的列数
                if (j == 0 || j == i)
                    result[i][j] = 1;
                else
                    result[i][j] = result[i - 1][j - 1] + result[i - 1][j];
            }
            Arrays.stream(result[i]).forEach(ints -> System.out.printf("%-5d", ints));
            System.out.println();
        }
        return result[n][k];
    }

    public static int myBinomial(int n, int k) {
        int[] result = new int[k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = Math.min(i, k); j >= Math.max(0, i + k - n); j--) {
                if (j == 0 || j == i) {
                    result[j] = 1;
                } else {
                    result[j] += result[j - 1];
                }
            }
            Arrays.stream(result).forEach(ints -> System.out.printf("%-5d", ints));
            System.out.println();
        }
        return result[k];
    }
}
