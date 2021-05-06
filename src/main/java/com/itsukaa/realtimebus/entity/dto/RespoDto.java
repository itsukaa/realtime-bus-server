package com.itsukaa.realtimebus.entity.dto;

import java.util.List;

public class RespoDto {
    String resultCode;
    String resultDes;
    List<StationDto> data;

    public RespoDto() {
    }

    public RespoDto(String resultCode, String resultDes, List<StationDto> stationDtos) {
        this.resultCode = resultCode;
        this.resultDes = resultDes;
        this.data = stationDtos;
    }


    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultDes() {
        return resultDes;
    }

    public void setResultDes(String resultDes) {
        this.resultDes = resultDes;
    }

    public List<StationDto> getData() {
        return data;
    }

    @Override
    public String toString() {
        return "RespoDto{" +
                "resultCode='" + resultCode + '\'' +
                ", resultDes='" + resultDes + '\'' +
                ", data=" + data +
                '}';
    }

    public void setData(List<StationDto> data) {
        this.data = data;
    }
}
