package com.thinkInJava.chapter20;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TableCreator {
    public static void main(String[] args) throws Exception {
        if(args.length < 1){
            System.out.println("arguments: annotated class");
            System.exit(0);;
        }
        for(String className : args){
            // 根据类名获取类对象
            Class<?> cl = Class.forName(className);
            // 根据类对象获取注解
            DBTable dbTable = cl.getAnnotation(DBTable.class);
            System.out.println(dbTable);
            if(dbTable == null){
                System.out.println("No DBTable in class " + className);
                continue;
            }
            String tableName = dbTable.name();
            if(tableName.length() < 1){
                //如果注解中的表名是空的。那就使用类名来创建表名
                tableName = cl.getName().toUpperCase();
            }
            System.out.println(tableName);
            //获取类中定义的字段，作为表的字段
            List<String> columns = new ArrayList<String>();
            //System.out.println(cl.getFields().length);
            for(Field field : cl.getDeclaredFields()){
                //field.setAccessible(true);
                String colName = null;
                //获取该成员变量上的注解
                Annotation[] anns = field.getDeclaredAnnotations();
                //System.out.println(anns[0]);
                if(anns.length < 1){
                    // 这不是一个定义的数据库字段
                    continue;
                }
                if(anns[0] instanceof SQLInteger){
                    //是一个整形
                    SQLInteger sqlInteger = (SQLInteger)anns[0];
                    if(sqlInteger.name().length() < 1){
                        // 没有指定数据库字段的名字
                        colName = field.getName().toUpperCase();
                    }
                    else{
                        colName = sqlInteger.name();
                    }
                    columns.add(colName + " INT" + getContraints(sqlInteger.constraints()));
                }
                if(anns[0] instanceof SQLString){
                    // 是一个字符串类型
                    SQLString sqlString = (SQLString) anns[0];
                    if(sqlString.name().length() < 1){
                        // 如果没有明确定义该成员变量在数据库中对应的列的名字
                        colName = field.getName().toUpperCase();
                    }
                    else{
                        colName = sqlString.name();
                    }
                    columns.add(colName + " VARCHAR(" + sqlString.name() + ")" + getContraints(sqlString.constraints()));
                }
                StringBuilder createCommand = new StringBuilder("CREATE TABLE " + tableName + ")");
                for (String col : columns){
                    createCommand.append("\n    " + col + ",");
                }
                System.out.println(createCommand);
                String tableCreate = createCommand.substring(0,createCommand.length() - 1) + ");";
                System.out.println("Table Create SQL for " + className + "is: \n" + tableCreate);
            }
        }
    }
    private static String getContraints(Constraints con){
        String constraints = "";
        if(!con.allowNull()){
            constraints += " NOT NULL ";
        }
        if(con.primaryKey()){
            constraints += " PRIMARY KEY ";
        }
        if(con.unique()){
            constraints += " UNIQUE ";
        }
        return constraints;
    }
}
