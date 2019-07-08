package com.ht.test.reflect;

import java.lang.reflect.*;
import java.util.Scanner;

public class ReflectDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.println("Enter class name:");
        String name = s.next();
        try {
            Class c = Class.forName(name);
            Class superclass = c.getSuperclass();
            //获取类的访问修饰符
            String modifier = Modifier.toString(c.getModifiers());
            if(modifier.length()>0)
            System.out.print(modifier);
            //本类名
            System.out.print(" class "+name);
            //获取父类
            if(superclass!=null&&superclass!=Object.class){
                System.out.print(" extends "+superclass.getName());
            }
            System.out.print("\n{\n");

            //打印属性
            System.out.println("属性");
            printField(c);
            System.out.print("\n\n");
            //打印构造方法
            System.out.println("构造方法");
            printConstructors(c);
            System.out.print("\n\n");
            //打印实例方法
            System.out.println("实例方法");
            printMethods(c);
            System.out.println();
            System.out.print("}");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void printMethods(Class c){
        Method[] methods = c.getDeclaredMethods();
        for(Method method : methods){
            System.out.print("\t");
            String modifiers = Modifier.toString(method.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers);
            //返回值
            System.out.print(" "+method.getReturnType().getName());
            System.out.print(" "+method.getName()+"(");
            Class[] parameters = method.getParameterTypes();
            for(int i=0;i<parameters.length;i++){
                if(i>0) System.out.print(", ");
                System.out.print(parameters[i].getName());
            }
            System.out.print(");");
            System.out.print("\n");


        }

    }

    private static void printConstructors(Class c){
        Constructor[] constructors = c.getDeclaredConstructors();
        for(int i=0;i<constructors.length;i++){
            System.out.print("\t");
            String modifiers = Modifier.toString(constructors[i].getModifiers());
            //打印修饰符
            if(modifiers.length()>0) System.out.print(modifiers);
            //打印构造方法名字
            System.out.print(" "+constructors[i].getName()+"(");
            //获取参数
            Class[] parameters = constructors[i].getParameterTypes();
            for(int j=0;j<parameters.length;j++){
                if(j>0) System.out.print(", ");
                System.out.print(parameters[j].getName());
            }
            System.out.print(");");
            System.out.println();

        }
    }

    private static void printField(Class c){
        Field[] fields = c.getFields();
        for(Field field:fields){
            System.out.print("\t");
            String modifiers = Modifier.toString(field.getModifiers());
            if(modifiers.length()>0) System.out.print(modifiers);
            Class type = field.getType();
            System.out.print(" "+type);
            System.out.print(" "+field.getName()+";");
            System.out.print("\n");

        }

    }

}
