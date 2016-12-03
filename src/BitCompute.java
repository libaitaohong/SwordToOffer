/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: BitCompute
 * 作者: zhanghe
 * 时间: 2016/12/3 18:04
 * 题目:位运算
 * 内容:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 版本:2
 * 运行时间：34ms 占用内存：654k
 * 备注:一个数减一后，它的最右边的一变成0，这个1后面的0全部变成1，这时将这个数与原来的数进行与操作，
 * 最右边第一个1以及它右面的数全变成0，能进行几次减一操作，就有几个1.
 */
public class BitCompute {
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0){
            count++;
            n = (n-1) & n;
        }
        return count;
    }
}
