package com.example.android.quakereport;

public class EarthQuake {
    private Double eMagnitude;
    private String eLocation;
    private Long eDate;

    /*
     * Create a new AndroidFlavor object.
     *
     * @param vName is the name of the Android version (e.g. Gingerbread)
     * @param vNumber is the corresponding Android version number (e.g. 2.3-2.7)
     * @param image is drawable reference ID that corresponds to the Android version
     * */
    public EarthQuake(Double magnitude, String location, Long date)
    {
        eMagnitude = magnitude;
        eLocation = location;
        eDate = date;
    }

    /**
     * Get the Magnitude
     */
    public Double getMagnitude() {
        return eMagnitude;
    }

    /**
     * Get the Location
     */
    public String getLocation() {
        return eLocation;
    }

    /**
     * Get the Date value
     */
    public Long getDate() {
        return eDate;
    }


}
