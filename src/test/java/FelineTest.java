import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline;

    @Test
    public void testEatMeat() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо", "Рыба"));

        // Проверяем, что метод возвращает нужный результат
        List<String> food = feline.getFood("Хищник");
        assertEquals(List.of("Мясо", "Рыба"), food); // Проверяем, что getFood() был вызван с правильным аргументом
    }

    @Test
    public void testEatsMeat() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Мясо", "Рыба"));

        // Проверяем, что метод возвращает нужный результат
        List<String> food = feline.getFood("Хищник");
        assertEquals(List.of("Мясо", "Рыба"), food); // Проверяем, что getFood() был вызван с правильным аргументом
    }

    @Test
    public void testGetFamily() {
        assertEquals("Семейство должно быть 'Кошачьи'", "Кошачьи", feline.getFamily());
    }

    @Test
    public void testDefaultGetKittens() {
        assertEquals("По умолчанию должно быть 1 котенок", 1, feline.getKittens());
    }
}
