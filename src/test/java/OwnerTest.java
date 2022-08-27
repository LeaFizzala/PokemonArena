import Pokemon.owner.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnerTest {
    private Owner o;

    @BeforeEach
    public void GenerateNewOwner(){
        this.o = new Owner();
    }


}
