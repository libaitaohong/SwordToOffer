/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: SwapOddEven
 * 作者: zhanghe
 * 时间: 2016/12/3 20:54
 * 题目:调整数组顺序使奇数位于偶数前面
 * 内容:输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变
 * 版本:
 * 运行时间：34ms 占用内存：629k
 * 备注:
 */
public class SwapOddEven {
    public void reOrderArray(int [] array) {
        if(array.length == 0) return;
        int j = 0;
        int[] arr = new int[array.length];
        for(int i = 0; i < array.length; i++){
            if(array[i]%2 == 1){
                arr[j++] = array[i];
            }
        }
        for(int i = 0; i < array.length; i++){
            if(array[i]%2 == 0){
                arr[j++] = array[i];
            }
        }
        for(int i = 0; i < arr.length; i++){
            array[i] = arr[i];
        }
    }
}
