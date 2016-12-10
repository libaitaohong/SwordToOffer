/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: FindFirstCommonNode
 * 作者: zhanghe
 * 时间: 2016/12/10 11:19
 * 题目:两个链表的第一个公共结点
 * 内容:输入两个链表，找出它们的第一个公共结点。
 * 版本:
 * 运行时间：34ms 占用内存：688k
 * 备注:
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if(pHead1 == pHead2) return pHead1;
        if(pHead1 == null || pHead2 == null) return null;
        int count = 0;
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while(p1 != null){
            count++;
            p1 = p1.next;
        }
        while(p2 != null){
            count--;
            p2 = p2.next;
        }
        p1 = pHead1;
        p2 = pHead2;
        if(count > 0){
            while(count > 0){
                p1 = p1.next;
                count--;
            }
        }else if(count < 0){
            count = 0-count;
            while(count > 0){
                p2 = p2.next;
                count--;
            }
        }
        while(p1 != null && p2 != null){
            if(p1 != p2){
                p1 = p1.next;
                p2 = p2.next;
            }else
                return p1;
        }
        return null;
    }
}
