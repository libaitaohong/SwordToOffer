/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: FindFirstNum
 * 作者: zhanghe
 * 时间: 2016/12/22 20:49
 * 题目:字符流中第一个不重复的字符
 * 内容:请实现一个函数用来找出字符流中第一个只出现一次的字符。
 * 例如，当从字符流中只读出前两个字符"go"时，第一个只出现一次的字符是"g"。
 * 当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 输出描述: 如果当前字符流没有存在出现一次的字符，返回#字符。
 * 版本:
 * 运行时间：39ms 占用内存：528k
 * 备注:一位int最多有256种字符，设置一个长度为256的num数组
 * 插入字符时，若当前位为0，则赋值index++，否则设为-1
 * 在查找时，找到数组中值大于0，最小的整数，这个整数的下标就是第一次出现一个的字符
 */
public class FindFirstNum {
    int[] num = new int[256];
    int index = 1;
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(num[ch] == 0)
            num[ch] = index++;
        else
            num[ch] = -1;
    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        int min = Integer.MAX_VALUE;
        char ch = '#';
        for(int i = 0; i < num.length; i++){
            if(num[i] < min && num[i] > 0){
                min = num[i];
                ch = (char)i; //注意细节，之前写错成了ch = (char)min
            }
        }
        return ch;
    }
}
