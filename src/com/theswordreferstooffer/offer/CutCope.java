package com.theswordreferstooffer.offer;

public class CutCope {
    /**
     *      * 动态规划法：
     *      * 动态规划求解问题的四个特征： 
     *             ①求一个问题的最优解； 
     *             ②整体的问题的最优解是依赖于各个子问题的最优解； 
     *             ③小问题之间还有相互重叠的更小的子问题； 
     *             ④从上往下分析问题，从下往上求解问题；
     *      * 动态规划：
     *             有一段长度为n的绳子，我们现在要剪第一刀，我可以选择下第一刀的地方有1~n-1这些地方；比如长度为10的绳子，我第一刀可以在1~9这些地方下刀，共9种方式。
     *             第一刀下去后，绳子分成两部分，假设在i处下刀，绳子两部分就分别为：[0~i]与[i~n]，长度分为表示为i与n-i；那么找出第一刀最合适的位置，其实就是找i在哪下刀，可以使得[0~i]与[i~n]的乘积最大，函数表示为：f(n)=max(f(i)×f(n−i))f(n)=max(f(i)×f(n−i))。
     *             那么如何判断i处切最大呢？这个时候，我们就要知道，[0~i]这个长度的绳子，任意方式切，最大的乘积是多少；假如说，当我们要切一个长度为10的绳子：切成1和9与4和6，两种方式，哪个乘积更大？ 
     *             回答：不光要考虑第一刀后两个绳子的大小，还要考虑到9、4、6这三种情况，因为第一刀切出的绳子长度是否可以再切第二刀，使它有更大的乘积，比如将9再切成 3×3×33×3×3，6切成 4×24×2，哪个更大？
     *                                    这种情况下，我们可以发现，无论再怎么切，一定是越切越短，那么我们是否可以将小于给定长度的绳子的每一个长度的最大乘积都求出来？ 
     *             即：长度为10的绳子，我们就计算出：长度1~9这9种长度的绳子，每种长度的最大乘积是多少。 
     *               要求长度9的绳子的最大乘积，我们要知道1~8各个长度的最大乘积，要知道长度8的最大乘积，就要知道1~7长度的各个最大乘积，以此类推。
     *      * 
     *      * 动态规划版本
     *      * f(n)定义为将长度为n的绳子分成若干段后的各段长度的最大乘积（最优解），在剪第一刀时有n-1种剪法，可选择在0 < i < n处下刀
     *      * 在i处下刀，分成长度为i的左半绳子和长度为n-i的右半绳子，对于这两根绳子，定义最优解为f(i)和f(n-i)，于是f(n) = max(f(i) * f(n-i))，即求出各种相乘可能中的最大值就是f(n)的最优解
     *      * 就这样从上到下的分下去，但是问题的解决从下到上。即先求出f(2)、f(3)的最优解，然后根据这两个值求出f(4)、f(5)...直到f(n)
     *      * f(2) = 1，因为只能分成两半
     *      * f(3) = 2，因为分成两段2*1 大于分成三段的1*1*1
     *      * ...
     *      
     */
    public int cutRope(int target) {
        if(target == 1){
            //长度为1的绳子 无法被分割，返回0
            return 0;
        }
        if(target == 2){
            //长度为2的绳子 只能被分割为1+1，返回1
            return 1;
        }
        if(target == 3){
            //长度为3的绳子 只能被分割为1 + 2 或者 2 + 1 结果相同，可见当分割超过绳子的一半时
            //分割结果就一样了。例如 长度为10  则分为4 + 6 和 6 + 4是一样的。所以 6 + 4按照 4 + 6处理
            return 2;
        }
        //保存子问题最优解的数组。
        int result[] = new int[target + 1];
        //前三项保存的是绳子的长度。而非最优解。
        result[1] = 1;
        result[2] = 2;
        result[3] = 3;
        for(int i=4;i <= target;i ++){
            int max = 0;
            //当分割超过绳子的一半时按照前一部分处理
            //将所有的最优解进行遍历。找出当前长度的最优解。
            for(int j=1;j <= i/2; j++){
                int r = result[j] * result[i - j];
                if(r > max){
                    max = r;
                }
            }
            result[i] = max;
        }
        return result[target];
    }

    /**
     * 贪心解法。
     * 贪心算法结题，动手演算前几个值的结果，总结规律，不难发现，分割的每一段绳子长度都是3及3的余数，结果是最大的。
     * 贪心规则：
     *  最高优先级 3：把绳子尽可能切为多个长度为3的片段。留下的绳子可能有0,1,2三种情况
     *  中等优先级 2: 若最后一段绳子的长度为2，则保留，不再拆分为1 + 1
     *  最低优先级 1: 若最后一段绳子的长度为1, 则把最后的3 + 1替换为2 + 2,因为2 * 2 > 3 * 1
     *
     * @param target
     * @return
     */
    public int cutRope1(int target){
        if(target <= 3){
            return target -1;
        }
        int a = target / 3;
        int b = target % 3;
        if(b == 0){
            return (int)Math.pow(3,a);
        }
        else if(b == 1){
            return (int)Math.pow(3,a-1) * 4;
        }
        else{
            return (int)Math.pow(3,a) * 2;
        }
    }
}
