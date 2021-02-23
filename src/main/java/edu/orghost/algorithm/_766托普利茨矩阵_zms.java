package edu.orghost.algorithm;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * https://leetcode-cn.com/problems/toeplitz-matrix/.
 *
 * <pre>
 * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false 。
 * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵 。
 * </pre>
 *
 * @author zhangmsh 2021/2/23
 * @since 0.0.1
 */
public class _766托普利茨矩阵_zms {

  @Test
  public void test1() {
    int[][] matrix = {{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
    Solution solution = new Solution();
    boolean isToeplitzMatrix = solution.isToeplitzMatrix(matrix);
    Assertions.assertTrue(isToeplitzMatrix, "must be true");
  }

  @Test
  public void test2() {
    int[][] matrix = {{84}};
    Solution solution = new Solution();
    boolean isToeplitzMatrix = solution.isToeplitzMatrix(matrix);
    Assertions.assertTrue(isToeplitzMatrix, "must be true");
  }

  @Test
  public void test3() {
    //  11  74  0  93
    //  40  11  74  7
    int[][] matrix = {{11, 74, 0, 93}, {40, 11, 74, 7}};
    Solution solution = new Solution();
    boolean isToeplitzMatrix = solution.isToeplitzMatrix(matrix);
    Assertions.assertFalse(isToeplitzMatrix, "must be false");
  }

  @Test
  public void test4() {
    int[][] matrix = {
      {36, 59, 71, 15, 26, 82, 87}, {56, 36, 59, 71, 15, 26, 82}, {15, 0, 36, 59, 71, 15, 26}
    };
    // 36, 59, 71, 15, 26, 82, 87
    // 56, 36, 59, 71, 15, 26, 82
    // 15, 0,  36, 59, 71, 15, 26
    Solution solution = new Solution();
    boolean isToeplitzMatrix = solution.isToeplitzMatrix(matrix);
    Assertions.assertFalse(isToeplitzMatrix, "must be false");
  }

  class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
      // 如果matrix的长度小于2，则如{{8}}，这样为托普利茨矩阵
      if (matrix == null || matrix.length < 2) {
        return true;
      }

      // 将矩阵划分为X与Y轴，比如：
      //    X0  X1  X2  X3
      // Y0  1   2   3   4
      // Y1  5   1   2   3
      // Y2  9   5   1   2

      // 在如上的矩阵中，Y轴需要进行 Y高度 - 1 次的判断，即最后一行不需要判断
      // 取X0，则需要与Y的下一行及X的下一列进行判断是否相等，如果不相等则为false，以此类推
      // 比如：x0y0(1)则需要与(x1y1),(x2y2)判断是否都相等
      // x1y1(2)则需要判断(x2y2)，(x3y3)是否都相等

      // 一行一行匹配,最后一行不需要判断
      for (int y = 0, ylen = matrix.length - 1; y < ylen; y++) {
        int[] yDatas = matrix[y];
        for (int x = 0, xlen = yDatas.length - 1; x < xlen; x++) {
          int xVal = yDatas[x];
          int yVal = matrix[y + 1][x + 1];
          if (xVal != yVal) {
            return false;
          }
        }
      }
      return true;
    }
  }
}
