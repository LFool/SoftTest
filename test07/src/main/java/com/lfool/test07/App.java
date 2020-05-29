package com.lfool.test07;

/**
 * @Description:
 * @Author: LFool
 * @Time: 2020/5/30 0:40
 */
public class App {
    public String getGreeting() {
        return "Hello world.";
    }

    public static void main(String[] args) {
        System.out.println(new App().getGreeting());
    }
}

