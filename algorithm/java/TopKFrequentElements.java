import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 */
public class TopKFrequentElements {
	/**
	 * 时间复杂度: O(n)
	 * 空间复杂度: O(n) 
	 */
	public int[] topKFrequent(int[] nums, int k) {
        if (nums == null || k <= 0) {
            return new int[0];
        } 
        
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Integer>[] arr = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);
            if (arr[i] == null) {
                arr[i] = new ArrayList<>();
            }
            arr[i].add(key);
        }

        int[] res = new int[k];
        int idx = 0;
        for (int i = arr.length - 1; i >=0 && idx < k; i--) {
            if (arr[i] == null) {
                continue;
            }
            for (int n : arr[i]) {
                if (idx < k) {
                    res[idx++] = n;
                } else {
                    break;
                }  
            }
        }
        return res;
    }
}
