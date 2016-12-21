/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Duplicate
 * 作者: zhanghe
 * 时间: 2016/12/21 19:15
 * 题目:数组中重复的数字
 * 内容:在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，
 * 但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
 * 版本:2
 * 运行时间：37ms 占用内存：654k
 * 备注:若有重复返回TRUE，并把数字放入duplication[0]
 * 若无重复数字就返回false
 * 由于数组内数字不大于n-1，所以遍历一遍数组，若当前位置的数与下标不相等，就把当前位置数与等于当前数
 * 的下标位置的数进行交换，一直到当前下标与当前位置数相同，循环下一个位置；或者遇到了两个一样的数为止。
 * 代码中尽管有一个两重循环，但是每个数字最多只要交换两次就能找到属于他自己的位置，因此总的时间复杂度
 * 是O(n),不需要额外空间，空间复杂度是O(1)
 */
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 1) return false;
        for(int i = 0; i < length; ++i){
            if(numbers[i] < 0 || numbers[i] > length-1)
                return false;
            while(numbers[i] != i){
                if(numbers[numbers[i]] == numbers[i]){
                    duplication[0] = numbers[i];
                    return true;
                }
                swap(numbers, i, numbers[i]);
            }

        }
        return false;
    }
    public void swap(int[] numbers, int i, int j){
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }
}
