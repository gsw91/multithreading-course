package com.kodilla.multi.task2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArrayCreatorTest {

    @Test
    public void testCreateArray() {
        //given
        ArrayCreator arrayCreator = new ArrayCreator(500,1000);
        //when
        int[] arrOne = arrayCreator.createArray();
        int[] arrTwo = arrayCreator.createArray();
        //then
        Assert.assertEquals(arrOne.length, 500);
        Assert.assertEquals(arrTwo.length, 500);
    }

}
