package mechanics.commands;

import exceptions.InvalidInputException;
import messages.GenericMessages;
import mechanics.commands.GeneralCommands;

import java.util.Scanner;

public class ReadInput {

    private static Scanner scanner;

    public static boolean read() throws InvalidInputException {
        if(scanner == null) scanner = new Scanner(System.in);

        try {
            String str = scanner.next().toLowerCase();

            switch (str) {
                case "?": case "help":
                    GenericMessages.helpMessage();
                    break;
                case "r":
                case "reload":

                    break;
                case "q":
                case "quit":
                    GeneralCommands.wrapUp();
                    break;
                default:
                    throw new InvalidInputException("Please input a valid command, type \"?\" or \"help\" to see a list of valid commands");
            }
        } catch (InvalidInputException e){
            e.getMessage();
        }

        return false;
    }

    public static boolean ynRead() throws InvalidInputException{
        if(scanner == null) scanner = new Scanner(System.in);

        try {
            String str = scanner.next();

            switch (str) {
                case "y":
                    return true;
                case "n":
                    return false;
                default:
                    throw new InvalidInputException("Please input either \"Y\" or \"N\"\n");
            }
        } catch(InvalidInputException e){
            System.out.print(e.getMessage());
            return ynRead();
        }
    }

}
