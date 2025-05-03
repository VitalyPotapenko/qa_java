import com.example.Animal;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnimalTest {
    Animal animal = new Animal();

    @Test
    public void getFoodMethodShouldThrowExceptionWhenInvokedWithUnexpectedParameter() {
        Assert.assertThrows(Exception.class, () -> animal.getFood("Нетакое"));
        String expectedErrorMessage = "Неизвестный вид животного, используйте значение Травоядное или Хищник";
        try {
            animal.getFood("Нетакое");
        } catch (Throwable thr) {
            assertEquals(expectedErrorMessage, thr.getMessage());
        }
    }

    @Test
    public void familiesShouldBeListedProperly() {
        String expected = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";
        String actual = animal.getFamily();
        assertEquals(expected, actual);
    }
}
