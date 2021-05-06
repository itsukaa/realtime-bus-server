package com.itsukaa.realtimebus.http.parser.api;

import com.itsukaa.realtimebus.entity.Location;
import com.itsukaa.realtimebus.entity.bean.G;
import com.itsukaa.realtimebus.entity.bean.Res;
import com.itsukaa.realtimebus.http.parser.WuHanParser;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class BusParser {
    public Res getNearByStationsByLocation(Location location) throws IOException {
        if (!G.cityNames.contains(location.getCityName())) {
            return new Res(-1, "城市不存在", null);
        }

        if (location.getCityName().equals("武汉")) {
            return WuHanParser.getNearByStationsByLocation(location);
        }


        return null;
    }
}
