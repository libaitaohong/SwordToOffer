import java.util.Stack;

/**
 * Created by zhanghe on 2016/12/2.
 * 用两个栈实现队列
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 运行时间：32ms  占用内存：528k
 */
public class TwoStacksSimuQueen {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if(!stack2.empty())
            return stack2.pop();
        else
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        return stack2.pop();

    }
}
