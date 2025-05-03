import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTest {

    @Spy
    Feline feline = new Feline();

    @Test
    public void felineShouldEatFlesh() throws Exception {
         feline.eatMeat();
        Mockito.verify(feline).getFood("Хищник");
    }

    @Test
    public void felineShouldHaveProperFamily() {
        String expectedFamily = "Кошачьи";
        String actualFamily = feline.getFamily();

        assertEquals("Ожидаем, что объекты класса Feline должны принадлежать к семейству " + expectedFamily +
                ", а оказалось что фактически они из семейства " + actualFamily, expectedFamily, actualFamily);
    }

    @Test
    public void felineShouldHaveOneKittenByDefault() {
        int expectedKittens = 1;
        int actualKittens = feline.getKittens();

        Mockito.verify(feline, Mockito.times(1)).getKittens(1);
        assertEquals("Ожидаем, что по умолчанию у кошачьих раождается " + expectedKittens + " котёнок. " +
                "А фактически родилось " + actualKittens, expectedKittens, actualKittens);
    }

    @Test
    public void felineShouldHaveAsManyKittensAsRequested() {
        int expectedKittens = (int) (Math.random()*10); //произвольное число котят до 10
        int actualKittens = feline.getKittens(expectedKittens);

        assertEquals("Ожидаем " + expectedKittens + " а получили " + actualKittens + " котят",
                expectedKittens, actualKittens);
    }
}
