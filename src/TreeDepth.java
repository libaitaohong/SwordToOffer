/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: TreeDepth
 * 作者: zhanghe
 * 时间: 2016/12/11 10:50
 * 题目:二叉树的深度
 * 内容:输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 版本:
 * 运行时间：35ms 占用内存：654k
 * 备注:前序遍历
 */
public class TreeDepth {
    public int TreeDepth(TreeNode root) {
        if(root == null) return 0;
        return getHight(root);
    }
    public int getHight(TreeNode root){
        if(root == null)
            return 0;
        return Math.max(getHight(root.left),getHight(root.right))+1;
    }
}
