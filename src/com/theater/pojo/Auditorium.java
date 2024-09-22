package com.theater.pojo;

import com.theater.enumeration.AuditoriumTierName;

import java.util.HashMap;
import java.util.Map;

public class Auditorium {
    Map<AuditoriumTierName,AuditoriumTier> auditoriumTierMap= new HashMap<>();
    String showName;

    public String getShowName() {
        return showName;
    }

    public void setShowName(String showName) {
        this.showName = showName;
    }

    public Auditorium(Map<AuditoriumTierName, AuditoriumTier> auditoriumTierMap) {
        this.auditoriumTierMap = auditoriumTierMap;
    }

    public Auditorium() {
    }

    public Map<AuditoriumTierName, AuditoriumTier> getAuditoriumTierMap() {
        return auditoriumTierMap;
    }

    public void setAuditoriumTierMap(Map<AuditoriumTierName, AuditoriumTier> auditoriumTierMap) {
        this.auditoriumTierMap = auditoriumTierMap;
    }
}
