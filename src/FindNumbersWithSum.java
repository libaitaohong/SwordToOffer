import java.util.ArrayList;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: FindNumbersWithSum
 * 作者: zhanghe
 * 时间: 2016/12/11 17:26
 * 题目:和为S的两个数字
 * 内容:输入一个递增排序的数组和一个数字S，在数组中查找两个数，是的他们的和正好是S，如果有多对数字的和等于S，
 * 输出两个数的乘积最小的。对应每个测试案例，输出两个数，小的先输出。
 * 版本:
 * 运行时间：31ms 占用内存：629k
 * 备注:
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if(array.length <= 1) return list;
        int c = 0;
        int left = 0;
        int right = array.length-1;
        while(left < right){
            if(array[left]+array[right] < sum)
                left++;
            if(array[left]+array[right] > sum)
                right--;
            if(array[left]+array[right] == sum){
                if(c == 0 || array[left]*array[right] < c){
                    list.clear();
                    list.add(array[left]);
                    list.add(array[right]);
                    c = array[left]*array[right];
                }
                left++;
            }
        }
        return list;
    }
}
