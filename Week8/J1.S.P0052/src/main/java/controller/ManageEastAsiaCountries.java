package controller;

import model.Country;
import model.EastAsiaCountries;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ManageEastAsiaCountries {
    private List<EastAsiaCountries> countryList = new ArrayList<EastAsiaCountries>();
    private EastAsiaCountries latestCountry = null; // Lưu quốc gia mới nhập

    public void addCountryInformation(EastAsiaCountries countries) {
        if (!countryList.contains(countries)) {
            countryList.add(countries);
            latestCountry = countries; // Cập nhật chỉ số mới nhất
        } else
            System.out.println("Country already exists!");

    }

    public EastAsiaCountries getRecentlyEnteredInformation() {
        return latestCountry;
    }

    public EastAsiaCountries searchInformationByName(String name){
        for (EastAsiaCountries country : countryList) {
            if (name.equalsIgnoreCase(country.getCountryName())){
                return country;
            }
        }
        return null;
    }

    public void sortInformationByAscendingOrder() {
        Collections.sort(countryList, Comparator.comparing(EastAsiaCountries::getCountryName));
        displayInformation();
    }

    private void displayInformation() {
        System.out.println("ID - Name - Total Area - Terrain");
        for (EastAsiaCountries country : countryList) {
            System.out.println(country);
        }
    }

    public List<EastAsiaCountries> getCountryList() {
        return countryList;
    }

    public void setCountryList(List<EastAsiaCountries> countryList) {
        this.countryList = countryList;
    }
}
