import java.util.ArrayList;

/**
 * Created by zhanghe on 2016/12/1.
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 将链表倒序后压入ArrayList中
 * 还可以使用stack来实现
 * 运行时间：32ms
 占用内存：503k
 */
public class ReverseOrderOutput {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> arr = new ArrayList<>();
        if(listNode == null) return arr;

        ListNode pre = listNode;
        ListNode cur = pre.next;
        ListNode n = null;
        pre.next = null;
        while(cur != null){
            n = cur.next;
            cur.next = pre;
            pre = cur;
            cur = n;
        }
        ListNode next = null;
        while(pre != null){
            next = pre.next;
            arr.add(pre.val);
            pre = next;
        }
        return arr;
    }
}
class ListNode {
    int val;
    ListNode next = null;
    ListNode(int val) {
        this.val = val;
    }
}