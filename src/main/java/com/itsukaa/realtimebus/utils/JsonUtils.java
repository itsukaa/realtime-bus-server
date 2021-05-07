package com.itsukaa.realtimebus.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsukaa.realtimebus.entity.Bus;
import com.itsukaa.realtimebus.entity.Location;
import com.itsukaa.realtimebus.entity.SingleLine;
import com.itsukaa.realtimebus.entity.Station;
import com.itsukaa.realtimebus.entity.dto.LineDto;
import com.itsukaa.realtimebus.entity.dto.RespoDto;
import com.itsukaa.realtimebus.entity.dto.StationDto;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class JsonUtils {
    public static RespoDto jsonToRespoDto(String json) throws JsonProcessingException {
        RespoDto respoDto = new RespoDto();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(json);
        String resultCode = rootNode.get("resultCode") != null ? rootNode.get("resultCode").asText() : "";
        String resultDes = rootNode.get("resultDes") != null ? rootNode.get("resultDes").asText() : "";
        respoDto.setResultCode(resultCode);
        respoDto.setResultDes(resultDes);

        if (rootNode.get("data") != null && rootNode.get("data").size() > 0) {
            List<StationDto> data = new ArrayList<>();
            StationDto stationDto = new StationDto();

            JsonNode dataNode = rootNode.get("data");
            for (int i = 0; i < dataNode.size(); i++) {
                stationDto.setI(dataNode.get(i).get("i") != null ? dataNode.get(i).get("i").asText() : "");
                stationDto.setN(dataNode.get(i).get("n") != null ? dataNode.get(i).get("n").asText() : "");
                stationDto.setJ(dataNode.get(i).get("j") != null ? dataNode.get(i).get("j").asText() : "");
                stationDto.setW(dataNode.get(i).get("w") != null ? dataNode.get(i).get("w").asText() : "");

                List<LineDto> lineDtos = new ArrayList<>();
                if (dataNode.get(i).get("l") != null && dataNode.get(i).get("l").size() > 0) {
                    JsonNode lineNode = dataNode.get(i).get("l");
                    for (int j = 0; j < lineNode.size(); j++) {
                        lineDtos.add(jsonNodeToLineDto(lineNode.get(j)));
                    }
                }
                stationDto.setLineDtos(lineDtos);
                data.add(stationDto);
                stationDto = new StationDto();
            }
            respoDto.setData(data);
        }

        return respoDto;
    }


    public static SingleLine jsonStrToSingleLine(String jsonStr) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        final JsonNode jsonNode = mapper.readTree(jsonStr);
        final JsonNode rootNode = jsonNode.get("data");
        SingleLine singleLine = new SingleLine();

        singleLine.setSingleLineId(rootNode.get("lineId") != null ? rootNode.get("lineId").asText() : "");
        singleLine.setSingleLineNo(rootNode.get("lineNo") != null ? rootNode.get("lineNo").asText() : "");
        singleLine.setSingleLineName(rootNode.get("lineName") != null ? rootNode.get("lineName").asText() : "");
        singleLine.setSingleLineDirection(rootNode.get("direction") != null ? rootNode.get("direction").asText() : "");
        singleLine.setSingleLineStartStationName(rootNode.get("startStopName") != null ? rootNode.get("startStopName").asText() : "");
        singleLine.setSingleLineEndStationName(rootNode.get("endStopName") != null ? rootNode.get("endStopName").asText() : "");
        singleLine.setSingleLineStartTime(rootNode.get("firstTime") != null ? rootNode.get("firstTime").asText() : "");
        singleLine.setSingleLineEndTime(rootNode.get("lastTime") != null ? rootNode.get("lastTime").asText() : "");
        singleLine.setSingleLinePrice(rootNode.get("price") != null ? rootNode.get("price").asText() : "");
        singleLine.setReturnSingleLineId(rootNode.get("line2Id") != null ? rootNode.get("line2Id").asText() : "");
        //解析站台
        final JsonNode stopsNode = rootNode.get("stops");
        List<Station> stations = new ArrayList<>();
        if (stopsNode != null && stopsNode.size() > 0) {
            for (int i = 0; i < stopsNode.size(); i++) {
                Station station = new Station();
                station.setStationId(stopsNode.get(i).get("stopId").asText());
                station.setStationName(stopsNode.get(i).get("stopName").asText());
                stations.add(station);
            }
        }
        singleLine.setSingleLineStations(stations);

        //解析公交
        final JsonNode busesNode = rootNode.get("buses");
        List<Bus> buses = new ArrayList<>();
        if (busesNode != null && busesNode.size() > 0) {
            for (int i = 0; i < busesNode.size(); i++) {
                Bus bus = new Bus();
                final String text = busesNode.get(i).asText();
                final String[] info = text.split("\\|");
                bus.setBusId(info[0]);
                bus.setBusFlag(info[1]);
                bus.setBusFromStartStationNum(Integer.valueOf(info[2]));
                bus.setBusIsArrived("1".equals(info[3]));
                bus.setLocation(new Location(info[4], info[5], "武汉"));
                buses.add(bus);
            }
        }
        singleLine.setSingleLineBuses(buses);
        return singleLine;
    }


    public static LineDto jsonNodeToLineDto(JsonNode rootNode) {
        LineDto lineDto = new LineDto();
        lineDto.setLn(rootNode.get("n") != null ? rootNode.get("n").asText() : "");
        lineDto.setL0i(rootNode.get("0i") != null ? rootNode.get("0i").asText() : "");
        lineDto.setL0ns(rootNode.get("0ns") != null ? rootNode.get("0ns").asText() : "");
        lineDto.setL0es(rootNode.get("0es") != null ? rootNode.get("0es").asText() : "");
        lineDto.setL0nb(rootNode.get("0nb") != null ? rootNode.get("0nb").asText() : "");
        lineDto.setL0at(rootNode.get("0at") != null ? rootNode.get("0at").asText() : "");
        lineDto.setL1i(rootNode.get("1i") != null ? rootNode.get("1i").asText() : "");
        lineDto.setL1ns(rootNode.get("1ns") != null ? rootNode.get("1ns").asText() : "");
        lineDto.setL1es(rootNode.get("1es") != null ? rootNode.get("1es").asText() : "");
        lineDto.setL1nb(rootNode.get("1nb") != null ? rootNode.get("1nb").asText() : "");
        lineDto.setL1at(rootNode.get("1at") != null ? rootNode.get("1at").asText() : "");


        return lineDto;
    }


    public static List<String> getLineIdsFromJsonStr(String jsonStr) throws JsonProcessingException {
        List<String> lineIds = new ArrayList<>();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode rootNode = mapper.readTree(jsonStr);
        if (rootNode.get("data") != null
                && rootNode.get("data").get("lines") != null
                && rootNode.get("data").get("lines").size() > 0) {
            JsonNode jsonNode = rootNode.get("data").get("lines");
            for (int i = 0; i < jsonNode.size(); i++) {
                if (jsonNode.get(i).get("line0Id") == null) continue;
                lineIds.add(jsonNode.get(i).get("line0Id").asText());
            }
        }

        return lineIds;
    }
}
