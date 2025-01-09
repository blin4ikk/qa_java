import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {

  private Feline felineMock;
  private Lion lion;
  private Lion lioness;


    @Before
    public void setUp() throws Exception {
        felineMock = mock(Feline.class);
        lion = new Lion("Самец", felineMock);
        lioness = new Lion("Самка", felineMock);
    }

    @Test
    public void testGetKittens() {
        when(felineMock.getKittens()).thenReturn(3); // Заглушка: возвращаем 3 котенка
        assertEquals("Количество котят должно быть 3", 3, lion.getKittens());
        verify(felineMock, times(1)).getKittens(); // Проверяем вызов метода
    }

    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = Arrays.asList("Мясо", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood); // Заглушка: возвращаем список еды

        assertEquals("Список еды должен совпадать", expectedFood, lion.getFood());
        verify(felineMock, times(1)).getFood("Хищник"); // Проверяем вызов метода с правильным аргументом
    }
    @Test
    public void testDoesHaveMane() {
        assertTrue("Грива должна быть у самца", lion.doesHaveMane());
    }

    @Test
    public void testDoesNotHaveMane() {
        assertFalse("Гривы не должно быть у самки", lioness.doesHaveMane());
    }
}