/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: GetNumberOfK
 * 作者: zhanghe
 * 时间: 2016/12/10 21:11
 * 题目:数字在排序数组中出现的次数
 * 内容:统计一个数字在排序数组中出现的次数。
 * 版本:2
 * 运行时间：31ms 占用内存：550k
 * 备注:运行通过了，主要问题是二分时的左右边界
 * 在getFirstK函数中，
 * 设置了k > 、<、=array[mid]三个条件分别判断边界，而不是原来的只有k > 、<=array[mid]两个条件
 * 在getLastK函数中，也同样增加了边界条件判断，当array[mid]=k是，接着判断mid+1是否=k，以此来决定下一轮二分边界
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if(array.length == 0 || k < array[0] || k > array[array.length-1]) return 0;
        int left = 0;
        int right = array.length-1;
        int fir = getFirstK(array, 0, array.length-1, k);
        if(fir == -1)
            return 0;
        int last = getLastK(array, fir, array.length-1, k);
        return last-fir+1;
    }
    public int getFirstK(int[] array, int left, int right, int k){
        while(left <= right){
            if(left == right){
                if(array[left] == k)
                    return left;
            }
            int mid = left + (right - left)/2;
            if(k > array[mid])
                left = mid + 1;
            else if(k < array[mid])
                right = mid - 1;
            else if(k == array[mid])
                right = mid;
        }
        return -1;
    }
    public int getLastK(int[] array, int left, int right, int k){
        while(left <= right){
            if(array[right] == k)
                return right;
            int mid = left + (right - left)/2;
            if(array[mid] > k)
                right = mid-1;
            else{
                if(array[mid+1] != k)
                    return mid;
                else
                    left = mid+1;
            }
        }
        return -1;
    }
}
