package mechanics.commands;

import java.util.Scanner;

public class GameFlow {
    public static void playerDeath(){
        System.out.print("\nWould you like to play again? Y/N");
        Scanner scanner = new Scanner(System.in);

        if(ReadInput.ynRead()){
            //MainLoop.endGame();
        }
    }
}
