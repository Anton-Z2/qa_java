package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    private Feline feline;


    @Test
    public void testEatMeat() throws Exception{
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }

    @Test
    public void testGetFamily() {
        assertEquals("Кошачьи", feline.getFamily());
        Mockito.verify(feline, Mockito.times(1)).getFamily();
    }

    @Test
    public void testGetKittensNoArg() {
        assertEquals(1, feline.getKittens());
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

    @Test
    public void testGetKittensWithArg() {
        assertEquals(4, feline.getKittens(4));
        Mockito.verify(feline).getKittens(Mockito.anyInt());
        Mockito.verify(feline, Mockito.times(1)).getKittens(4);
    }

}

