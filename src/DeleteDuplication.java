/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: DeleteDuplication
 * 作者: zhanghe
 * 时间: 2016/12/22 21:35
 * 题目:删除链表中的重复节点
 * 内容:在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 版本:
 * 运行时间：35ms 占用内存：629k
 * 备注:设置一个头结点head的next为给定的头结点pHead
 * 设置结点last为最后加入链表的有效结点，初始值为head
 * 设置结点cur为当前遍历的节点
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead){
        if(pHead == null) return pHead;
        ListNode head = new ListNode(1);
        ListNode last = head;
        ListNode cur = pHead;
        while(cur != null){
            //如果cur.next==null，则说明当前cur也就是链表最后一个节点是单个的，需要加入到新链表中
            //这是因为有重复值的情况全在else里处理了
            if(cur.next == null || cur.val != cur.next.val){
                last.next = cur;
                last = cur;
            }else{
                //保证cur不越界，并且有重复值，就一直往下遍历
                while(cur.next != null && cur.val == cur.next.val){
                    cur = cur.next;
                }

            }
   //因为有重复的值全都不要，所以cur=cur.next
  // 即使cur与下一个值不相等，也不能确定cur.next就没有重复的，所以last.next也不能立刻指向cur
            cur = cur.next;
        }
        //这里是因为如果毕竟还是在一个链表里面操作，当last指向的节点后面并不一定没有重复值
        //因为last是最后一个加入“新”链表的有效值，所以last.next = null；
        last.next = null;
        return head.next;
    }
}
