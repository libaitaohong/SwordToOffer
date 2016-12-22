/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: EntryNodeOfLoop
 * 作者: zhanghe
 * 时间: 2016/12/22 21:10
 * 题目:链表中环的入口节点
 * 内容:一个链表中包含环，请找出该链表的环的入口结点。
 * 版本:
 * 运行时间：35ms 占用内存：629k
 * 备注:即使告诉是一个有环链表，还是要判断是否有环。测试用例中就有没有环的
 */
public class EntryNodeOfLoop {
    public ListNode EntryNodeOfLoop(ListNode pHead){
        if(pHead == null) return null;
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow){
                fast = pHead;
                while(fast != slow){
                    slow = slow.next;
                    fast = fast.next;
                }
                if(fast == slow)
                    return fast;
            }
        }
        return null;
    }
}
