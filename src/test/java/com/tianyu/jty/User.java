package com.tianyu.jty;

public class User {
    private String name;

    public User(String name) {
        super();
        this.name = name;
    }


    public static void main(String[] args) {
        try {
            Class demo1 = Class.forName("com.tianyu.jty.User");
            System.out.println(demo1.newInstance());
        }
        catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
