package com.thinkInJava.chapter20;
@DBTable(name = "MEMBER")
public class Member {
    @SQLString(30)  //如果注解中元素是唯一一个需要赋值的元素，则无需使用键值对的方式
    String firstName;
    @SQLString(50)
    String lastName;
    @SQLInteger
    Integer age;
    @SQLString(value = 30,constraints = @Constraints(primaryKey = true))
    String handle;
    static int memberCount;

    @Override
    public String toString() {
        return this.handle;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getHandle() {
        return handle;
    }
}
