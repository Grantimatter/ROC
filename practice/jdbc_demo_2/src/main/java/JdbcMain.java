import dao.PlayerDAO;
import dao.impl.PlayerDAOImpl;
import exception.BusinessException;
import model.Player;

public class JdbcMain {
    public static void main(String[] args) {

        PlayerDAO playerDAO = new PlayerDAOImpl();

        testGetPlayerId(playerDAO, 10);
        //testCreatePlayer(playerDAO);
        //testDeletePlayer(playerDAO);
        //testUpdateContact(playerDAO);
    }

    private static void testGetPlayerId(PlayerDAO playerDAO, int id) {
        System.out.println("Getting player with id "+id+"\n");
        try {
            Player player = playerDAO.getPlayerById(id);
            if (player != null) {
                System.out.println("Player found with id " + id + "\n" + player);
            }
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testCreatePlayer(PlayerDAO playerDAO) {
        Player player = new Player(102, 23, "Bobby", "Yankees", 1287704875, "M");
        try {
            if (playerDAO.createPlayer(player) > 0) {
                System.out.println("Player created in DB with below details");
                System.out.println(player);
            }
        } catch (BusinessException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void testDeletePlayer(PlayerDAO playerDAO) {
        try {
            playerDAO.deletePlayer(105);
            System.out.println("Player with id 105 has been deleted");
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }

    private static void testUpdateContact(PlayerDAO playerDAO) {
        try {
            playerDAO.updatePlayerContact(103, 14778569853L);
            System.out.println("Updated the contact information of player with id : 103");
        } catch (BusinessException e) {
            e.printStackTrace();
        }
    }
}