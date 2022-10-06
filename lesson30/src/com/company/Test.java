package com.company;

public class Test extends Thread {
    @Override
    public void run() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("java");

    }
    /// переопред метод alt/ins overraide- run
}
