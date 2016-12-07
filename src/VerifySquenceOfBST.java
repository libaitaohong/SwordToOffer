/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: VerifySquenceOfBST
 * 作者: zhanghe
 * 时间: 2016/12/7 16:23
 * 题目:二叉搜索树的后序遍历序列
 * 内容:输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。
 * 假设输入的数组的任意两个数字都互不相同。
 * 版本:
 * 运行时间：31ms 占用内存：629k
 * 备注:在递归中循环数组，从后往前循环，找到第一个小于根节点的数组位置
 * 如果没有比根节点大的数，则下标为根节点位置
 * 判断，如果小于根节点的数里面有比根节点大的数，，返回false。
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0) return false;
        return judge(sequence, 0, sequence.length-1);
    }
    public boolean judge(int[] sequence, int l, int r){
        if(l >= r) return true;
        int i = r;
        //这一步while既找到了第一个小于根节点的数，同时还保证遍历过的数都大于根节点
        //所以后面只要判断前半部分是否全部小于根节点即可
        //i > l来保证sequence[i - 1]不越界
        while(i > l && sequence[i - 1] > sequence[r]) --i;
        //这里j=i-1，因为i要么=l，要么i位置是第一个大于根节点的值
        //这里取为最后一个大于根节点的值，i-1就是最后一个小于根节点的值
        for(int j = i - 1; j >= l; --j)
            if(sequence[j] > sequence[r])
                return false;
        return judge(sequence, l, i - 1) && (judge(sequence, i, r - 1));
    }
}
