import java.util.ArrayList;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: GetLeastNumbers_Solution
 * 作者: zhanghe
 * 时间: 2016/12/8 17:07
 * 题目:最小的k个数
 * 内容:输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 版本:2
 * 运行时间：运行时间：35ms 占用内存：629k
 * 备注:注意边界条件。k是不是大于0，还有数组的长度是不是大于k的长度。若大于返回空。
 * 简单修改了一下，去掉判断input大小=k的情况，取消数组arr，直接在input数组的前k项进行变换
 */
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input.length < k || k <=0)
            return res;
        //构造大顶堆,构造完之后数组第一个值为最大值
        for(int j = k; j < input.length; j++){
            for(int i = k/2-1; i >= 0; i--){
                transform(input, i, k-1);
            }
            if(input[0] > input[j])
                input[0] = input[j];
        }
        for(int n = 0; n < k; n++)
            res.add(input[n]);
        return res;
    }
    public void transform(int[] a, int i, int n){
        while(2*i+1 <= n){
            int j = 2*i+1;
            if(j < n && a[j] < a[j+1])
                j++;
            if(a[i] > a[j])
                break;
            swap(a,i,j);
            i = j;
        }
    }
    public void swap(int[] a, int i, int j){
        int temp = a[j];
        a[j] = a[i];
        a[i] = temp;
    }
}
