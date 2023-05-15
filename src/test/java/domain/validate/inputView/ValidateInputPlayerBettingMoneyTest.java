package domain.validate.inputView;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateInputPlayerBettingMoneyTest {

    @Test
    @DisplayName("1000원보다 작으므로 오류를 던진다.")
    void test1_Error() throws Exception {
        String input = "999";
        assertThrows(IllegalArgumentException.class,
            () -> ValidateInputPlayerBettingMoney.validateBettingMoney(input));
    }

    @Test
    @DisplayName("1000원으로 나누어 떨어지지 않으므로 오류를 던진다.")
    void test2_Error() throws Exception {
        String input = "1001";
        assertThrows(IllegalArgumentException.class,
            () -> ValidateInputPlayerBettingMoney.validateBettingMoney(input));
    }

    @Test
    @DisplayName("숫자로만 이루어진 것이 아니므로 오류를 던진다.")
    void test3_Error() throws Exception {
        String input = "1000a";
        assertThrows(IllegalArgumentException.class,
            () -> ValidateInputPlayerBettingMoney.validateBettingMoney(input));
    }

    @Test
    @DisplayName("1000원은 에러가 뜨지 않는다.")
    void test1_No_Error() throws Exception {
        String input = "1000";
        assertDoesNotThrow(() -> ValidateInputPlayerBettingMoney.validateBettingMoney(input));

    }

    @Test
    @DisplayName("12000원은 에러가 뜨지 않는다.")
    void test2_No_Error() throws Exception {
        String input = "12000";
        assertDoesNotThrow(() -> ValidateInputPlayerBettingMoney.validateBettingMoney(input));
    }
}