package array;

/**
 * @author coffer
 * @Description : 找到无序数组中第二大的数
 * @date 2021/7/6 10:45 上午
 */
public class FindSec2 {


    private static int findSec2Nub(int arr[]){
        int max = Integer.MIN_VALUE; // 最大值
        int sec = max;  // 第二大数
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                // 将上一个最大值变成第二大值
                sec = max;
                // 更新现在的最大值
                max = arr[i];
            }else if (arr[i] < max){
                // 小于最大值，且大于第二大值，更新
                if (arr[i] > sec){
                    sec = arr[i];
                }
            }
        }
        return sec;
    }

}
