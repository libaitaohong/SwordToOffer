/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: JumpStage2
 * 作者: zhanghe
 * 时间: 2016/12/3 15:42
 * 题目:跳台阶2
 * 内容:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 版本:
 * 运行时间：31ms 占用内存：629k
 * 备注:f(n)=f(n-1)+f(n-2)+...+f(1)+1 -> f(n)= 2*f(n-1)
 */
public class JumpStage2 {
    public int JumpFloorII(int target) {
        if(target == 0) return 0;
        if(target == 1 || target == 2) return target;
        int s1 = 1;
        int s2 = 2;
        int count = s1 + s2 + 1;
        for(int i = 4; i <= target; i++){
            count += count;
        }
        return count;
    }
}
