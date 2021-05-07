package com.itsukaa.realtimebus.http.parser.api;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.itsukaa.realtimebus.entity.Location;
import com.itsukaa.realtimebus.entity.bean.G;
import com.itsukaa.realtimebus.entity.bean.Res;
import com.itsukaa.realtimebus.http.parser.WuHanParser;

import java.io.IOException;

public class BusParser {
    public Res getNearByStationsByLocation(Location location) throws IOException, JsonMappingException {
        if (!G.cityNames.contains(location.getCityName())) {
            return new Res(-1, "城市不存在", null);
        }

        if (location.getCityName().equals("武汉")) {
            return WuHanParser.getNearByStationsByLocation(location);
        }


        return null;
    }

    public Res getLinesByStationId(String stationId) throws IOException {

        return WuHanParser.getLinesByStationId(stationId);
    }

    public Res getBusesByLineId(String lineId) throws IOException {
        return WuHanParser.getBusesByLineId(lineId);
    }
}
