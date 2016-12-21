/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: LastRemaining_Solution
 * 作者: zhanghe
 * 时间: 2016/12/21 20:30
 * 题目:圆圈中最后剩下的数
 * 内容:有顺序为0...n-1的n个数，给定一个数m，在n个数中删除第m个数，删除后，从被删除的下一个数重新开始。
 * 版本:1
 * 运行时间：31ms 占用内存：629k
 * 备注:
 */
public class LastRemaining_Solution {
    public int LastRemaining_Solution(int n, int m) {
        if(n <= 0) return -1;
        int f1 = 0;
        for(int i = 2; i <= n; i++){
            f1 = (f1 + m) % i;
        }
        return f1;
    }
}
