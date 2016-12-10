/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: GetNumberOfK
 * 作者: zhanghe
 * 时间: 2016/12/10 21:11
 * 题目:数字在排序数组中出现的次数
 * 内容:统计一个数字在排序数组中出现的次数。
 * 版本:1
 * 运行时间:
 * 备注:牛客运行超时，用IDEA跑了几个测试用例，应该是对的
 */
public class GetNumberOfK {
    public int GetNumberOfK(int [] array , int k) {
        if(k < array[0] || k > array[array.length-1]) return 0;
        int left = 0;
        int right = array.length-1;
        int sit = getNum(array, 0, array.length-1, k);
        if(sit == -1)
            return 0;
        int count = 0;
        for(int i = sit; i < array.length; i++){
            if(array[i] != k)
                break;
            count++;
        }
        return count;
    }
    public int getNum(int[] array, int left, int right, int k){
        while(left <= right){
            if(left == right){
                if(array[left] == k)
                    return left;
            }
            int mid = left + (right - left)/2;
            if(k > array[mid])
                left = mid + 1;
            else if(k <= array[mid])
                right = mid;
        }
        return -1;
    }
}
