package com.kodilla.multi.task1;

import com.kodilla.multi.task1.component.ArrayData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Arrays;

@RunWith(JUnit4.class)
public class ApplicationTest {

    @Test
    public void testRun() {
        //given
        Configuration configuration = new Configuration(1000);
        //when
        int[] copyOfArray = Arrays.copyOf(configuration.getArray().getArray(), 1000);
        configuration.run(3);
        ArrayData resultArrayData = configuration.getArray();
        //then
        for (int i=0; i<copyOfArray.length; i++) {
            Assert.assertEquals(copyOfArray[i], resultArrayData.getArray()[i]/3);
        }
    }

}
