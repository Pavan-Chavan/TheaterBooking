package com.theater.utils;

import com.theater.enumeration.AuditoriumName;
import com.theater.enumeration.AuditoriumTierName;
import com.theater.pojo.Auditorium;
import com.theater.pojo.AuditoriumTier;
import com.theater.pojo.Seat;
import com.theater.pojo.Theater;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class TheaterUtility {
    // audi 1
    private static final int AUDI1_PLATINUM_START = 1;
    private static final int AUDI1_GOLD_START = 1;
    private static final int AUDI1_SILVER_START = 2;

    private static final int AUDI1_PLATINUM_END = 9;
    private static final int AUDI1_GOLD_END = 6;
    private static final int AUDI1_SILVER_END = 7;

    // audi 2
    private static final int AUDI2_PLATINUM_START = 1;
    private static final int AUDI2_GOLD_START = 2;
    private static final int AUDI2_SILVER_START = 1;

    private static final int AUDI2_PLATINUM_END = 7;
    private static final int AUDI2_GOLD_END = 6;
    private static final int AUDI2_SILVER_END = 7;

    // audi 3
    private static final int AUDI3_PLATINUM_START = 1;
    private static final int AUDI3_GOLD_START = 1;
    private static final int AUDI3_SILVER_START = 1;

    private static final int AUDI3_PLATINUM_END = 7;
    private static final int AUDI3_GOLD_END = 8;
    private static final int AUDI3_SILVER_END = 9;

    // default values
    private static final int DEFAULT_END = 9;
    private static final int DEFAULT_START = 9;

    // tier to seat name
    private static final char PLATINUM = 'A';
    private static final char GOLD = 'B';
    private static final char SILVER = 'C';

    // tier to seat price
    private static final float PLATINUM_PRICE = 90;
    private static final float GOLD_PRICE = 70;
    private static final float SILVER_PRICE = 60;


    public static Theater createTheater() {
        Theater theater = new Theater();
        for(AuditoriumName auditoriumName: AuditoriumName.values()) {
            Auditorium auditorium = new Auditorium();
            auditorium.setShowName(getShowName(auditoriumName));
            for (AuditoriumTierName auditoriumTierName: AuditoriumTierName.values()) {
                AuditoriumTier auditoriumTier = new AuditoriumTier();
                auditoriumTier.setPrice(getPriceForTier(auditoriumTierName));
                auditoriumTier.setAuditoriumTierName(auditoriumTierName);
                int start = getStartIndex(auditoriumName,auditoriumTierName);
                int end = getEndIndex(auditoriumName,auditoriumTierName);
                for (int i=start; i<=end; i++) {
                    Seat seat = new Seat(getSeatNameFromAuditoriumTierName(auditoriumTierName,i),false);
                    auditoriumTier.getSeats().add(seat);
                }
                auditorium.getAuditoriumTierMap().put(auditoriumTierName,auditoriumTier);
            }
            theater.getAuditoriumMap().put(auditoriumName,auditorium);
        }
        return theater;
    }

    private static String getShowName(AuditoriumName auditoriumName) {
        switch (auditoriumName) {
            case AUDI1:
                return "Show 1";
            case AUDI2:
                return "Show 2";
            case AUDI3:
                return "Show 3";
            default:
                return "";
        }
    }

    private static float getPriceForTier(AuditoriumTierName auditoriumTierName) {
        switch (auditoriumTierName) {
            case PLATINUM:
                return PLATINUM_PRICE;
            case GLOD:
                return GOLD_PRICE;
            case SILVER:
                return SILVER_PRICE;
            default:
                return SILVER_PRICE;
        }
    }

    private static int getEndIndex(AuditoriumName auditoriumName, AuditoriumTierName auditoriumTierName) {
        if(auditoriumName == AuditoriumName.AUDI1) {
            switch (auditoriumTierName) {
                case PLATINUM:
                    return AUDI1_PLATINUM_END;
                case GLOD:
                    return AUDI1_GOLD_END;
                case SILVER:
                    return AUDI1_SILVER_END;
                default:
                    return DEFAULT_END;
            }
        } else if (auditoriumName == AuditoriumName.AUDI2) {
            switch (auditoriumTierName) {
                case PLATINUM:
                    return  AUDI2_PLATINUM_END;
                case GLOD:
                    return AUDI2_GOLD_END;
                case SILVER:
                    return AUDI2_SILVER_END;
                default:
                    return DEFAULT_END;
            }

        } else if (auditoriumName == AuditoriumName.AUDI3) {
            switch (auditoriumTierName) {
                case PLATINUM:
                    return  AUDI3_PLATINUM_END;
                case GLOD:
                    return AUDI3_GOLD_END;
                case SILVER:
                    return AUDI3_SILVER_END;
                default:
                    return DEFAULT_END;
            }
        }
        return DEFAULT_END;
    }

    private static int getStartIndex(AuditoriumName auditoriumName, AuditoriumTierName auditoriumTierName) {
        if(auditoriumName == AuditoriumName.AUDI1) {
            switch (auditoriumTierName) {
                case PLATINUM:
                    return AUDI1_PLATINUM_START;
                case GLOD:
                    return AUDI1_GOLD_START;
                case SILVER:
                    return AUDI1_SILVER_START;
                default:
                    return DEFAULT_START;
            }
        } else if (auditoriumName == AuditoriumName.AUDI2) {
            switch (auditoriumTierName) {
                case PLATINUM:
                    return AUDI2_PLATINUM_START;
                case GLOD:
                    return AUDI2_GOLD_START;
                case SILVER:
                    return AUDI2_SILVER_START;
                default:
                    return DEFAULT_START;
            }

        } else if (auditoriumName == AuditoriumName.AUDI3) {
            switch (auditoriumTierName) {
                case PLATINUM:
                    return AUDI3_PLATINUM_START;
                case GLOD:
                    return AUDI3_GOLD_START;
                case SILVER:
                    return AUDI3_SILVER_START;
                default:
                    return DEFAULT_START;
            }
        }
        return DEFAULT_START;
    }

    private static String getSeatNameFromAuditoriumTierName(AuditoriumTierName auditoriumTierName, int i) {
        switch (auditoriumTierName) {
            case PLATINUM:
                return PLATINUM + String.valueOf(i);
            case GLOD:
                return GOLD + String.valueOf(i);
            case SILVER:
                return SILVER + String.valueOf(i);
            default:
                return PLATINUM + String.valueOf(i);
        }
    }

    public static AuditoriumName getAuditorium(int auditoriumNo) {
        switch (auditoriumNo) {
            case 1:
                return AuditoriumName.AUDI1;
            case 2:
                return AuditoriumName.AUDI2;
            case 3:
                return AuditoriumName.AUDI3;
            default:
                return AuditoriumName.AUDI3;
        }
    }

    static AuditoriumTierName getAuditoriumTierFromSeatName(char tierChar) {
        switch (tierChar) {
            case PLATINUM:
                return AuditoriumTierName.PLATINUM;
            case GOLD:
                return AuditoriumTierName.GLOD;
            case SILVER:
                return AuditoriumTierName.SILVER;
            default:
                return AuditoriumTierName.SILVER;
        }
    }

}
