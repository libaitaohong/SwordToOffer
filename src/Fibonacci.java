/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Fibonacci
 * 作者: zhanghe
 * 时间: 2016/12/2 21:42
 * 题目:斐波那契数列
 * 内容:大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。n<=39
 * 版本:
 * 运行时间:运行时间：27ms 占用内存：629k
 * 备注:递归效率太低，用这种方法，减少重复值计算
 */
public class Fibonacci {
    public int Fibonacci1(int n) {
        if(n == 0) return 0;
        if(n == 1 || n == 2) return 1;
        int res = 0;
        int f1 = 1;
        int f2 = 1;
        for(int i = 3; i <=n; i++){
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }
}
