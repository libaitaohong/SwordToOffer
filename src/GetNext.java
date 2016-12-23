/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: GetNext
 * 作者: zhanghe
 * 时间: 2016/12/23 16:32
 * 题目:二叉树的下一个节点
 * 内容:给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 * 版本:
 * 运行时间：37ms 占用内存：709k
 * 备注:主要包括两种情况，pNode有右子树，没有右子树。
 * 1. 当有右子树时，只需找到右子树中序遍历的第一个节点，也就是最左边的节点即可
 * 2. 当没有右子树时，这时就需要判断pNode是它父亲的左孩子还是右孩子
 *      左孩子，那么下一个节点就是父亲
 *      右孩子，需要一直向上遍历，直到找到某一个祖先节点，是它父节点的左孩子，下一个节点是这个父节点
 *              若往上遍历一直到根都不是右孩子，那么最后一个节点就是当前节点，它下一个节点是空。
 */
public class GetNext {
    public TreeLinkNode GetNext(TreeLinkNode pNode){
        if(pNode == null) return null;
        TreeLinkNode cur = null;
        if(pNode.right != null){
            cur = pNode.right;
            while(cur.left != null){
                cur = cur.left;
            }
        }else{
            cur = pNode;
            //一直向上遍历，直到找到cur是左子树，下一个节点就是cur的父节点：cur.next
            //若pNode是最后一个节点下一个节点是空。函数会一直遍历到根，根节点的next是null
            while(cur.next != null && cur.next.right == cur){
                cur = cur.next;
            }
            cur = cur.next;
        }
        return cur;
    }
}
