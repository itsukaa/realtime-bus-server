package com.itsukaa.realtimebus.entity;

import java.util.List;

public class Line {
    //基础信息

    /**
     * 线路朴实名称
     */
    private String lineName;
    /**
     * 线路价格
     */
    private String linePrice;
    /**
     * 线路被搜索时所在的站点
     */
    private Station lineSearchStation;
    /**
     * 线路运营开始时间
     */
    private String lineBeginTime;
    /**
     * 线路运营结束时间
     */
    private String lineEndTime;
    /**
     * 线路运营公司
     */
    private String lineCompany;

    //方向0
    /**
     * 线路唯一标识
     */
    private String line0Id;

    /**
     * 线路名称
     */
    private String line0Name;

    /**
     * 线路始发站名称
     */
    private String line0StartStationName;

    /**
     * 线路终点站名称
     */
    private String line0EndStationName;

    /**
     * 线路公交车列表
     */
    private List<Bus> line0Buses;

    /**
     * 线路公交车站
     */
    private List<Station> line0Stations;

    /**
     * 线路剩余到达时间
     */
    private String line0ArrivedRemainTime;


    //方向1
    /**
     * 线路唯一标识
     */
    private String line1Id;

    /**
     * 线路名称
     */
    private String line1Name;

    /**
     * 线路始发站名称
     */
    private String line1StartStationName;

    /**
     * 线路终点站名称
     */
    private String line1EndStationName;

    /**
     * 线路公交车列表
     */
    private List<Bus> line1Buses;

    /**
     * 线路公交车站
     */
    private List<Station> line1Stations;

    /**
     * 线路剩余到达时间
     */
    private String line1ArrivedRemainTime;
}
