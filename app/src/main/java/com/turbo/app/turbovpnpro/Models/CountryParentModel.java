package com.turbo.app.turbovpnpro.Models;

public class CountryParentModel {
    String countryName;
    String locationCount;


    public CountryParentModel(String countryName, String locationCount) {
        this.countryName = countryName;
        this.locationCount = locationCount;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getLocationCount() {
        return locationCount;
    }

    public void setLocationCount(String locationCount) {
        this.locationCount = locationCount;
    }
}
