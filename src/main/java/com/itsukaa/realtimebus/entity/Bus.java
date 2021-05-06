package com.itsukaa.realtimebus.entity;

public class Bus {
    /**
     * 公交车唯一标识
     */
    private String busId;
    /**
     * 公交车将要到达或以及到达的站台 距离 起点站台的站台数
     */
    private Integer busFromStartStationNum;
    /**
     * 公交车是否已经到达上述站台
     */
    private Boolean busIsArrived;
    /**
     * 公交车的位置
     */
    private Location location;
}
