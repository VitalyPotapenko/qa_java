import com.example.Animal;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class AnimalParameterizedTest {

    @Parameter
    public String animalKind;

    @Parameter(1)
    public List<String> food;

    @Parameters(name = "Животное с типом питания {0} должно питаться таким набором {1}")
    public static Object[][] data() {
        return new Object[][]{
                {"Травоядное", List.of("Трава", "Различные растения")},
                {"Хищник", List.of("Животные", "Птицы", "Рыба")}
        };
    }

    @Test
    public void eachAnimalKindShouldHaveProperFood() throws Exception{
         Animal animal = new Animal();
         List<String> expectedFood = food;
         List<String> actualFood = animal.getFood(animalKind);

         assertTrue("Ожидалось, что " + animalKind + " питается " + expectedFood + " а оказалось " + actualFood,
                 expectedFood.containsAll(actualFood) && actualFood.containsAll(expectedFood));
    }

}
