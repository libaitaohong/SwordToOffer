/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: BinaryMirror
 * 作者: zhanghe
 * 时间: 2016/12/7 11:00
 * 题目:二叉树的镜像
 * 内容:操作给定的二叉树，将其变换为源二叉树的镜像。
 * 二叉树的镜像定义：源二叉树
              8
            /  \
          6   10
        / \  / \
       5  7 9 11
    镜像二叉树
            8
          /  \
        10   6
       / \  / \
      11 9 7  5
 * 版本:
 * 运行时间：37ms 占用内存：654k
 * 备注:利用递归，后序遍历，当每个节点没有左子树没有右子树，开始交换它的父节点左右子树，以此类推
 */
public class BinaryMirror {
    public void Mirror(TreeNode root) {
        if(root == null) return;
        Reverse(root);
    }
    public void Reverse(TreeNode root){
        if(root == null) return;
        Reverse(root.left);
        Reverse(root.right);
        swap(root);

    }
    public void swap(TreeNode root){
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
