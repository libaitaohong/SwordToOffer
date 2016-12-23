/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: IsSymmetrical
 * 作者: zhanghe
 * 时间: 2016/12/23 20:00
 * 题目:对称的二叉树
 * 内容:请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 版本:
 * 运行时间：39ms 占用内存：654k
 * 备注:
 */
public class IsSymmetrical {

    boolean isSymmetrical(TreeNode pRoot){
        return judge(pRoot,pRoot);
    }
    public boolean judge(TreeNode p, TreeNode q){
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        if(p.val != q.val) return false;
        return judge(p.left, q.right) && judge(p.right, q.left);
    }
}
