package com.base.basics.knowledge;

import java.util.HashSet;
import java.util.Objects;

public class EqualsExample {
    private int x;
    private int y;
    private int z;
    public EqualsExample(int x,int y,int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EqualsExample that = (EqualsExample) o;
        return x == that.x && y == that.y && z == that.z;
    }

    public static void main(String[] args) {
        //只重写equals不重写hashcode的后果
        HashSet<EqualsExample> hashSet = new HashSet<>();
        EqualsExample e1 = new EqualsExample(1,1,1);
        EqualsExample e2 = new EqualsExample(1, 1, 1);
        System.out.println(e1.equals(e2));      //e1和e2相同，但是都添加到了集合中
        hashSet.add(e1);
        hashSet.add(e2);
        System.out.println(hashSet.size());
    }
    //加上hashCode()
    @Override
    public int hashCode() {
        /**
         * 理想的散列函数应当具有均匀性，即不相等的对象应当均匀分布到所有可能的散列值上。
         * 这就要求了散列函数要把所有域的值都考虑进来，可以将每个域都当成 R 进制的某一位，
         * 然后组成一个 R 进制的整数。R 一般取 31，因为它是一个奇素数，如果是偶数的话，
         * 当出现乘法溢出，信息就会丢失，因为与 2 相乘相当于向左移一位
         * 一个数与 31 相乘可以转换成移位和减法: 31*x == (x<<5)-x，编译器会自动进行这个优化
         */
        int result = 17;
        result = 31 * result + x;
        result = 31 * result + y;
        result = 31 * result + z;
        return result;
    }
}
