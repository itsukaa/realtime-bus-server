package com.itsukaa.realtimebus.entity.dto;

import java.util.List;

public class StationDto {
    String i;
    String n;
    String j;
    String w;
    List<LineDto> lineDtos;

    public StationDto() {
    }

    public StationDto(String i, String n, String j, String w, List<LineDto> lineDtos) {
        this.i = i;
        this.n = n;
        this.j = j;
        this.w = w;
        this.lineDtos = lineDtos;
    }

    public String getI() {
        return i;
    }

    public void setI(String i) {
        this.i = i;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public String getJ() {
        return j;
    }

    public void setJ(String j) {
        this.j = j;
    }

    public String getW() {
        return w;
    }

    public void setW(String w) {
        this.w = w;
    }

    public List<LineDto> getLineDtos() {
        return lineDtos;
    }

    public void setLineDtos(List<LineDto> lineDtos) {
        this.lineDtos = lineDtos;
    }

    @Override
    public String toString() {
        return "StationDto{" +
                "i='" + i + '\'' +
                ", n='" + n + '\'' +
                ", j='" + j + '\'' +
                ", w='" + w + '\'' +
                ", lineDtos=" + lineDtos +
                '}';
    }
}
