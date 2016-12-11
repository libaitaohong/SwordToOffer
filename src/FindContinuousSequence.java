import java.util.ArrayList;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: FindContinuousSequence
 * 作者: zhanghe
 * 时间: 2016/12/11 16:57
 * 题目:和为S的连续正数序列
 * 内容:输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 版本:
 * 运行时间：32ms 占用内存：636k
 * 备注:在判断当前和是否大于sum时，使用while而不是if，这是因为即使删除最小项，和仍然有可能大于sum
 * 但是在判断count < sum时不可以使用while。。。
 * 注意判断>、=、>三个条件是独立的
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> list1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list2 = new ArrayList<>();
        if(sum == 0 || sum == 1) return list1;
        int count = 0;
        for(int i = 1; i <= sum/2+1; i++){
            if(count < sum){
                list2.add(i);
                count += i;
            }
            while(count > sum){
                count -= list2.remove(0);
            }
            if(count == sum){
                list1.add(new ArrayList<Integer>(list2));
                count -= list2.remove(0);
            }
        }
        return list1;
    }
}
