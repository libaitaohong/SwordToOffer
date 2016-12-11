/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: ReverseSentence
 * 作者: zhanghe
 * 时间: 2016/12/11 19:28
 * 题目:翻转单词顺序列
 * 内容:例如，“student. a am I”。把句子单词的顺序翻转，正确的句子应该是“I am a student.”。
 * 版本:
 * 运行时间：40ms 占用内存：654k
 * 备注:要注意当遍历到最后时，最后一个单词没有空格，也要将最后一个单词翻转
 */
public class ReverseSentence {
    public String ReverseSentence(String str) {
        if(str == null) return str;
        char[] str1 = str.toCharArray();
        int flag = 0;
        for(int i = 0; i < str1.length; i++){
            if(str1[i]==' '){
                rolate(str1, flag, i-1);
                flag = i+1;
            }else if(i == str1.length-1)
                rolate(str1, flag, i);
        }
        rolate(str1, 0, str1.length-1);
        String str2 = String.valueOf(str1);
        return str2;
    }
    public void rolate(char[] a, int left, int right){
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
