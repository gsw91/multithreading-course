package com.kodilla.multi.task1;

public class Application {

    public static void main(String[] args) {
        Configuration config = new Configuration();
        config.changeDefaultArrayLength(10);
        config.setThreadsQuantity(4);
        config.setMultiplier(4);
        config.run();
    }

}
