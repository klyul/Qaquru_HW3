import org.junit.jupiter.api.*;

public class Junit {

    @BeforeAll
    static void beforeAll() {
        System.out.println("Here before all");
    }
    @BeforeEach
    void beforeEach() {
        System.out.println("Here BeforeEach");
    }

    @AfterAll
    static void AfterAll() {
        System.out.println("Here after all");
    }
    @AfterEach
    void afterEach() {
        System.out.println("Here after each");
    }

    @Test
    void firstTest() {
        System.out.println("Here is first Test()");
    }

    @Test
    void secondTest() {
        System.out.println("Here is Second Test()");
    }
}