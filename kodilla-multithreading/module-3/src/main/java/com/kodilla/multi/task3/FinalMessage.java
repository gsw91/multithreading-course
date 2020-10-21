package com.kodilla.multi.task3;

public final class FinalMessage implements Runnable {

    private final ResultList resultList;

    public FinalMessage(ResultList resultList) {
        this.resultList = resultList;
    }

    @Override
    public void run() {
        System.out.println("Tasks completed, barrier ready!");
        resultList.showResults();
    }

}
