package com.theater.pojo;

import com.theater.enumeration.AuditoriumName;
import com.theater.enumeration.AuditoriumTierName;

import java.util.HashMap;
import java.util.Map;

public class Theater {
    Map<AuditoriumName,Auditorium> auditoriumMap = new HashMap<>();
    public Theater () {
    }

    public Map<AuditoriumName, Auditorium> getAuditoriumMap() {
        return auditoriumMap;
    }

    public void setAuditoriumMap(Map<AuditoriumName, Auditorium> auditoriumMap) {
        this.auditoriumMap = auditoriumMap;
    }
}
