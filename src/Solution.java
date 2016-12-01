/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Solution
 * 作者: zhanghe
 * 时间: 2016/12/1 20:59
 * 题目:
 * 内容:请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.
 * 则经过替换之后的字符串为We%20Are%20Happy。
 * 版本:
 * 运行时间:运行时间：34ms 占用内存：688k
 * 备注:使用StringBuffer替换完成，不再转换为char数组
 */
public class Solution {
    public String replaceSpace(StringBuffer str) {
        if(str == null)
            return null;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' '){
                str.replace(i, i+1, "%20");
            }
        }
        return str.toString();
    }
}

