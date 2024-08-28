package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AnimalTestParametrized {

    public static final List<String> VEGETERIAN_FOOD = List.of("Трава", "Различные растения");
    public static final List<String> PREDATORS_FOOD = List.of("Животные", "Птицы", "Рыба");
    public static final String HERBIVORE = "Травоядное";
    public static final String PREDATOR = "Хищник";
    private Animal animal;
    private String animalKind;
    private List<String> food;

    @Before
    public void setUp(){
        animal = new Animal();
    }

    public AnimalTestParametrized(String animalKind, List<String> food) {
        this.animalKind = animalKind;
        this.food = food;
    }

    @Parameterized.Parameters
    public static Object[][] getParameters() {
        return new Object[][]{
                {HERBIVORE, VEGETERIAN_FOOD},
                {PREDATOR, PREDATORS_FOOD}
        };
    }

    @Test
    public void testGetFood() throws Exception{
        assertEquals(food, animal.getFood(animalKind));
    }


}

