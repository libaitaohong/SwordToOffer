/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: IsBalanced_Solution
 * 作者: zhanghe
 * 时间: 2016/12/11 12:28
 * 题目:平衡二叉树
 * 内容:输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 版本:
 * 运行时间：40ms 占用内存：654k
 * 备注:设置数组res来记录左右子树是不是平衡二叉树
 * level是当前节点root的深度
 * 首先查看根节点的左子树是不是平衡二叉树，再查看右子树，若有子树不是平衡二叉树，则返回level
 * 返回level其实就是因为有子树不是平衡二叉树了，那整棵树也不是，就没有必要继续遍历了。
 * 如果左右子树都是平衡二叉树，那就看两棵树的差值是不是在1之内，不在就将res置为false。
 * 最后根据一开始设置的数组来确定是不是平衡二叉树。
 */
public class IsBalanced_Solution {
    public boolean IsBalanced_Solution(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        getHight(root, 1, res);
        return res[0];
    }
    public int getHight(TreeNode root, int level, boolean[] res){
        if(root == null)
            return level;
        int lh = getHight(root.left, level+1, res);
        if(!res[0])
            return level;
        int rh = getHight(root.right, level+1, res);
        if(!res[0])
            return level;
        if(Math.abs(lh - rh) > 1)
            res[0] = false;
        return Math.max(lh, rh);
    }
}
