/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: MovingCount
 * 作者: zhanghe
 * 时间: 2016/12/26 9:28
 * 题目:机器人的运行范围
 * 内容:地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，每一次只能向左，右，上，
 * 下四个方向移动一格，但是不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格（35,37），因为3+5+3+7 = 18。但是，它不能进入方格（35,38），
 * 因为3+5+3+8 = 19。请问该机器人能够达到多少个格子？
 * 版本:
 * 运行时间：35ms 占用内存：654k
 * 备注:机器人在表格里走过的格子不需要再重置为0，因为这是计算共能走多少个格子，而不是计算路径是否有
 */
public class MovingCount {
    public int movingCount(int threshold, int rows, int cols){
        int[] flag = new int[rows*cols];
        return getNum(threshold, rows, cols, 0, 0, flag);

    }
    public int getNum(int threshold, int rows, int cols, int i, int j, int[] flag){
        int index = i*cols + j;
        if(i < 0 || i >= rows || j < 0 || j >= cols || getSum(i)+getSum(j) > threshold || flag[index] == 1)
            return 0;
        flag[index] = 1;
        int res = 0;
        res = 1 + getNum(threshold, rows, cols, i+1, j, flag)
                + getNum(threshold, rows, cols, i, j+1, flag)
                + getNum(threshold, rows, cols, i-1, j, flag)
                + getNum(threshold, rows, cols, i, j-1, flag);
        return res;
    }
    public int getSum(int num){
        int sum = 0;
        while(num > 0){
            sum += num%10;
            num /= 10;
        }
        return sum;
    }
}
