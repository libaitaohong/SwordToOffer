/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: FindGreatestSumOfSubArray
 * 作者: zhanghe
 * 时间: 2016/12/8 21:13
 * 题目:连续子数组的最大和
 * 内容:
 * 版本:1
 * 运行时间：28ms占用内存：688k
 * 备注:要注意全为负数的情况，Integer.MIN_VALUE是整形数的最小值
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0) return 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            if(count <= 0)
                count = array[i];
            else
                count +=array[i];
            if(count > max)
                max = count;

        }
        return max;
    }
}
