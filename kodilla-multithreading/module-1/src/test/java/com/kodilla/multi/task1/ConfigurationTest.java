package com.kodilla.multi.task1;

import com.kodilla.multi.task1.component.ArrayData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class ConfigurationTest {

    @Test
    public void testRun() {
        //given
        Configuration config = new Configuration();
        config.changeDefaultArrayLength(1000);
        config.setMultiplier(14);
        config.setThreadsQuantity(10);
        //when
        int[] copyOfArray = Arrays.copyOf(config.getArray().getArray(), 1000);
        config.run();
        ArrayData resultArrayData = config.getArray();
        //then
        for (int i=0; i<copyOfArray.length; i++) {
            Assert.assertEquals(copyOfArray[i], resultArrayData.getArray()[i]/14);
        }
    }

    @Test
    public void testRunWithNoConfiguration() {
        //given
        Configuration config = new Configuration(); // only default settings
        //when
        int[] copyOfArray = Arrays.copyOf(config.getArray().getArray(), 10);
        config.run();
        ArrayData resultArrayData = config.getArray();
        //then
        for (int i=0; i<copyOfArray.length; i++) {
            Assert.assertEquals(copyOfArray[i], resultArrayData.getArray()[i]);
        }
    }

}
