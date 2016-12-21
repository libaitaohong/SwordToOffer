/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Duplicate
 * 作者: zhanghe
 * 时间: 2016/12/21 19:15
 * 题目:数组中重复的数字
 * 内容:在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 * 版本:
 * 运行时间：30ms 占用内存：629k
 * 备注:若有重复返回TRUE，并把数字放入duplication[0]
 * 若无重复数字就返回false
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length == 0 || length == 1) return false;
        int[] count = new int[length];
        for(int i = 0; i < length; i++){
            count[numbers[i]]++;
            if(count[numbers[i]] >= 2){
                duplication[0] = numbers[i];
                return true;
            }
        }
        return false;
    }
}
