package com.turbo.app.turbovpnpro.Models;

public class CountryChildModel {
    String cityname;
    private boolean isChecked;

    public CountryChildModel(String cityname, boolean isChecked) {
        this.cityname = cityname;
        this.isChecked = isChecked;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
