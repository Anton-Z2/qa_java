package com.example;

import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

    public static final String SEX = "Самка";
    public static final String EXPECTED = "Используйте допустимые значения пола животного - самец или самка";
    private Lion lion;
    @Mock
    private Feline feline;

    @Before
    public void setUp() throws Exception{
        lion = new Lion(SEX, feline);
    }

    @Test
    public void testDoesHaveManeFemale() {
        assertEquals(false, lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeMale() throws Exception {
        lion = new Lion("Самец", feline);
        assertEquals(true, lion.doesHaveMane());
    }

    @Test
    public void testLionConstructorWithInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Львенок", feline);
        });
        assertEquals(EXPECTED, exception.getMessage());
    }

    @Test
    public void testGetKittens() {
        when(feline.getKittens()).thenReturn(2);
        assertEquals(2, lion.getKittens());
        verify(feline, times(1)).getKittens();
    }


    @Test
    public void testGetFood() throws Exception {
        List<String> food = List.of("Животные", "Птицы", "Рыба");
        when(feline.getFood("Хищник")).thenReturn(food);
        assertEquals(food, lion.getFood());
        verify(feline, times(1)).getFood("Хищник");
    }

}

