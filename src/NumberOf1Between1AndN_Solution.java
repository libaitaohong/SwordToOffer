/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: NumberOf1Between1AndN_Solution
 * 作者: zhanghe
 * 时间: 2016/12/9 9:45
 * 题目:正整数中1出现的次数
 * 内容:求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 1~13中包含1的数字有1、10、11、12、13因此共出现6次。
 * 把问题更加普遍化,可以很快的求出任意非负整数区间中1出现的次数。
 * 版本:
 * 运行时间：27ms 占用内存：629k
 * 备注:将一个数分割为两部分，前一部分为a，后半部分为b，a=n/i，b=n%i，从个位开始求出每一位含有1的个数
 * 例如 n = 12345，以求百位含有1的个数为例：a=n/100=123， b=n%100=45，共有三种情况
 * 当a的最后一位大于1时：
 *    a的个位为1的情况为a的前两位为0-12时共13次。这13次又各对应着100次百位为1的情况。所以，(a/10+1)*100
 * 当a的最后一位为1时：例如a=121
 *    这时在a的前两位为0-11时，共12次，对应百位共有100次1。在a前两位为12时，百位的1还没有到达一百次，
 *    它百位对应有b+1(包括b=0时)次1。所以，a/10*100 + b+1
 * 当a的最后一位是0的时候，例如a=120
 *    这时只有a前两位为0-11时，共12次百位为1,。因为a前两位为12时，没有到达一百的情况。所以，a/10*100
 * 对这三种情况进行归纳：
 *    当a的个位数>=2时，为a/10+1，当a的个位数为0时，为a/10。这里，可以用(a+8)%10来归纳这两种情况。
 *    因为，当a个位数>=2时，+8就能产生进位，/10就会在a/10的结果上+1，当a的个位数为0时，+8不影响结果
 *    当a的个位数为1时，也可以用(a+8)%10来计算，a的个位为1，加上8不影响a/10结果‘
 *    但是，当a%10==1时，需要再加上b+1次a，所以还需要判断a的个位是否为1，若为1，加上b+1，若不为1则不加
 */
public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count = 0;
        for(int i = 1; i <= n; i *= 10){
            int a = n/i, b = n%i;
            count += (a+8)/10*i + ((a%10 == 1) ? 1 : 0)*(b+1);
        }
        return count;
    }
}