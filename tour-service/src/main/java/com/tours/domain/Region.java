package com.tours.domain;

public enum Region {
    Nordic_Countries("Nordic Countries"), Eastern_Europe ("Eastern Europe"),
    Central_Europe("Central Europe"), Southern_Europe ("Southern Europe"),
    Western_Europe("Western Europe"), British_Isles("British Isles"), Baltics ("Baltics");
    public final String label;
    private Region(String label){

        this.label = label;
    }

    public static Region findByLabel(String aLabel){
        for (Region r : values()){
            if (r.label.equalsIgnoreCase(aLabel)){
                return r;
            }
        }
        return null;
    }


}
