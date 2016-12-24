/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: KthNode
 * 作者: zhanghe
 * 时间: 2016/12/24 19:21
 * 题目:二叉搜索树的第k个结点
 * 内容:给定一颗二叉搜索树，请找出其中的第k大的结点。
 * 例如， 5 / \ 3 7 /\ /\ 2 4 6 8 中，按结点数值大小顺序第三个结点的值为4。
 * 版本:1
 * 运行时间：37ms 占用内存：688k
 * 备注:使用中序遍历，设置数组count记录遍历到中序遍历的第几个数字，get来判断是否遍历到目标节点，并记录
 */
public class KthNode {
    TreeNode KthNode(TreeNode pRoot, int k){
        if(pRoot == null || k == 0) return null;
        int[] count = {1};
        TreeNode[] get = {null};
        getK(pRoot, k, count, get);
        return get[0];
    }
    public void getK(TreeNode root, int k, int[] count, TreeNode[] get){
        if(get[0] != null) return; //若找到目标点，则不再执行
        if(root == null) return;
        getK(root.left, k, count, get);
        if(count[0] != k){
            count[0]++;
        }else if(get[0] == null){ // 这里要判断数组是否为空，否则在找到目标点后的递归中，这里会重复执行
            get[0] = root;
        }
        getK(root.right, k, count, get);
    }
}
