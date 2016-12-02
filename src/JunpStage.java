/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: JunpStage
 * 作者: zhanghe
 * 时间: 2016/12/2 21:53
 * 题目:跳台阶
 * 内容:一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 版本:
 * 运行时间：37ms 占用内存：654k
 * 备注:与斐波那契数列的解题思路是一样的
 */
public class JunpStage {
    public int JumpFloor(int target) {
        if(target == 0) return 0;
        if(target == 1 || target == 2)
            return target;
        int count = 0;
        int s1 = 1; //只有一个台阶的跳法数
        int s2 = 2;//只有两个台阶的跳法数
        for(int i = 3; i <= target; i++){
            count = s1 + s2;
            s1 = s2;
            s2 = count;
        }
        return count;
    }
}
