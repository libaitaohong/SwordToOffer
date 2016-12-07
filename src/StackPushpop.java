import java.util.Stack;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: StackPushpop
 * 作者: zhanghe
 * 时间: 2016/12/7 15:03
 * 题目:
 * 内容:输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是
 * 该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 * 版本:
 * 运行时间：37ms 占用内存：654k
 * 备注:外面大循环循环入栈数组，里面循环出栈数组。关键在于判断stack.peek() == popA[j]
 * 注意判断栈是否为空。
 * 流程就是入栈，直到当前栈顶与当前出栈数组位置的数值相同，出栈，出栈数组位置向后。
 * 循环该操作，直到栈为空，或者栈顶元素与出栈元素不相等。
 * 最后若栈为空，则说明对，否则返回false
 */
public class StackPushpop {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length != popA.length) return false;
        Stack<Integer> stack = new Stack<>();
        for(int i = 0, j = 0; i < pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.empty() && stack.peek() == popA[j]){
                stack.pop();
                j++;
            }
        }
        return stack.empty();
    }
}
