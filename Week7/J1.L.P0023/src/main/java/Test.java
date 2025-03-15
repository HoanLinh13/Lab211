import controller.FruitShopManagement;
import view.UserInterface;

public class Test {
    public static void main(String[] args) {
        FruitShopManagement shop = new FruitShopManagement();
        UserInterface ui = new UserInterface(shop);
        ui.start();

    }
}
