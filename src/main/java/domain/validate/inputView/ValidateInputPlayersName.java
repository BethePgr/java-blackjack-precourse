package domain.validate.inputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ValidateInputPlayersName {

    public static void validatePlayersName(String input){
        List<String> names = Arrays.stream(input.split(",")).collect(Collectors.toList());
        validateMoreThanOnePlayer(names);
        for(String name : names){
            validatePlayerNameIsOnlyEnglish(name);
            validateNameSizeBetween2And5(name);
        }
    }

    private static void validateMoreThanOnePlayer(List<String> names){
        if(names.size() == 0){
            throw new IllegalArgumentException("[ERROR] 플레이어의 수는 적어도 한 명은 있어야 합니다.");
        }
    }

    private static void validatePlayerNameIsOnlyEnglish(String name){
        String reg = "^[a-zA-Z]*$";
        if(!name.matches(reg)){
            throw new IllegalArgumentException("[ERROR] 플레이어의 이름은 영어만 사용 가능합니다.");
        }
    }

    private static void validateNameSizeBetween2And5(String name){
        if(name.length() < 2 || name.length() > 5){
            throw new IllegalArgumentException("[ERROR] 이름은 두 글자와 다섯 글자 사이여야 합니다.");
        }
    }
}
