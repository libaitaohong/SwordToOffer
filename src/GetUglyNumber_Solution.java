/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: GetUglyNumber_Solution
 * 作者: zhanghe
 * 时间: 2016/12/9 15:58
 * 题目:丑数
 * 内容:把只包含因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，
 * 因为它包含因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 版本:
 * 运行时间：34ms  占用内存：629k
 * 备注:因为丑数的因子都是2、3、5，所以可以用前面计算好的丑数乘以2、3、5，找到最小的那个作为当前丑数
 * 设t2、t3、t5分别为2、3、5乘过得丑数下标，一开始都为0。
 * 让2、3、5从1开始乘，哪个乘完最小，谁的下标加一，并且这个数就是当前位置的丑数
 */
public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        if(index <= 0) return 0;
        int[] arr = new int[index];
        arr[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for(int i = 1; i < index; i++){
            arr[i] = Math.min(2*arr[t2], Math.min(3*arr[t3], 5*arr[t5]));
            if(arr[i] == 2*arr[t2]) t2++;
            if(arr[i] == 3*arr[t3]) t3++;
            if(arr[i] == 5*arr[t5]) t5++;
        }
        return arr[index-1];
    }
}
