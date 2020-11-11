package com.k.java基础;

/**
 * clone的用法，浅克隆和深克隆
 * Created by k on 2020/5/14.
 */
public class Clonenable implements Cloneable {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 方法可以覆盖也可以不覆盖
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        //使用this会导致无限递归调用
        Object clone = super.clone();
        Clonenable c = (Clonenable)clone;
        c.setAge(1);
        return c;
    }

    @Override
    public String toString() {
        return "Clonenable{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Clonenable clonenable = new Clonenable();
        Object clone = clonenable.clone();
        System.out.println(clone);
        System.out.println(clonenable);
    }
}
