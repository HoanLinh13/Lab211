package utility;

import model.Fruit;

import java.util.List;

public class CheckValidate {
     public boolean checkMenu(int choice) {
        if (choice > 0 && choice <= 4)
            return true;
        else {
            System.err.println("Error: Please enter a number between 1 and 4!");
            return false;
        }
    }
    public boolean isExitsName(String name, String origin, List<Fruit> fruitList) {
        for (Fruit fruit : fruitList) {
            if (fruit.getFruitName().equalsIgnoreCase(name) && fruit.getOrigin().equalsIgnoreCase(origin)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkPrice(double price) {
        if (price > 0)
            return true;
        else{
            System.err.println("Error: Please enter a valid price > 0");
            return false;
        }
    }

    public boolean checkQuantity(int quantity) {
        if (quantity > 0)
            return true;
        else{
            System.err.println("Error: Please enter a valid quantity > 0");
            return false;
        }
    }

    public boolean checkIndex(int index, List<Fruit> fruitList) {
         if (index > fruitList.size()){
             System.err.println("Error: Please enter a valid index > " + fruitList.size());

             return false;
         }

         return true;
    }

}
