/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: LeftRotateString
 * 作者: zhanghe
 * 时间: 2016/12/11 18:10
 * 题目:左旋转字符串
 * 内容:对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 版本:
 * 运行时间：29ms 占用内存：629k
 * 备注:
 */
public class LeftRotateString {
    public String LeftRotateString(String str,int n) {
        if(str == null) return str;
        char[] str1 = str.toCharArray();
        if(n > str1.length) return str;
        rotate(str1, 0, n-1);
        rotate(str1, n, str1.length-1);
        rotate(str1, 0, str1.length-1);

        String str2 = String.valueOf(str1);
        return str2;
    }
    public void rotate(char[] a, int left, int right){
        while(left < right){
            swap(a, left, right);
            left++;
            right--;
        }
    }
    public void swap(char[] a, int i, int j){
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
