import java.util.Arrays;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: IsContinuous
 * 作者: zhanghe
 * 时间: 2016/12/11 20:29
 * 题目:扑克牌顺子
 * 内容:随机抽5张牌,看看能不能抽到顺子。“红心A,黑桃3,小王,大王,方片5”，大\小 王可以看成任何数字,
 * 并且A看作1,J为11,Q为12,K为13。上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4)
 * 为了方便起见,认为大小王是0。
 * 版本:
 * 运行时间：32ms 占用内存：503k
 * 备注:就是数组中的数是不是连续的，0可以看做任何数
 * 首先将数组排序，然后遍历数组，
 * 记录有几个0，记录数组中非0相邻的数差值-1共多少，就是相邻数中间填入几个数才能连续
 * 然后判断这个差值与0谁多，若0多，数组就连续，若0少，则不连续。
 */
public class IsContinuous {
    public boolean isContinuous(int[] numbers) {
        if (numbers.length <= 0) return false;
        Arrays.sort(numbers);
        int count0 = 0;
        int count = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] == 0)
                count0++;
            else {
                if (numbers[i] == numbers[i + 1])
                    return false;
                if (numbers[i + 1] - numbers[i] > 1)
                    count += numbers[i + 1] - numbers[i] - 1;
            }
        }
        if (count <= count0)
            return true;
        return false;
    }
}