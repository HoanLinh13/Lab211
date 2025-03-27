package model;

import java.util.Objects;

public class Country implements Comparable<Country> {
    protected String countryCode;
    protected String countryName;
    protected float totalArea;

    public Country() {
        this.countryCode = "";
        this.countryName = "";
        this.totalArea = 0;
    }

    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public float getTotalArea() {
        return totalArea;
    }

    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Country country = (Country) obj;
        return countryCode.equalsIgnoreCase(country.countryCode);
    }

    @Override
    public int hashCode() {
        return countryCode.toLowerCase().hashCode();
    }


    @Override
    public int compareTo(Country o) {
        return this.countryName.compareTo(o.countryName); // Sắp xếp theo tên quốc gia

    }

    @Override
    public String toString() {
        return countryCode + " - " + countryName + " - " + totalArea ;
    }
}

