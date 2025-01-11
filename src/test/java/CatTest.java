import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    Feline felineMock;


    @Test
    public void testGetSound() {
        Cat cat = new Cat(mock(Feline.class));
        assertEquals("Мяу", cat.getSound());
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        // Создаём мок для Predator (Feline), который будет выбрасывать исключение
        felineMock = mock(Feline.class);
        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка"));

        // Создаём объект Cat с мокированным Feline
        Cat cat = new Cat(felineMock);

        // Проверяем, что метод getFood выбрасывает исключение
        cat.getFood();
    }

    @Test
    public void testConstructor() throws Exception {
        // Создаем объект Cat с мокированным Feline
        felineMock = mock(Feline.class);
        Cat cat = new Cat(felineMock);
        assertNotNull(cat);
    }
}