/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: HasSubtree
 * 作者: zhanghe
 * 时间: 2016/12/7 9:53
 * 题目:数的子结构
 * 内容:输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 版本:
 * 运行时间：34ms 占用内存：654k
 * 备注:利用递归搜索树1，若找到与数2根节点相等的节点，递归搜索数2
 */
public class HasSubtree {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        if(root1 == null || root2 == null) return false;
        return SerchTree(root1, root2);

    }
    public boolean SerchTree(TreeNode root1,TreeNode root2){
        boolean res = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val)
                res = TreeHasTree(root1, root2);
            if(!res)
                res = SerchTree(root1.left, root2);
            if(!res)
                res = SerchTree(root1.right, root2);
        }
        return res;
    }
    public boolean TreeHasTree(TreeNode root1, TreeNode root2){
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(root1.val != root2.val) return false;
        boolean res1 = false;
        boolean res2 = false;
        res1 = TreeHasTree(root1.left, root2.left);
        res2 = TreeHasTree(root1.right, root2.right);

        return res1 && res2;
    }
}
