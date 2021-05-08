package com.itsukaa.realtimebus.controller;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.itsukaa.realtimebus.entity.Location;
import com.itsukaa.realtimebus.entity.bean.Res;
import com.itsukaa.realtimebus.http.parser.api.BusParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@Slf4j
@RestController
public class MainController {

    BusParser busParser = new BusParser();

    @PostMapping(value = "/stations/nearBy")
    public Res getNearByStations(@RequestBody Location location) throws IOException, JsonMappingException {
        log.warn(location.toString());

        final Res res = busParser.getNearByStationsByLocation(location);
        log.warn("数据返回");
        return res;
    }

    @PostMapping(value = "/lines/{stationId}")
    public Res getLinesByStationId(@PathVariable String stationId) throws IOException {
        return busParser.getLinesByStationId(stationId);
    }

    @PostMapping(value = "/buses/{lineId}")
    public Res getBusesByLineId(@PathVariable String lineId) throws IOException {
        return busParser.getBusesByLineId(lineId);
    }
}
