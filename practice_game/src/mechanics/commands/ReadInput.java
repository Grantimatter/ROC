package mechanics.commands;

import exceptions.InvalidAttackException;
import exceptions.InvalidInputException;
import interfaces.IAttackable;
import mechanics.entities.Entity;
import messages.GenericMessages;

import java.util.Scanner;

public class ReadInput {

    private static Scanner scanner;

    public static void read(Entity entity) throws InvalidInputException, InvalidAttackException {
        if(scanner == null) scanner = new Scanner(System.in);

        try {
            String str = scanner.next().toLowerCase();

            switch (str) {
                case "?": case "help":
                    GenericMessages.helpMessage();
                    break;
                case "a": case "attack":
                    try{
                        IAttackable targetEntity = entity.getTargetEntity();
                        if(targetEntity instanceof IAttackable) {
                            HostileCommands.attackCommand(targetEntity, entity);
                        }
                        if(targetEntity == null){
                            throw new InvalidAttackException("You must be targeting something to attack!");
                        }

                    } catch(InvalidAttackException e){
                        System.out.println(e.getMessage());
                        read(entity);
                    }

                    break;
                case "i": case "inventory": case "inv":
                    GeneralCommands.openInventory(entity.getInventory());
                    break;
                case "q": case "quit":
                    GeneralCommands.wrapUp();
                    break;
                default:
                    throw new InvalidInputException("Please input a valid command, type \"?\" or \"help\" to see a list of valid commands");
            }
        } catch (InvalidInputException e){
            System.out.println(e.getMessage());
            read(entity);
        }
    }

    public static boolean ynRead() throws InvalidInputException{
        if(scanner == null) scanner = new Scanner(System.in);
        try {
            String str = scanner.next();

            switch (str) {
                case "y": case "yes":
                    return true;
                case "n": case "no":
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
