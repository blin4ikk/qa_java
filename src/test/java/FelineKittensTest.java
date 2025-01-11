import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class FelineKittensTest {

    private final int inputKittensCount;
    private final int expectedKittensCount;

    public FelineKittensTest(int inputKittensCount, int expectedKittensCount) {
        this.inputKittensCount = inputKittensCount;
        this.expectedKittensCount = expectedKittensCount;
    }

    @Parameterized.Parameters(name = "Test with kittensCount={0}, expect={1}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {1, 1},    // Обычный случай
                {0, 0},    // Нет котят
                {10, 10},  // Много котят
                {-1, -1}   // Отрицательное значение (неявное поведение)
        });
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        assertEquals("Количество котят должно совпадать с ожидаемым результатом", expectedKittensCount, feline.getKittens(inputKittensCount));
    }
}