package com.ht.test.collection;

import java.util.*;

public class Test01 {
    public static void main(String[] args) {

        Vector<Result> v = new Vector<>();
        Result r1 = new Result("a","1");
        Result r2 = new Result("c","2");
        Result r3 = new Result("b","3");
        v.add(r1);
        v.add(r2);
        v.add(r3);

        Collections.sort(v, new Comparator<Result>() {
            @Override
            public int compare(Result o1, Result o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        for(Result r :v){
            System.out.println(r);
        }

    }
}
class Result{
    String name;
    String start;

    public Result(String name, String start) {
        this.name = name;
        this.start = start;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    @Override
    public String toString() {
        return "Result{" +
                "name='" + name + '\'' +
                ", start='" + start + '\'' +
                '}';
    }
}
