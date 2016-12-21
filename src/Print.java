import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Print
 * 作者: zhanghe
 * 时间: 2016/12/21 21:41
 * 题目:按之字形打印二叉树
 * 内容:请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 版本:
 * 运行时间：38ms 占用内存：528k
 * 备注:
 */
public class Print {
    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> allNode = new ArrayList<>();
        if(pRoot == null) return allNode;
        LinkedList<TreeNode> order = new LinkedList<>();
        boolean lr = true;
        order.add(pRoot);
        while(order.size() != 0){
            ArrayList<Integer> node = new ArrayList<>();
            int size = order.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = order.pop();
                if(lr){
                    node.add(cur.val);
                }else{
                    node.add(0, cur.val);
                }
                if(cur.left != null)
                    order.add(cur.left);
                if(cur.right != null)
                    order.add(cur.right);
            }
            allNode.add(node);
            lr = !lr;
        }
        return allNode;
    }
}
