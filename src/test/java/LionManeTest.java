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
    private final boolean expected;

    public LionManeTest(String inputSex, boolean expected) {
        this.inputSex = inputSex;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"Самец", true},   // Пол "Самец", ожидаем грива = true
                {"Самка", false}   // Пол "Самка", ожидаем грива = false
        });
    }

    @Test
    public void testLionHasMane() throws Exception {
        Feline felineMock = mock(Feline.class); // Используем mock для Feline
        Lion lion = new Lion(inputSex, felineMock);
        assertEquals("Грива должна соответствовать ожиданию", expected, lion.doesHaveMane());
    }
}