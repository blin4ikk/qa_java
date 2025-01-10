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
public class LionManeExceptionTest {

    private final String invalidSex;

    public LionManeExceptionTest(String invalidSex) {
        this.invalidSex = invalidSex;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Некорректно"} // Некорректный пол
        });
    }

    @Test
    public void testLionThrowsExceptionForInvalidSex() {
        Feline felineMock = mock(Feline.class); // Используем mock для Feline

        Exception exception = assertThrows(Exception.class, () -> {
            new Lion(invalidSex, felineMock);
        });

        assertEquals("Используйте допустимые значения пола животного - самец или самка",exception.getMessage());
    }
}