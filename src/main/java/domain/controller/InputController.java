package domain.controller;

import domain.validate.inputView.ValidateInputPlayerBettingMoney;
import domain.validate.inputView.ValidateInputPlayerContinueGame;
import domain.validate.inputView.ValidateInputPlayersName;
import domain.view.InputView;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputController {

    public static List<String> inputPlayerNames(){
        try {
            String input = InputView.inputPlayersName();
            ValidateInputPlayersName.validatePlayersName(input);
            return Arrays.stream(input.split(",")).collect(Collectors.toList());
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPlayerNames();
        }
    }

    public static int inputPlayerBettingMoney(String name){
        try {
            String input = InputView.inputPlayerBettingMoney(name);
            return ValidateInputPlayerBettingMoney.validateBettingMoney(input);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPlayerBettingMoney(name);
        }
    }

    public static String inputPlayerContinueGame(String name){
        try{
            String input = InputView.inputPlayerContinueGame(name);
            ValidateInputPlayerContinueGame.validateContinue(input);
            return input;
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPlayerContinueGame(name);
        }
    }

}
