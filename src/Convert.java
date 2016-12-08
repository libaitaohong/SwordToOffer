/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Convert
 * 作者: zhanghe
 * 时间: 2016/12/8 13:17
 * 题目:二叉搜索树与双向链表
 * 内容:输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * 版本:
 * 运行时间：32ms 占用内存：654k
 * 备注:设置全局变量ln来记录上次遍历到的节点
 * 采用中序遍历，ln一定为比root小的上一个节点
 */
public class Convert {
    TreeNode ln = null;
    public TreeNode Convert(TreeNode pRootOfTree) {
        if(pRootOfTree == null) return null;
        setList(pRootOfTree);
        while(pRootOfTree.left != null)
            pRootOfTree = pRootOfTree.left;
        return pRootOfTree;

    }
    public void setList(TreeNode root){
        if(root == null) return;
        if(root.left != null){
            setList(root.left);
        }
        root.left = ln;
        if(ln != null)
            ln.right = root;
        ln = root;
        if(root.right != null){
            setList(root.right);
        }

    }
}
