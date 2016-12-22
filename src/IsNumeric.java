/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: IsNumeric
 * 作者: zhanghe
 * 时间: 2016/12/22 20:07
 * 题目:表示数值的字符串
 * 内容:请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 版本:
 * 运行时间：28ms 占用内存：503k
 * 备注:首先考察第一位是不是"+""-"，若是坐标后移一位
 * 供需考察4个条件，彼此关系时if-else关系！！！
 * 1. 当出现e/E时，是不是第一次出现，e是不是最后一个字符
 * 2. 当出现“.”时，是不是第一次出现，是不是出现在e后面
 * 3. 当出现"+""-"时，是不是出现在e后面
 * 4. 是不是合法有效的数字
 */
public class IsNumeric {
    public boolean isNumeric(char[] str) {
        if(str == null) return false;
        boolean e = false;
        boolean node = false;
        int index = 0;
        if(str[0] == '+' || str[0] == '-')
            index = 1;
        for(int i = index; i < str.length; i++){
            if(str[i] == 'e' || str[i] == 'E'){
                if(i == str.length-1) return false;
                if(!e)
                    e = true;
                else
                    return false;
            }else if(str[i] == '.'){
                if(e || node)
                    return false;
                else
                    node = true;
            }else if(str[i] == '+' || str[i] == '-'){
                if(str[i-1] != 'e' && str[i-1] != 'E')
                    return false;
            }else if(str[i] < '0' || str[i] > '9') return false;
        }
        return true;
    }
}
