/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: FindGreatestSumOfSubArray
 * 作者: zhanghe
 * 时间: 2016/12/8 21:13
 * 题目:连续子数组的最大和
 * 内容:
 * 版本:2
 * 运行时间：运行时间：35ms 占用内存：654k
 * 备注:要注意全为负数的情况，Integer.MIN_VALUE是整形数的最小值
 * 使用dp来解决这个问题
 * 如果第i-1个位置的累加大于等于0，则与第i个位置数相加，否则让累加等于第i个数的值
 * 此时的max与count的较大值作为max的值
 */
public class FindGreatestSumOfSubArray {
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array.length == 0) return 0;
        int count = 0;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < array.length; i++){
            count = (count >= 0) ? count+array[i] : array[i];
            max = (count > max) ? count : max;
        }
        return max;
    }
}
