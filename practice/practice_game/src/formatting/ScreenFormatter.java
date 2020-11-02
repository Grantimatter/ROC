package formatting;

import mechanics.entities.Entity;
import mechanics.entities.Player;
import messages.Gui;

public class ScreenFormatter {

    private static StringBuilder sb;

    public static void clearConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String[] getGuis(Player player, Entity target) {
        if (player != null && target != null) {
            String[] uiArray = new String[2];
            uiArray[0] = Gui.getGuiString(player);
            uiArray[1] = Gui.getGuiString(target);
            return uiArray;
        } else {
            return new String[]{Gui.getGuiString(player)};
        }
    }

    public static void addString(String str) {
        if (sb == null) sb = new StringBuilder(str);
        else
            sb.append(str);
    }

    public static void refreshScreen(Player player, Entity target) {
        String[] uiArray = getGuis(player, target);
        StringBuilder uiBuilder = new StringBuilder();
        for (String ui : uiArray) {
            if (ui != null && ui.length() > 0) {
                if (uiBuilder == null) uiBuilder = new StringBuilder(uiBuilder);
                uiBuilder.append("\n"+ui+"\n");
            }
        }
        sb.insert(0, uiBuilder.toString() + "\n");

        clearConsole();
        if (sb.toString().length() > 0)
            System.out.println(sb.toString());
        sb.setLength(0);
    }
}
