import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    @Mock
    public Feline feline;


    @Test
    public void catShouldSayMeow() {
        Cat cat = new Cat(feline);
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectedSound, actualSound);
    }

    @Test
    public void catShouldEatPredatorsFood() throws Exception{
        Cat cat = new Cat(feline);
        cat.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
