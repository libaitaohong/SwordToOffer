import java.util.ArrayList;
import java.util.Collections;

/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Permutation
 * 作者: zhanghe
 * 时间: 2016/12/8 15:04
 * 题目:字符串的排列
 * 内容:输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 版本:
 * 运行时间：148ms 占用内存：1535k
 * 备注:就是采用递归，字符两两交换
 */
public class Permutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if(str == null) return res;
        char[] word = str.toCharArray();
        dic(word, 0, res);
        Collections.sort(res); //排成字典序
        return res;
    }
    public void dic(char[] word, int i, ArrayList res){
        if(i == word.length-1)
            res.add(String.valueOf(word));
        else{
            //for循环过程中，最开始i==j，这时第一个不动，后面的进行交换得到所有的顺序
            //随着i的增大，前面不动的越来越多，后面交换的越来越少，最后剩一个的时候，就是一种顺序
            //使用这种前面一个不动，后面所有排序的思想把大问题简化为小问题，使用递归来求解。
            for(int j = i; j < word.length; j++){
                if(j == i || word[i] != word[j]){ //同样字符不交换
                    swap(word,i,j);//交换
                    dic(word, i+1, res);
                    swap(word, i, j);//复位
                }
            }
        }
    }
    public void swap(char[] word, int i, int j){
        char temp = word[j];
        word[j] = word[i];
        word[i] = temp;
    }
}
