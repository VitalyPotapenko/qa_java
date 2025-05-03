import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    @Mock
    Feline feline;

    @Test
    public void lionConstructorShouldThrowAnExceptionWhenIllegalSexIsPassed() {
        Assert.assertThrows(Exception.class, () -> new Lion(feline, "НеведомаЗверушка"));
        String expectedErrorMessage = "Используйте допустимые значения пола животного - самей или самка";
        try {
            new Lion(feline, "НеведомаЗверушка");
        } catch (Exception exc) {
            assertEquals(expectedErrorMessage, exc.getMessage());
        }
    }

    @Test
    public void lionShouldEatPredatorsFood() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        lion.getFood();
        Mockito.verify(feline, Mockito.times(1)).getFood("Хищник");
    }
}
