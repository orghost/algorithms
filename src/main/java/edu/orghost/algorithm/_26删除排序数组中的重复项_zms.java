package edu.orghost.algorithm;

import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * 删除排序数组中的重复项.
 *
 * <pre>
 * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 示例1:
 *
 * 给定数组 nums = [1,1,2],
 *
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 * 示例2:
 *
 * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *
 * 你不需要考虑数组中超出新长度后面的元素。
 * </pre>
 *
 * @author zhangmsh 2021/2/23
 * @since 简单
 */
public class _26删除排序数组中的重复项_zms {

  @Test
  public void test1() {
    int[] nums = {1, 1, 2};
    Solution solution = new Solution();
    int newLenght = solution.removeDuplicates(nums);
    this.assertResult(nums, newLenght);
  }

  @Test
  public void test2() {
    int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
    Solution solution = new Solution();
    int newLenght = solution.removeDuplicates(nums);
    this.assertResult(nums, newLenght);
  }

  @Test
  public void test3() {
    int[] nums = {1, 1, 2, 3, 4, 4, 5, 6, 7, 8, 8, 9};
    Solution solution = new Solution();
    int newLenght = solution.removeDuplicates(nums);
    this.assertResult(nums, newLenght);
  }

  private void assertResult(int[] nums, int newLenght) {
    System.out.println(Arrays.toString(nums) + ", newLength " + newLenght);
    if (newLenght > 0) {
      int tmp = nums[0];
      for (int i = 1; i < newLenght; i++) {
        Assertions.assertNotEquals(tmp, nums[i], "must be not equals");
        tmp = nums[i];
      }
    }
  }

  class Solution {
    public int removeDuplicates(int[] nums) {
      int len;
      if (nums == null || (len = nums.length) < 1) {
        return 0;
      }
      if (len == 1) {
        return 1;
      }
      int tmp = nums[0];
      int pos = 1;
      for (int i = 1; i < len; i++) {
        if (tmp != nums[i]) {
          tmp = nums[i];
          nums[pos++] = tmp;
        }
      }
      return pos;
    }
  }
}
