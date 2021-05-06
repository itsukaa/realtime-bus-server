package com.itsukaa.realtimebus.entity;

import java.util.List;

public class Station {
    /**
     * 站台位置
     */
    private Location stationLocation;

    /**
     * 站台唯一标识
     */
    private String stationId;

    /**
     * 站台名称
     */
    private String stationName;

    /**
     * 站台线路
     */
    private List<Line> stationLines;


    public Location getStationLocation() {
        return stationLocation;
    }

    public void setStationLocation(Location stationLocation) {
        this.stationLocation = stationLocation;
    }

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public List<Line> getStationLines() {
        return stationLines;
    }

    public void setStationLines(List<Line> stationLines) {
        this.stationLines = stationLines;
    }
}
