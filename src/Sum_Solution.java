/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Sum_Solution
 * 作者: zhanghe
 * 时间: 2016/12/20 18:49
 * 题目:求1+2+3+...+n
 * 内容:求1+2+3+...+n，
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 版本:
 * 运行时间:
 * 备注:
 */
public class Sum_Solution {
    public int Sum_Solution(int n) {
        int sum = n;
        boolean ans = (n>0)&&((sum+=Sum_Solution(n-1))>0);
        return sum;
    }
}
