package com.proxyStudy.staticProxy;
/**
 * 代理类持有具体类的实例，代为执行具体类实例方法。
 * 代理模式就是在访问实际对象时引入一定程度的间接性，
 * 因为这种间接性，可以附加多种用途。这里的间接性就是指不直接调用实际对象的方法，
 * 那么我们在代理过程中就可以加上一些其他用途。就这个例子来说，
 * 加入班长在帮张三上交班费之前想要先反映一下张三最近学习有很大进步，通过代理模式很轻松就能办到：
 */
public class StudentsProxy implements Person {
    //被代理的学生
    Student stu;
    public StudentsProxy(Person stu){
        //如果传入的Person是一个Student 那么将stu成员变量赋值为传入的stu
        if(stu.getClass() == Student.class){
            this.stu = (Student) stu;
        }
    }


    @Override
    public void giveMoney() {
        System.out.println(stu.getName() + "学习进步");
        stu.giveMoney();
    }
}
