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
public class CatsFoodTest {
    private Feline felineMock;
    private Cat cat;
    private List<String> expected;

    // Параметризированный тест
    public CatsFoodTest(List<String> expected) {
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
}