package com.genericlearn.demo08;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * 加深对下限通配符的理解
 */
public class Test08 {
    public static void main(String[] args) {
        TreeSet<Teacher> teachers = new TreeSet<>(new Comparator2());
        teachers.add(new Teacher("echo",33));
        teachers.add(new Teacher("soul",34));
        teachers.add(new Teacher("jim",29));
        teachers.add(new Teacher("caine",27));
        for (Teacher teacher : teachers){
            System.out.println(teacher);
        }
        System.out.println("----------------------------------------");
        //TreeSet中使用的构造器是一个Comparator的下限类型通配符,所以是可以传递Teacher的父类类型的Comparator
        TreeSet<Teacher> teachersx = new TreeSet<>(new Comparator1());
        teachersx.add(new Teacher("echo",33));
        teachersx.add(new Teacher("soul",34));
        teachersx.add(new Teacher("jim",29));
        teachersx.add(new Teacher("caine",27));
        for (Teacher teacher : teachersx){
            System.out.println(teacher);
        }
        System.out.println("---------------------------------------");
        //尝试传入Comparator3,该比较器是Professor类型的
        //TreeSet<Teacher> teachersq = new TreeSet<>(new Comparator3());报错
    }

}

class Comparator1 implements Comparator<People>{

    @Override
    public int compare(People o1, People o2) {
        return o1.name.compareTo(o2.name);
    }
}

class Comparator2 implements Comparator<Teacher>{
    @Override
    public int compare(Teacher o1, Teacher o2) {
        return o1.age - o2.age;
    }
}

class Comparator3 implements Comparator<Professor>{
    @Override
    public int compare(Professor o1, Professor o2) {
        return o1.level - o2.level;
    }
}