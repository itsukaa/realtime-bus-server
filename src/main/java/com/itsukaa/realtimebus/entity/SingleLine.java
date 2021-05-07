package com.itsukaa.realtimebus.entity;

import lombok.Data;

import java.util.List;

@Data
public class SingleLine {

    private String singleLineId;

    private String singleLineName;

    private String singleLineNo;

    private String singleLineDirection;

    private String singleLineStartStationName;

    private String singleLineEndStationName;

    private String singleLineStartTime;

    private String singleLineEndTime;

    private String singleLinePrice;

    private String returnSingleLineId;

    private List<Bus> singleLineBuses;

    private List<Station> singleLineStations;
}
