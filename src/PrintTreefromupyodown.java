import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: PrintTreefromupyodown
 * 作者: zhanghe
 * 时间: 2016/12/7 15:33
 * 题目:从上往下打印二叉树
 * 内容:从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 版本:
 * 运行时间：40ms 占用内存：503k
 * 备注:注意返回值类型，ArrayList<Integer>，写错成ArrayList<TreeNode>
 */
public class PrintTreefromupyodown {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(root == null) return arr;
        LinkedList<TreeNode> link = new LinkedList<>();
        link.add(root);
        while(link.size() != 0){
            TreeNode fir = link.removeFirst();
            arr.add(fir.val);
            if(fir.left != null)
                link.add(fir.left);
            if(fir.right != null)
                link.add(fir.right);
        }
        return arr;
    }
}
