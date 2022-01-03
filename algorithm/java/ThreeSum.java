import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 *	输入：nums = [-1,0,1,2,-1,-4]
 *	输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *	输入：nums = []
 * 	输出：[]
 * 示例 3：
 *	输入：nums = [0]
 *	输出：[]
 * 提示：
 *	0 <= nums.length <= 3000
 *	-105 <= nums[i] <= 105
 */
public class ThreeSum {
	/**
     * 时间复杂度: O(n^2)
     * 空间复杂度: O(n)
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res= new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return res;
        }
        Arrays.sort(nums);
        for (int k = 0; k < nums.length - 2; k++) {
            if (nums[k] > 0) {
                break;
            }
            if (k > 0 && nums[k] == nums[k-1]) {
                continue;
            }
            int i = k + 1;
            int j = nums.length - 1;
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    res.add(Arrays.asList(nums[k], nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i+1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j-1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (sum < 0) {
                    i++;
                } else {
                    j--;
                }
            }
        }
        return res;
    }
}