package com.kodilla.multi.task03;

import java.time.LocalDate;
import java.util.Random;

public class WebClientMock {

    public String getResponse(int fileId, LocalDate localDate) throws InterruptedException {
        Random random = new Random();
        String response = "File " + fileId + "_" + localDate.toString() + ".doc";
        Thread.sleep(random.nextInt(200));
        return response;
    }

}
