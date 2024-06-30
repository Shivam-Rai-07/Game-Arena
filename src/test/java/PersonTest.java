import static org.junit.jupiter.api.Assertions.assertEquals;

import Game.Arena.Person;
import org.junit.jupiter.api.Test;

public class PersonTest {

    @Test
    public void testGetName() {
        Person person = new Person("Shivam");
        assertEquals("Shivam", person.getName(), "Shivam");
    }
}
