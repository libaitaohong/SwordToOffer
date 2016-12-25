import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: MaxInWindows
 * 作者: zhanghe
 * 时间: 2016/12/25 16:03
 * 题目:滑动窗口的最大值
 * 内容:给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入
 * 数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}；
 * 版本:
 * 运行时间：30ms 占用内存：688k
 * 备注:设置队列count用来记录每一组窗口里的最大值，count里面是数组下标，count里面从大到小排列
 * 当count为空，直接将当前下标放入窗口中
 * 若count最后值j，num[j] > num[i],直接将i放入count中。
 * 就是如果当前节点的值比同一窗口中之前出现的值中的最小值还小，就将其加入到窗口中。
 * 若比之前同一窗口的最小值大，就将最小值弹出，直到遇到比当前值大的值为止，这是再将当前值加入到count中。
 * 需要注意的是，count里面存储值全是属于当前窗口的值，一旦当前位置i与count的第一个值的差等于size，
 * 这说明count的第一个值已经不是当前窗口的值了，所以将这个值弹出去。
 * 对于存储最大值的max链表：
 * 当下标走到窗口大小size-1时，这时i在第一个窗口的最后一个位置，这时产生了第一个窗口的最大值，
 * 就是当前count链表的第一个值。
 * 从此以后，下标i每向后走一步都需要将当前count的第一个值输出出来作为当前窗口的最大值。
 *
 */
public class MaxInWindows {
    public ArrayList<Integer> maxInWindows(int [] num, int size){
        ArrayList<Integer> max = new ArrayList<>();
        if(num == null || num.length < size || size <= 0) return max;
        LinkedList<Integer> count = new LinkedList<>();
        for(int i = 0; i < num.length; i++){
            while(!count.isEmpty() && num[count.getLast()] < num[i])
                count.removeLast();
            count.add(i);
            if(count.getFirst() == i-size)
                count.pop();
            if(i >= size-1)
                max.add(num[count.peek()]);
        }
        return max;
    }
}
