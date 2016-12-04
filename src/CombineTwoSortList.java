/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: CombineTwoSortList
 * 作者: zhanghe
 * 时间: 2016/12/4 21:16
 * 题目:合并两个排序的链表
 * 内容:输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 版本:1
 * 运行时间：31ms 占用内存：503k
 * 备注:非递归版本，注意边界条件
 */
public class CombineTwoSortList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode head = null;
        ListNode cur = null;
        ListNode next = null;
        while(list1 != null && list2 != null){
            if(list1.val < list2.val){
                if(head == null){
                    head = list1;
                    cur = head;
                }else{
                    cur.next = list1;
                    cur = cur.next;
                }
                list1 = list1.next;
            }else{
                if(head == null){
                    head = list2;
                    cur = head;
                }else{
                    cur.next = list2;
                    cur = cur.next;
                }
                list2 = list2.next;
            }
        }
        if(list1 == null)
            cur.next = list2;
        if(list2 == null)
            cur.next = list1;
        return head;
    }
}
