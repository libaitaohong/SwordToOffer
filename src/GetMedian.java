import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: GetMedian
 * 作者: zhanghe
 * 时间: 2016/12/25 13:43
 * 题目:数据流中的中位数
 * 内容:如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，
 * 那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，
 * 那么中位数就是所有数值排序之后中间两个数的平均值。
 * 版本:
 * 运行时间:
 * 备注:建立两个堆，一个大顶堆存储数据流中较小的一半，一个小顶堆，存储数据流中较大的一半
 * 让两个堆中的元素相差不超过1，就是一个加入小顶堆，一个加入大顶堆，依次循环
 * 使用优先级队列，会自动从小到大排序，设其为min。改变比较函数compare，让其从大到小排序，就是max
 * 一开始设置计算数据流输入元素个数count = 0，当其加入到堆中后，再计数输入流个数count+1，防止多加1。
 * 当count%2 != 0时，加入大顶堆，其余情况加入小顶堆。最开始count=0，先加入小顶堆，随后count++；
 * 所以在实际实现中，第奇数个数据加入了小顶堆，第偶数个数据加入了大顶堆。
 * 在往大顶堆中加入数据时，先将数据加入小顶堆，把小顶堆中最小的弹出加入大顶堆中，
 *      来保证大顶堆中的数都小于小顶堆。
 * 在往小顶堆中加入数据时，先将数据加入大顶堆，把大顶堆中最大的弹出加入小顶堆中，
 *      来保证小顶堆中的数都大于大顶堆。
 * 在GetMedian函数中，当count的个数是偶数，就将大小顶堆的堆顶相加除以2，并转换为Double格式输出
 * 若count的个数是奇数，则直接将小顶堆中的堆顶元素转换为Double格式输出
 *
 */
public class GetMedian {
    private PriorityQueue<Integer> min = new PriorityQueue<>();
    private PriorityQueue<Integer> max = new PriorityQueue<Integer>(11, new Comparator<Integer>(){
        public int compare(Integer n1, Integer n2){
            return n2 - n1;
        }
    });
    private int count = 0;
    public void Insert(Integer num) {
        if(count%2 != 0){
            min.add(num);
            max.add(min.poll());
        }else{
            max.add(num);
            min.add(max.poll());
        }
        count++;
    }

    public Double GetMedian() {
        if(count%2 == 0)
            return new Double(max.peek()+min.peek()) / 2;
        else
            return new Double(min.peek());
    }
}
