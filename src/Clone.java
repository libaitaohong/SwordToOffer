/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Clone
 * 作者: zhanghe
 * 时间: 2016/12/8 10:12
 * 题目:复杂链表的复制
 * 内容:输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * 版本:
 * 运行时间：33ms  占用内存：566k
 * 备注:拆分链表时，原链表也要完整的保留下来
 */
public class Clone {
    public RandomListNode Clone(RandomListNode pHead){
        if(pHead == null) return pHead;
        RandomListNode cur = pHead;
        RandomListNode next = null;
        RandomListNode a;
        while(cur != null){

            a = new RandomListNode(cur.label);
            a.next = cur.next;
            cur.next = a;
            cur =  a.next;
        }
        cur = pHead;
        while(cur != null){
            next = cur.next;
            if(cur.random != null){
                next.random = cur.random.next;
            }
            cur = next.next;
        }
        cur = pHead;
        RandomListNode newhead = cur.next;
        while(cur.next != null){
            a = cur.next;
            next = a.next;
            cur.next = next;
            cur = a;
        }
        return newhead;
    }
}
