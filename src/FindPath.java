import java.util.ArrayList;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: FindPath
 * 作者: zhanghe
 * 时间: 2016/12/8 9:31
 * 题目:二叉树中和位某一值的路径
 * 内容:输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 版本:
 * 运行时间：39ms 占用内存：654k
 * 备注:先序遍历，每次若根节点不为空就添加进链表。然后再判断根节点有没有孩子
 * 注意函数拼写错误。
 */
public class FindPath {
    ArrayList<ArrayList<Integer>> allPath  = new ArrayList<>();
    ArrayList<Integer> Path  = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        getValue(root, target, 0);
        return allPath;
    }
    public void getValue(TreeNode root, int target, int total){
        if(root == null) return;
        total += root.val;
        Path.add(root.val);
        if(root.left == null && root.right == null){
            if(total == target){
                allPath.add(new ArrayList<Integer>(Path));
            }
        }
        if(root.left != null){
            getValue(root.left, target, total);
        }
        if(root.right != null){
            getValue(root.right, target, total);
        }
        Path.remove(Path.size()-1);
    }
}
