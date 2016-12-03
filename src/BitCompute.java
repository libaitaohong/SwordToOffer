/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: BitCompute
 * 作者: zhanghe
 * 时间: 2016/12/3 18:04
 * 题目:位运算
 * 内容:输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * 版本:1
 * 运行时间：31ms 占用内存：528k
 * 备注:设置一个1，让1向左移位与数字n进行运算来确定是否为1
 */
public class BitCompute {
    public int NumberOf1(int n) {
        int count = 0;
        int flag = 1;
        while(flag != 0){
            if((flag & n) != 0)
                count++;
            flag = flag << 1;
        }
        return count;
    }
}
