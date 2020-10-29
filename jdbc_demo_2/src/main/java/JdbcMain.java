import dao.PlayerDAO;
import dao.impl.PlayerDAOImpl;
import exception.BusinessException;
import model.Player;

public class JdbcMain {
    public static void main(String[] args) {
        //       Player player = new Player(102, 23, "Bobby", "Yankees", 1287704875, "M");

        PlayerDAO playerDAO = new PlayerDAOImpl();

        try {
            playerDAO.updatePlayerContact(103, 14778569853L);
            System.out.println("Updated the contact information of player with id : 103");
        } catch (BusinessException e) {
            e.printStackTrace();
        }

//            try {
//                playerDAO.deletePlayer(105);
//                System.out.println("Player with id 105 has been deleted");
//            } catch (BusinessException e) {
//                e.printStackTrace();
//            }

//
//        try {
//            if (playerDAO.createPlayer(player) > 0) {
//                System.out.println("Player created in DB with below details");
//                System.out.println(player);
//            }
//        } catch (BusinessException e) {
//            System.out.println(e.getMessage());
//        }

//        System.out.println("Getting player with id 105\n");
//        try {
//            Player player = playerDAO.getPlayerById(105);
//            if (player != null) {
//                System.out.println("Player found with id " + 105 + "\n" + player);
//            }
//        } catch (BusinessException e) {
//            System.out.println(e.getMessage());
//        }
    }
}