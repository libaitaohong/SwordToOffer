import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: PrintMinNumber
 * 作者: zhanghe
 * 时间: 2016/12/9 11:05
 * 题目:把数组排成最小的数
 * 内容:输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 版本:
 * 运行时间：39ms 占用内存：699k
 * 备注:本质上就是讲两个数str1+str2与str2+str1比较，谁小要谁
 *重新定义了compare函数，让他按照我们需要的结果来记性比较。
 */
public class PrintMinNumber {
    public String PrintMinNumber(int [] numbers) {
        if(numbers.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        for(int n : numbers)
            list.add(n);
        Collections.sort(list, new Comparator<Integer>(){
            public int compare(Integer str1, Integer str2){
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });
        for(int n : list)
            sb.append(n);
        return sb.toString();

    }
}
