/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: MoreThanHalfNum_Solution
 * 作者: zhanghe
 * 时间: 2016/12/8 15:53
 * 题目:数组中出现次数超过一半的数字
 * 内容:数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，
 * 因此输出2。如果不存在则输出0。
 * 版本:
 * 运行时间：32ms占用内存：503k
 * 备注:就是利用出现次数超过数组的一半这个性质，使用times进行计数
 * 开始times=1，计数的数组值为数组第一个值，所以从数组的第二个数开始遍历。
 * 若当前数与times计数的数组值相等，times+1。如果当前数与times计数的数组值不相等，times-1
 * 如果times=0，则选取下一个出现的数开始计数。
 * 其实就相当于所有一样的数字个数相减，如果有超过一半的数字，那它的个数减去数组中其他数字的个数和还是大于0
 * 所以最后让times保持大于0的数，就有可能是这个长度超过一半的数字
 * 找到这个数后，再验证是不是出现的次数大于总个数的一半
 */
public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int [] array) {
        if(array.length == 0) return 0;
        int times = 1;
        int num = array[0];
        for(int i = 1; i < array.length; i++){
            if(times == 0){
                num = array[i];
                times = 1;
            }else if(array[i] == num){
                times += 1;
            }else
                times -= 1;
        }
        times = 0;
        for(int i = 0; i < array.length; i++){
            if(num == array[i])
                times++;
        }
        if(times*2 <= array.length)
            num = 0;
        return num;
    }
}
