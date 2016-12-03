/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: SquareCover
 * 作者: zhanghe
 * 时间: 2016/12/3 17:32
 * 题目:矩形覆盖
 * 内容:我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 * 版本:
 * 运行时间：33ms 占用内存：629k
 * 备注:依旧是斐波那契数列，能够推导出f(n) = f(n-1)+f(n-2)
 */
public class SquareCover {
    public int RectCover(int target) {
        if(target == 0) return 0;
        if(target == 1 || target == 2) return target;
        int res = 0;
        int f1 = 1;
        int f2 = 2;
        for(int i = 3; i <=target; i++){
            res = f1 + f2;
            f1 = f2;
            f2 = res;
        }
        return res;
    }
}
