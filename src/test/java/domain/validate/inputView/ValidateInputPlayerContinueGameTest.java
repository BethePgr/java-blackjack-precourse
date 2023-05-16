package domain.validate.inputView;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateInputPlayerContinueGameTest {

    @Test
    @DisplayName("y이므로 에러를 발생하지 않는다.")
    void test1() throws Exception {
        assertDoesNotThrow(() -> ValidateInputPlayerContinueGame.validateContinue("y"));
    }

    @Test
    @DisplayName("n이므로 에러를 발생하지 않는다.")
    void test2() throws Exception {
        assertDoesNotThrow(() -> ValidateInputPlayerContinueGame.validateContinue("n"));
    }

    @Test
    @DisplayName("y랑 n이 아니므로 에러를 발생한다.")
    void test3() throws Exception {
        assertThrows(IllegalArgumentException.class, () -> ValidateInputPlayerContinueGame.validateContinue("t"));
    }
}