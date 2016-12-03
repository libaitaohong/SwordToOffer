/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: IntPow
 * 作者: zhanghe
 * 时间: 2016/12/3 19:31
 * 题目:数值的整数次方
 * 内容:给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 版本:
 * 运行时间：30ms 占用内存：636k
 * 备注:要考虑底数为0，指数等于0的情况，指数大于0，小于0的情况
 * 将指数表示为2进制，并且:10^1101 = 10^0001*10^0100*10^1000。就相当于10^13=10^1*10^4*10^8
 * 通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
 * cur要乘以自身是因为，对指数进行移位的时候，代表了指数/2，第一次移位，底数乘完是^2,
 * 第二次移位，底数乘完就是^4,所以在指数当前二进制位等于1的时候，才能乘以正确的数。
 *
 */
public class IntPow {
    public double Power(double base, int exponent) {
        double res = 1, cur = base;
        int n;
        if(exponent > 0)
            n = exponent;
        else if(exponent < 0){
            if(base == 0)
                throw new RuntimeException("分母不能为0");
            n = -exponent;
        }
        else
            return 1;
        while(n != 0){
            if((n & 1) == 1)
                res *= cur;
            n = n >> 1;
            cur *= cur;
        }
        return (exponent > 0) ? res : (1/res);
    }
}
