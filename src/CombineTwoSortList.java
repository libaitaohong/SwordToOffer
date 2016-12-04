/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: CombineTwoSortList
 * 作者: zhanghe
 * 时间: 2016/12/4 21:16
 * 题目:合并两个排序的链表
 * 内容:输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 版本:1
 * 运行时间：37ms 占用内存：654k
 * 备注:递归版本，书里写的递归版本
 */
public class CombineTwoSortList {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if(list1 == null) return list2;
        else if (list2 == null) return list1;
        ListNode head = null;
        if(list1.val < list2.val){
            head = list1;
            head.next = Merge(list1.next, list2);
        }else{
            head = list2;
            head.next = Merge(list1, list2.next);
        }
        return head;
    }
}
