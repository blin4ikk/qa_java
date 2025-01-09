import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

@RunWith(Parameterized.class)
public class LionManeTest {

    private final String inputSex;
    private final boolean expectedHasMane;
    private final boolean expectException;

    public LionManeTest(String inputSex, boolean expectedHasMane, boolean expectException) {
        this.inputSex = inputSex;
        this.expectedHasMane = expectedHasMane;
        this.expectException = expectException;
    }

    @Parameterized.Parameters(name = "Test with sex={0}, expectHasMane={1}, expectException={2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true, false},      // Пол "Самец", ожидаем грива = true
                {"Самка", false, false},     // Пол "Самка", ожидаем грива = false
                {"Некорректно", false, true} // Некорректный пол, ожидаем исключение
        });
    }

    @Test
    public void testLionMane() {
        Feline felineMock = mock(Feline.class); // Используем mock для Feline
        try {
            Lion lion = new Lion(inputSex, felineMock);

            if (expectException) {
                fail("Ожидалось исключение, но оно не было выброшено");
            }

            assertEquals("Грива должна соответствовать ожиданию", expectedHasMane, lion.doesHaveMane());
        } catch (Exception e) {
            if (!expectException) {
                fail("Исключение не ожидалось, но было выброшено: " + e.getMessage());
            }

        }
    }
}