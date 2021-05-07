package com.itsukaa.realtimebus.entity;

import lombok.Data;

import java.util.List;


@Data
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

}
