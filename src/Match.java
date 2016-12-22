/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Match
 * 作者: zhanghe
 * 时间: 2016/12/22 19:26
 * 题目:正则表达式匹配
 * 内容:请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 * 版本:
 * 运行时间：33ms 占用内存：528k
 * 备注:使用两个指针来维护两个数组遍历到哪里了
 */
public class Match {
    public boolean match(char[] str, char[] pattern){
        if(str == null || pattern == null) return false;
        int istr = 0;
        int ipattern = 0;
        return matchCore(str, 0, pattern, 0);
    }
    public boolean matchCore(char[] str, int istr, char[] pattern, int ipattern){
        //如果str与pattern同时到最后一位，返回true
        if(istr == str.length && ipattern == pattern.length) return true;
        //如果pattern到达结尾而str没到结尾，返回false
        if(istr != str.length && ipattern == pattern.length) return false;
        //如果pattern的当前位置的下一位是*
        if(ipattern+1 < pattern.length && pattern[ipattern+1] == '*'){
            //两个数组当前位置相等或者pattern为'.'时，有3种情况：
            if((istr < str.length && str[istr] == pattern[ipattern]) || (istr != str.length && pattern[ipattern] == '.')){
                return matchCore(str, istr+1, pattern, ipattern+2)     // 重复1次
                        || matchCore(str, istr, pattern, ipattern+2)   // 重复0次
                        || matchCore(str, istr+1, pattern, ipattern);  // 重复n次
            }else
            //在*前这一位不相等的情况下，只有一种情况就是重复0次
                return matchCore(str, istr, pattern, ipattern+2);
        }
        //若下一位不是*，则需要当前位相等，若相等两个数组指针下移一位
        if((istr != str.length && str[istr] == pattern[ipattern]) || (istr != str.length && pattern[ipattern] == '.')){
            return matchCore(str, istr+1, pattern, ipattern+1);
        }
        return false;
    }
}
