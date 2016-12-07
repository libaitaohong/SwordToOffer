import java.util.ArrayList;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: PrintMatrix
 * 作者: zhanghe
 * 时间: 2016/12/7 13:46
 * 题目:顺时针打印矩阵
 * 内容:输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 版本:
 * 运行时间：32ms 占用内存：566k
 * 备注:
 */
public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        if (matrix.length == 0) return res;
        int raw = matrix.length;
        int column = matrix[0].length;
        int layer = (Math.min(raw, column)-1)/2+1; //求出共需要打印多少圈
        for(int i = 0; i < layer; i++){
            for(int lr = i; lr < column-i; lr++)//从左边第一个到右边最后一个，
                res.add(matrix[i][lr]);
            for(int ud = i+1; ud < raw - i; ud++)//从上边第二个到下面最后一个
                res.add(matrix[ud][column-i-1]);
            //从右边倒数第二个到左边第一个，raw-1-i != i是为了保证在只剩一行时，不再重复打印
            for(int rl = column-i-2; (rl >= i)&&(raw-1-i != i); rl--)
                res.add(matrix[raw-1-i][rl]);
            //从下边倒数第二个到上边第二个，column-1-i != i是为了保证在只剩一列时，不再重复打印
            for(int du = raw-2-i; (du > i)&&(column-1-i != i); du--)
                res.add(matrix[du][i]);
        }
        return res;
    }
}
