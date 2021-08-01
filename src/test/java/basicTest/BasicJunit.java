package basicTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicJunit {
    //setup -initialize -acciones que se ejecutan antes de cada test
    @BeforeEach
    public void setup(){
        System.out.println("before");

    }
    // cleanup -teardown
    @AfterEach
    public void cleanup(){
        System.out.println("after");
    }

    @Test
    public void thisIsATest(){
        System.out.println("Test 1");

    }
    @Test
    public void thisIsATest2(){
        System.out.println("Test 2");
    }
}
