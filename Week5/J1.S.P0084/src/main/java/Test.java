import controller.LargeNumberManager;
import model.LargeNumberCalculator;
import view.UserInterface;

public class Test {
    public static void main(String[] args) {
        LargeNumberCalculator calculator = new LargeNumberManager();
        UserInterface ui = new UserInterface(calculator);
        ui.start();
    }
}
