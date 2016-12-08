import java.util.ArrayList;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: GetLeastNumbers_Solution
 * 作者: zhanghe
 * 时间: 2016/12/8 17:07
 * 题目:最小的k个数
 * 内容:输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 版本:
 * 运行时间：36ms 占用内存：629k
 * 备注:注意边界条件。k是不是大于0，还有数组的长度是不是大于k的长度。若大于返回空。
 */
public class GetLeastNumbers_Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input.length < k || k <=0)
            return res;
        else if(input.length == k){
            for(int n : input)
                res.add(n);
            return res;
        }
        int[] arr = new int[k];
        for(int i = 0; i < k; i++)
            arr[i] = input[i];

        //构造大顶堆,构造完之后数组第一个值为最大值
        for(int j = k; j < input.length; j++){
            for(int i = arr.length/2-1; i >= 0; i--){
                transform(arr, i, arr.length-1);
            }
            if(arr[0] > input[j])
                arr[0] = input[j];
        }

        for(int n : arr)
            res.add(n);

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
