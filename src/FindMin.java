/**
 * Created by zhanghe on 2016/12/2.
 * 旋转数组的最小数字
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 运行时间：163ms 占用内存：4134k
 * 注意：非递减数组，当左右中值相等时，只能遍历查找
 */
public class FindMin {
    public int minNumberInRotateArray(int [] array) {
        if(array.length <=0) return 0;
        int left = 0;
        int right = array.length-1;
        if(array[left] < array[right])
            return left;
        int res = 0;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(array[mid] < array[left]){
                right = mid-1;
                res = mid;
            }else if(array[mid] > array[right]){
                left = mid+1;
            }else{
                int res1 = res;
                while(left <= right){
                    if(array[left] < array[res1]){
                        res1 = left;
                    }
                    left++;
                }
                return array[res1];
            }
        }
        return array[res];
    }
}
