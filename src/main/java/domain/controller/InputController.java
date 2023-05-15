package domain.controller;

import domain.validate.inputView.ValidateInputPlayersName;
import domain.view.InputView;

public class InputController {

    public static String inputPlayerNames(){
        try {
            String input = InputView.inputPlayersName();
            ValidateInputPlayersName.validatePlayersName(input);
            return input;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPlayerNames();
        }
    }
}
