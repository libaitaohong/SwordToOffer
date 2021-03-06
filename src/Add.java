/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Add
 * 作者: zhanghe
 * 时间: 2016/12/20 19:53
 * 题目:不使用加减乘除做加法
 * 内容:写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 版本:
 * 运行时间：27ms 占用内存：503k
 * 备注:就是分两步模拟加法：
 * 1：异或，模拟二进制数不进位相加，0+0,1+1得0,0+1,1+0得1
 * 2：&操作，并左移一位，模拟进位，&操作后，只有两个1相与为1，也只有两个1相加产生进位。
 * 这时为1的位置就是产生进位的位置，再向左移一位，这时1在的位置就是需要加上进位的位置
 * 然后再将这两步结果相加，相加就是继续重复这两步，直到与操作为0，说明没有进位，加法结束。
 */
public class Add {
    public int Add(int num1,int num2) {
        while(num2 != 0){
            int num = num1^num2;
            num2 = (num1 & num2) << 1;
            num1 = num;
        }
        return num1;
    }
}
