/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: FindKToTileInLink
 * 作者: zhanghe
 * 时间: 2016/12/4 15:02
 * 题目:链表中倒数第k个节点
 * 内容:输入一个链表，输出该链表中倒数第k个结点。
 * 版本:
 * 运行时间：38ms 占用内存：654k
 * 备注:注意边界条件。k<=0时，k>链表长度时。
 */
public class FindKToTileInLink {
    public ListNode FindKthToTail(ListNode head,int k) {
        if(head == null || k <= 0) return null;
        ListNode fir = head;
        ListNode sec = head;
        for(int i = 1; i < k; i++){
            if(fir.next != null)
                fir = fir.next;
            else
                return null;
        }
        while(fir.next != null){
            fir = fir.next;
            sec = sec.next;
        }
        return sec;
    }
}
