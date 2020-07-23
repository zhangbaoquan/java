package search;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

 示例:

 现有矩阵 matrix 如下：

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 给定 target = 5，返回 true。

 给定 target = 20，返回 false。

 限制：

 0 <= n <= 1000
 0 <= m <= 1000
 */
public class FindNubArray {


    /**
     * 方案一：暴力遍历二维数组。时间复杂度O(nm)，空间复杂度：O(1)
     *
     * 方案二：线性查找。
     * 思路：
     * 由于每一列都按照从上到下递增的顺序排序。因此，可以从右上角作为判断的起始值，若目当前的值小于目标值，
     * 则从下一行的最后一列中找，否则从当前行的后一列找。因此需要利用两个指针，执行的效率和二分查找差不多
     * 时间复杂度：O(n + m)
     * 空间复杂度：O(1)
     * @param matrix 二维数组
     * @param target 目标值
     * @return 目标值是否在二维数组中
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        boolean result = false;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        int row = matrix.length;
        int columns = matrix[0].length;
        int currentRow = 0;
        int currentColumns = columns-1;
        while (currentRow < row && currentColumns >=0){
            int num = matrix[currentRow][currentColumns];
            if (num == target){
                return true;
            }else if (num > target){
                currentColumns --;
            } else if (num < target) {
                currentRow ++;
            }
        }
        return result;
    }
}
