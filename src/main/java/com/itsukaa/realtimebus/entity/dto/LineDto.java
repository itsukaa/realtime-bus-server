package com.itsukaa.realtimebus.entity.dto;

public class LineDto {
    public LineDto() {
    }
    String ln;
    String l0i;
    String l0ns;
    String l0es;
    String l0nb;
    String l0at;
    String l1i;
    String l1ns;
    String l1es;
    String l1nb;
    String l1at;

    public LineDto(String ln, String l0i, String l0ns, String l0es, String l0nb, String l0at, String l1i, String l1ns, String l1es, String l1nb, String l1at) {
        this.ln = ln;
        this.l0i = l0i;
        this.l0ns = l0ns;
        this.l0es = l0es;
        this.l0nb = l0nb;
        this.l0at = l0at;
        this.l1i = l1i;
        this.l1ns = l1ns;
        this.l1es = l1es;
        this.l1nb = l1nb;
        this.l1at = l1at;
    }


    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getL0i() {
        return l0i;
    }

    public void setL0i(String l0i) {
        this.l0i = l0i;
    }

    public String getL0ns() {
        return l0ns;
    }

    public void setL0ns(String l0ns) {
        this.l0ns = l0ns;
    }

    public String getL0es() {
        return l0es;
    }

    public void setL0es(String l0es) {
        this.l0es = l0es;
    }

    public String getL0nb() {
        return l0nb;
    }

    public void setL0nb(String l0nb) {
        this.l0nb = l0nb;
    }

    public String getL0at() {
        return l0at;
    }

    public void setL0at(String l0at) {
        this.l0at = l0at;
    }

    public String getL1i() {
        return l1i;
    }

    public void setL1i(String l1i) {
        this.l1i = l1i;
    }

    public String getL1ns() {
        return l1ns;
    }

    public void setL1ns(String l1ns) {
        this.l1ns = l1ns;
    }

    public String getL1es() {
        return l1es;
    }

    public void setL1es(String l1es) {
        this.l1es = l1es;
    }

    public String getL1nb() {
        return l1nb;
    }

    public void setL1nb(String l1nb) {
        this.l1nb = l1nb;
    }

    public String getL1at() {
        return l1at;
    }

    public void setL1at(String l1at) {
        this.l1at = l1at;
    }

    @Override
    public String toString() {
        return "LineDto{" +
                "ln='" + ln + '\'' +
                ", l0i='" + l0i + '\'' +
                ", l0ns='" + l0ns + '\'' +
                ", l0es='" + l0es + '\'' +
                ", l0nb='" + l0nb + '\'' +
                ", l0at='" + l0at + '\'' +
                ", l1i='" + l1i + '\'' +
                ", l1ns='" + l1ns + '\'' +
                ", l1es='" + l1es + '\'' +
                ", l1nb='" + l1nb + '\'' +
                ", l1at='" + l1at + '\'' +
                '}';
    }
}
