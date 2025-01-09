import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(Parameterized.class)
public class CatTest {

    private Feline felineMock;
    private Cat cat;
    private List<String> expected;

    // Параметризированный тест
    public CatTest(List<String> expected) {
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[] data() {
        return new Object[][] {
                {Arrays.asList("Мясо", "Рыба")}, // Ожидаемая еда
                {Arrays.asList("Птица", "Мыши")}  // Другой возможный набор еды
        };
    }

    @Test
    public void testGetSound() {
        cat = new Cat(mock(Feline.class));
        assertEquals("Мяу", cat.getSound());
    }

    @Test
    public void testGetFood() throws Exception {
        // Создаём мок для Predator (Feline)
        felineMock = mock(Feline.class);
        when(felineMock.eatMeat()).thenReturn(expected);  // Мокируем возвращаемое значение

        // Создаём объект Cat с мокированным Feline
        cat = new Cat(felineMock);

        // Проверяем, что метод getFood возвращает ожидаемое значение
        List<String> food = cat.getFood();
        assertEquals(expected, food);
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        // Создаём мок для Predator (Feline), который будет выбрасывать исключение
        felineMock = mock(Feline.class);
        when(felineMock.eatMeat()).thenThrow(new Exception("Ошибка"));

        // Создаём объект Cat с мокированным Feline
        cat = new Cat(felineMock);

        // Проверяем, что метод getFood выбрасывает исключение
        cat.getFood();
    }

    @Test
    public void testConstructor() throws Exception {
        // Создаем объект Cat с мокированным Feline
        felineMock = mock(Feline.class);
        cat = new Cat(felineMock);

        assertNotNull(cat);
    }
}