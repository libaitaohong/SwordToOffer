/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: ReverseList
 * 作者: zhanghe
 * 时间: 2016/12/4 19:41
 * 题目:反转链表
 * 内容:输入一个链表，反转链表后，输出链表的所有元素。
 * 版本:
 * 运行时间：34ms 占用内存：688k
 * 备注:
 */
public class ReverseList {
    public ListNode ReverseList(ListNode head) {
        if(head == null) return null;
        ListNode pre = head;
        ListNode cur = head.next;
        pre.next = null;
        ListNode next = null;
        while (cur != null){
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
