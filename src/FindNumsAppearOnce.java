/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: FindNumsAppearOnce
 * 作者: zhanghe
 * 时间: 2016/12/11 15:01
 * 题目:数组中只出现一次的数字
 * 内容:一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 版本:
 * 运行时间：31ms 占用内存：503k
 * 备注:使用异或。n^n= 0, n^0 = n
 * 首先将所有数字异或一遍，得到两个出现一次的数字的异或res1
 * 因为两个数字不相等，所以两个数字二进制中一定至少有一位一个数字为0，一个数字为1
 * ~res1是res1取反，~res1+1则肯定~res1中有一位从0变为1，又因为~res1是res1的取反，所以这一位在res1中也为1
 * 所以k就代表这两个只出现一次的数中，从右至左，在两个数第一个不相同位置为1，其余位置为0的数
 * 让k与整个数组进行与操作，将所有结果为0的数进行异或。
 * 这时，就相当于把整个数组中的数分为两类，一类为该位置为0的数，一类为该位置为1的数
 * 两个出现一次的数一定分别在这两类中各一个。
 * 所以，将该位置为0的数全部进行异或，最后得到的数一定是两个数字其中那个该位置为0的数，res2
 * 然后再用res1与res2进行异或，剩下的就是另外一个只出现一次的数了。
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int res1 = 0; int res2 = 0;
        for(int i : array)
            res1 ^= i;
        int k = res1 & (~res1 + 1);
        for(int i : array){
            if((i&k) == 0)
                res2 ^= i;
        }
        num1[0] = res2;
        num2[0] = res2 ^ res1;
    }
}
