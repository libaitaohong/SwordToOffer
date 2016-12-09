/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: FirstNotRepeatingChar
 * 作者: zhanghe
 * 时间: 2016/12/9 16:46
 * 题目:第一个出现一次的字符
 * 内容:在一个字符串(1<=字符串长度<=10000，全部由大写字母组成)中找到第一个只出现一次的字符,并返回它的位置
 * 版本:
 * 运行时间：33ms 占用内存：692k
 * 备注:虽然说只有大写字母组成，但是实际测试用例有小写字母
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        if(str.equals("")) return -1;
        int[] arr = new int['z'+1];
        char[] c = str.toCharArray();
        for(char n : c)
            arr[n]++;
        for(int i = 0; i < c.length; i++){
            if(arr[c[i]] == 1)
                return i;
        }
        return -1;
    }
}
