package com.itsukaa.realtimebus.controller;

import com.itsukaa.realtimebus.entity.Location;
import com.itsukaa.realtimebus.entity.bean.Res;
import com.itsukaa.realtimebus.http.parser.api.BusParser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class MainController {

    BusParser busParser = new BusParser();

    @GetMapping(value = "/stations/nearBy")
    public Res getNearByStations(@RequestBody Location location) throws IOException {

        return busParser.getNearByStationsByLocation(location);
    }

}
