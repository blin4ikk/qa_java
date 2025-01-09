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
    public void testGetFood() throws Exception {
        Feline feline = new Feline();

        if (expectedException == null) {
            List<String> food = feline.getFood(animalKind);
            assertEquals(expectedFood, food);
        } else {
            // Проверяем, что выбрасывается исключение
            Exception exception = assertThrows(expectedException, () -> {
                feline.getFood(animalKind);
            });
            assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", exception.getMessage());
        }
    }
}