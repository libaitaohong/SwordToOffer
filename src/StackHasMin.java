import java.util.Stack;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: StackHasMin
 * 作者: zhanghe
 * 时间: 2016/12/7 14:18
 * 题目:包含min函数的栈
 * 内容:定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 版本:
 * 运行时间：30ms 占用内存：688k
 * 备注:
 */
public class StackHasMin {
    Stack<Integer> data = new Stack<>();
    Stack<Integer> min = new Stack<>();
    public void push(int node) {
        data.push(node);
        if(min.empty())
            min.push(node);
        else if(node < min.peek())
            min.push(node);
        else
            min.push(min.peek());

    }
    public void pop() {
        data.pop();
        min.pop();
    }
    public int top() {
        return data.peek();
    }
    public int min() {
        return min.peek();
    }
}
