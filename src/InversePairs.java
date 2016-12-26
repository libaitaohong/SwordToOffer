/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: InversePairs
 * 作者: zhanghe
 * 时间: 2016/12/26 10:23
 * 题目:数组中的逆序对
 * 内容:在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 版本:1
 * 运行时间:运行时间：353ms 占用内存：4730k
 * 备注:
 */
public class InversePairs {
    private long count;
    public int InversePairs(int [] array) {
        if(array.length <= 1) return 0;
        int[] copy = new int[array.length];
        divide(array, copy, 0, array.length-1);

        return (int)(count%1000000007);
    }
    public void divide(int[] array, int[] copy, int s, int e){
        if(s >= e) return;
        int mid= (e+s)/2;
        divide(array, copy, s, mid);
        divide(array, copy, mid+1, e);
        merge(array, copy, s, e, mid);
    }
    public void merge(int[] array, int[] copy, int s, int e, int mid){
        int i = s;
        int j = mid+1;
        int k = s;
        while(i <= mid && j <= e){
            if(array[i] <= array[j])
                copy[k++] = array[i++];
            else{
                count += (mid-i+1)%1000000007;
                copy[k++] = array[j++];
            }
        }
        while(i <= mid){
            copy[k++] = array[i++];
        }
        while(j <= e){
            copy[k++] = array[j++];
        }
        for(int n = e-s+1; n > 0; n--, e--){
            array[e] = copy[e];
        }
    }
}
