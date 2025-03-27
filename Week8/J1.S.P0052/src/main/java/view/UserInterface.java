package view;

import controller.ManageEastAsiaCountries;
import model.EastAsiaCountries;
import utility.CheckValidate;

import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);
    CheckValidate validate = new CheckValidate();
    ManageEastAsiaCountries mea = new ManageEastAsiaCountries();
    CheckValidate valid = new CheckValidate();

    private int menu(){
        System.out.println("\n=== MENU ===");
        System.out.println("1. Input the information of 11 countries in East Asia");
        System.out.println("2. Display the information of country you've just input");
        System.out.println("3. Search the information of country by user-entered name");
        System.out.println("4. Display the information of countries sorted name in ascending order");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        validate.checkMenu(choice);
        return choice;
    }

    public void start(){
        while(true){
            switch(menu()){
                case 1:
                    String countryCode;
                    do {
                        System.out.println("Enter code of country: ");
                        countryCode = scanner.nextLine();
                    }while(validate.isCountryExists(mea.getCountryList(), countryCode));

                    System.out.println("Enter name of country: ");
                    String countryName = scanner.nextLine();
                    System.out.println("Enter total Area: ");
                    float totalArea = scanner.nextFloat();
                    scanner.nextLine();
                    System.out.println("Enter terrain of country: ");
                    String terrain = scanner.nextLine();

                    EastAsiaCountries eastAsiaCountries = new EastAsiaCountries(countryCode, countryName, totalArea, terrain);
                    mea.addCountryInformation(eastAsiaCountries);

                    break;
                case 2:
                    System.out.println(mea.getRecentlyEnteredInformation());

                    break;
                case 3:
                    System.out.println("Enter the name you want to search for: ");
                    String name = scanner.nextLine();

                    System.out.println(mea.searchInformationByName(name));

                    break;
                case 4:
                    mea.sortInformationByAscendingOrder();

                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
