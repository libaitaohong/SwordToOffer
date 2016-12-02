/**
 * Created by zhanghe on 2016/12/2.
 * 重建二叉树
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果
 * 中都不含重复的数字。例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，
 * 则重建二叉树并返回。
 * 给in和pre数组都设置了范围，巧妙计算数组下表
 */
public class BuildTree {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length != in.length || pre.length == 0) return null;
        TreeNode root =  buildTree(pre, 0, pre.length-1, in, 0, in.length-1);
        return root;
    }
    private TreeNode buildTree(int [] pre, int lpre, int rpre, int [] in, int lin, int rin){
        if(lpre > rpre || lin > rin) return null;
        TreeNode root = new TreeNode(pre[lpre]);
        for(int i = lin; i <= rin; i++){
            if(in[i] == pre[lpre]){
                root.left = buildTree(pre, lpre+1, lpre+i-lin, in, lin, i-1);
                root.right = buildTree(pre, i-lin+lpre+1, rpre, in, i+1, rin);
            }
        }
        return root;
    }
}
