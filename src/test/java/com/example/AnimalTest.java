package com.example;
import com.example.Animal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class AnimalTest {

    public static final String EXPECTED_GET_FOOD = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
    public static final String EXPECTED_GET_FAMILY = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

    private Animal animal;

    @Before
    public void setUp(){
        animal = new Animal();
    }

    @Test
    public void testGetFamily() {
        assertEquals(EXPECTED_GET_FAMILY, animal.getFamily());
    }

    @Test
    public void testExceptionGetFood() {
        Exception exception = assertThrows(Exception.class, () -> {
            animal.getFood("Всеядное");
        });
        assertEquals(EXPECTED_GET_FOOD, exception.getMessage());
    }
}
