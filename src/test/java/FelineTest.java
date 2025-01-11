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
    Feline feline; // Используем Spy для тестирования реального класса

    // Тесты для метода eatMeat()
    @Test
    public void testEatMeatReturnsCorrectFoodList() throws Exception {
        doReturn(List.of("Мясо", "Рыба")).when(feline).getFood("Хищник");

        List<String> food = feline.eatMeat();
        assertEquals("Метод eatMeat должен возвращать ['Мясо', 'Рыба']", List.of("Мясо", "Рыба"), food);
    }

    @Test
    public void testEatMeatCallsGetFoodWithCorrectArgument() throws Exception {
        doReturn(List.of("Мясо", "Рыба")).when(feline).getFood("Хищник");
        feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

    // Тесты для метода getFamily()
    @Test
    public void testGetFamilyReturnsCorrectValue() {
        assertEquals("Метод getFamily должен возвращать 'Кошачьи'", "Кошачьи", feline.getFamily());
    }

    // Тесты для метода getKittens()
    @Test
    public void testDefaultGetKittensReturnsOne() {
        assertEquals("Метод getKittens по умолчанию должен возвращать 1", 1, feline.getKittens());
    }

    @Test
    public void testDefaultGetKittensCallsOverloadedMethod() {
        feline.getKittens();
        Mockito.verify(feline).getKittens(1);
    }
}

