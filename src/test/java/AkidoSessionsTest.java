import org.junit.jupiter.api.*;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AkidoSessionsTest {

    static AkidoSessions akidoSessions;

    @BeforeAll
    static void setUp() {
        akidoSessions = new AkidoSessions();
    }
    @Test
    @Order(1)
    void addSession() {
        akidoSessions.addSession(LocalDateTime.parse("2021-01-01T00:00:00"));
        assertEquals(1, akidoSessions.getNumberOfSessions());
    }

    @Test
    @Order(2)
    void getNumberOfSessions() {
        akidoSessions.addSession(LocalDateTime.parse("2021-02-01T00:00:00"));
        assertEquals(2, akidoSessions.getNumberOfSessions());
    }

    @Test
    @Order(3)
    void getTotalMonths() {
        akidoSessions.addSession(LocalDateTime.parse("2021-03-01T00:00:00"));
        assertEquals(2, akidoSessions.getTotalMonths());
    }

    @Test
    @Order(4)
    void isEligibleForGraduation() {
        akidoSessions.addSession(LocalDateTime.parse("2021-11-01T00:00:00"));
        assertTrue(akidoSessions.isEligibleForGraduation());
    }
}