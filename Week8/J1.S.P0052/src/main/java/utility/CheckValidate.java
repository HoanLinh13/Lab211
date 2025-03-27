package utility;

import model.EastAsiaCountries;
import java.util.List;

public class CheckValidate {
    public boolean checkMenu(int choice) {
        if (choice > 0 && choice <= 5)
            return true;
        else {
            System.err.println("Error: Please enter a number between 1 and 5!");
            return false;
        }
    }

    public boolean isCountryExists(List<EastAsiaCountries> countryList, String countryCode) {
        for (EastAsiaCountries country : countryList) {
            if (country.getCountryCode().equalsIgnoreCase(countryCode))
                return true;
            else {
                System.err.println("Country code " + countryCode + " is exists in list!");
                return false;
            }
        }
        return false;
    }
}
