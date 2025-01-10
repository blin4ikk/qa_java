import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class IsFelineTest {

    private String animalKind;
    private List<String> expectedFood;
    private Class<? extends Exception> expectedException;

    // Параметризированный тест
    public IsFelineTest(String animalKind, List<String> expectedFood, Class<? extends Exception> expectedException) {
        this.animalKind = animalKind;
        this.expectedFood = expectedFood;
        this.expectedException = expectedException;
    }

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][] {
                {"Травоядное", List.of("Трава", "Различные растения"), null},  // Травоядное
                {"Хищник", List.of("Животные", "Птицы", "Рыба"), null},       // Хищник
                {"Неизвестное животное", null, Exception.class}               // Исключение
        };
    }

    @Test
    public void testGetFoodReturnsCorrectListForValidAnimalKind() throws Exception {
        Feline feline = new Feline();
        String animalKind = "Хищник"; // Пример валидного значения
        List<String> expectedFood = Arrays.asList("Животные", "Птицы", "Рыба");

        List<String> actualFood = feline.getFood(animalKind);

        assertEquals("Список еды должен совпадать", expectedFood, actualFood);
    }

    @Test
    public void testGetFoodThrowsExceptionForInvalidAnimalKind() {
        Feline feline = new Feline();
        String invalidAnimalKind = "Неизвестный";

        Exception exception = assertThrows(Exception.class, () -> {
            feline.getFood(invalidAnimalKind);
        });

        assertEquals(
                "Неизвестный вид животного, используйте значение Травоядное или Хищник",
                exception.getMessage()
        );
    }
}