package com.qiye;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 保留几位小数
 */
public class NumbersFormatTest {
    double f = 1123.75648;
    public void f1(){
        BigDecimal bg = new BigDecimal(f);
        double f1 = bg.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(f1);
    }
    public void f2(){
        DecimalFormat df = new DecimalFormat("#.00");
        System.out.println(df.format(f));
    }
    public void f3(){
        System.out.println(String.format("%.2f",f));
    }
    public void f4(){
        NumberFormat nf  = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(2);
        System.out.println(nf.format(f));
    }

    public static void main(String[] args) {
        NumbersFormatTest nft = new NumbersFormatTest();
        nft.f1();
        nft.f2();
        nft.f3();
        nft.f4();
    }
}
