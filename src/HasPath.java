/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: HasPath
 * 作者: zhanghe
 * 时间: 2016/12/25 20:45
 * 题目:矩阵中的路径
 * 内容:请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。
 * 路径可以从矩阵中的任意一个格子开始，每一步可以在矩阵中向左，向右，向上，向下移动一个格子。
 * 如果一条路径经过了矩阵中的某一个格子，则该路径不能再进入该格子。
 * 例如 a b c e s f c s a d e e 矩阵中包含一条字符串"bccced"的路径，但是矩阵中不包含"abcb"路径，
 * 因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入该格子。
 * 版本:
 * 运行时间：32ms 占用内存：688k
 * 备注:使用回溯法
 * 需要建立一个同样的数组，用来记录该位置是不是已经访问过。
 */
public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str){
        int[] flag = new int[matrix.length];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(judge(matrix, rows, cols, i, j, str, 0, flag))
                    return true;
            }
        }
        return false;
    }
    public boolean judge(char[] matrix, int rows, int cols, int i, int j, char[] str, int k, int[] flag){
        int index = i * cols + j;
        if(i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || flag[index] == 1)
            return false;
        if(k == str.length-1)
            return true;
        flag[index] = 1;
        if(judge(matrix, rows, cols, i+1, j, str, k+1, flag)
                || judge(matrix, rows, cols, i, j+1, str, k+1, flag)
                || judge(matrix, rows, cols, i-1, j, str, k+1, flag)
                || judge(matrix, rows, cols, i, j-1, str, k+1, flag))
            return true;
        flag[index] = 0;
        return false;
    }
}
