import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.assertEquals;
import static org.junit.runners.Parameterized.*;

@RunWith(Parameterized.class)
public class LionParameterizedTest {
    @Parameter
    public String sex;
    @Parameter(1)
    public boolean hasMane;
    @Mock
    Feline feline;

    @Parameters
    public static Object[][] data() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false}
        };
    }

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void maneAttributionShouldWorkProperly() throws Exception {
        Lion lion = new Lion(feline, sex);
        assertEquals(hasMane, lion.doesHaveMane());
    }

    @Test
    public void lionShouldInvokeFelineMethodWhenAskedForKittens() throws Exception{
        Lion lion = new Lion(feline, sex);
        lion.getKittens();
        Mockito.verify(feline, Mockito.times(1)).getKittens();
    }

}
