/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: StrToInt
 * 作者: zhanghe
 * 时间: 2016/12/20 21:08
 * 题目:把字符串转换成整数
 * 内容:将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * 版本:
 * 运行时间：32ms 占用内存：528k
 * 备注:
 */
public class StrToInt {
    public int StrToInt(String str) {
        if(str == "" || str.length() == 0) return 0;
        char[] str1 = str.toCharArray();
        int sum = 0;
        int sign = 1;
        int s = 0;
        if(str1[0] == '-' || str1[0] == '+'){
            sign = str1[0] == '+' ? 1 : 0;
            s = 1;
        }
        for(int i = s; i < str1.length; i++){
            if(str1[i] < '0' || str1[i] > '9')
                return 0;
            sum = sum*10 + str1[i] - '0';
        }
        return sum = sign == 1 ? sum : (-1)*sum;
    }
}
