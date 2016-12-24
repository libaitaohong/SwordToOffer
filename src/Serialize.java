/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Serialize
 * 作者: zhanghe
 * 时间: 2016/12/23 20:44
 * 题目:序列化二叉树
 * 内容:请实现两个函数，分别用来序列化和反序列化二叉树
 * 版本:
 * 运行时间：41ms 占用内存：629k
 * 备注:序列化二叉树，使用前序遍历
 * 反序列化，首先将字符串转化为数组
 */
public class Serialize {
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if(root == null){
            sb.append("#,"); //当前节点为空，添加#代表
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();

    }
    int index = -1;
    TreeNode Deserialize(String str) {
        if(str == null) return null;
        String[] str1 = str.split(",");
        return deseria(str1);
    }
    public TreeNode deseria(String[] str1){
        index++;
        TreeNode node = null;
        if(!str1[index].equals("#")){
            node = new TreeNode(Integer.valueOf(str1[index]));
            node.left = deseria(str1);
            node.right = deseria(str1);
        }
        return node;
    }
}
