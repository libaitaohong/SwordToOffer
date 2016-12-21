/**
 * 工程: SwordToOffer 包名: PACKAGE_NAME 类名: Multiply
 * 作者: zhanghe
 * 时间: 2016/12/21 20:52
 * 题目:构建乘积数组
 * 内容:给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 * 版本:
 * 运行时间：31ms占用内存：503k
 * 备注:
 */
public class Multiply {
    public int[] multiply(int[] A) {
        if(A.length <= 0) return A;
        int[] B = new int[A.length];
        int[] C = new int[A.length];
        int[] D = new int[A.length];
        C[0] = 1;
        D[A.length-1] = 1;
        for(int i = 1; i < A.length; i++){
            C[i] = C[i-1] * A[i-1];
            D[A.length-1-i] = D[A.length-i] * A[A.length-i];
        }
        for(int i = 0; i < A.length; i++)
            B[i] = C[i]*D[i];
        return B;
    }
}
