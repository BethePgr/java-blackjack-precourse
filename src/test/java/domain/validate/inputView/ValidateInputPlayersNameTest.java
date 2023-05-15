package domain.validate.inputView;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidateInputPlayersNameTest {

    @Test
    @DisplayName("양식에 맞는 이름 하나를 적었으므로 오류가 뜨지 않는다.")
    void test1_No_Error() throws Exception {
        String names = "one";
        assertDoesNotThrow(() -> ValidateInputPlayersName.validatePlayersName(names));
    }

    @Test
    @DisplayName("양식에 맞는 이름 두 개를 적었으므로 오류가 뜨지 않는다.")
    void test2_No_Error() throws Exception {
        String names = "one,two";
        assertDoesNotThrow(() -> ValidateInputPlayersName.validatePlayersName(names));
    }

    @Test
    @DisplayName("이름이 담긴 리스트의 길이가 0이므로 에러를 던지게 된다.")
    void test1_Error() throws Exception {
        String name = ",";
        assertThrows(IllegalArgumentException.class,() -> ValidateInputPlayersName.validatePlayersName(name));
    }

    @Test
    @DisplayName("이름이 영어로만 되어있는게 아니라서 에러를 던지게 된다. - 1")
    void test2_Error() throws Exception {
        String name = "가나,one";
        assertThrows(IllegalArgumentException.class,() -> ValidateInputPlayersName.validatePlayersName(name));
    }

    @Test
    @DisplayName("이름이 영어로만 되어있는게 아니라서 에러를 던지게 된다. - 2")
    void test3_Error() throws Exception {
        String name = "two2,one";
        assertThrows(IllegalArgumentException.class,() -> ValidateInputPlayersName.validatePlayersName(name));
    }

    @Test
    @DisplayName("이름이 한 글자인게 있으므로 에어를 던지게 된다. - 1")
    void test4_Error() throws Exception {
        String name = "o,two";
        assertThrows(IllegalArgumentException.class,() -> ValidateInputPlayersName.validatePlayersName(name));
    }

    @Test
    @DisplayName("이름이 다섯 글자를 넘어서는게 있으므로 에러를 던지게 된다.")
    void test5_Error() throws Exception {
        String name = "twooos";
        assertThrows(IllegalArgumentException.class,() -> ValidateInputPlayersName.validatePlayersName(name));
    }

}