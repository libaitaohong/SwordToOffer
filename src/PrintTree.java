import java.util.ArrayList;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: PrintTree
 * 作者: zhanghe
 * 时间: 2016/12/23 20:15
 * 题目:把二叉树打印成多行
 * 内容:从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 版本:
 * 运行时间：36ms 占用内存：629k
 * 备注:
 */
public class PrintTree {
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> allNode = new ArrayList<>();
        if(pRoot == null) return allNode;
        ArrayList<TreeNode> order = new ArrayList<>();
        order.add(pRoot);
        while(!order.isEmpty()){
            ArrayList<Integer> node = new ArrayList<>();
            int size = order.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = order.remove(0);
                node.add(cur.val);
                if(cur.left != null)
                    order.add(cur.left);
                if(cur.right != null)
                    order.add(cur.right);
            }
            allNode.add(node);
        }
        return allNode;
    }
}
