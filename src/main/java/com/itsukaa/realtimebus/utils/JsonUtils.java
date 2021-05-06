package com.itsukaa.realtimebus.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.itsukaa.realtimebus.entity.dto.LineDto;
import com.itsukaa.realtimebus.entity.dto.RespoDto;
import com.itsukaa.realtimebus.entity.dto.StationDto;

import java.util.ArrayList;
import java.util.List;

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
            System.out.println("data不为空");
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
                    System.out.println("line不为空");
                    JsonNode lineNode = dataNode.get(i).get("l");
                    for (int j = 0; j < lineNode.size(); j++) {
                        LineDto lineDto = new LineDto();
                        lineDto.setLn(lineNode.get(j).get("n") != null ? lineNode.get(j).get("n").asText() : "");
                        lineDto.setL0i(lineNode.get(j).get("0i") != null ? lineNode.get(j).get("0i").asText() : "");
                        lineDto.setL0ns(lineNode.get(j).get("0ns") != null ? lineNode.get(j).get("0ns").asText() : "");
                        lineDto.setL0es(lineNode.get(j).get("0es") != null ? lineNode.get(j).get("0es").asText() : "");
                        lineDto.setL0nb(lineNode.get(j).get("0nb") != null ? lineNode.get(j).get("0nb").asText() : "");
                        lineDto.setL0at(lineNode.get(j).get("0at") != null ? lineNode.get(j).get("0at").asText() : "");
                        lineDto.setL1i(lineNode.get(j).get("1i") != null ? lineNode.get(j).get("1i").asText() : "");
                        lineDto.setL1ns(lineNode.get(j).get("1ns") != null ? lineNode.get(j).get("1ns").asText() : "");
                        lineDto.setL1es(lineNode.get(j).get("1es") != null ? lineNode.get(j).get("1es").asText() : "");
                        lineDto.setL1nb(lineNode.get(j).get("1nb") != null ? lineNode.get(j).get("1nb").asText() : "");
                        lineDto.setL1at(lineNode.get(j).get("1at") != null ? lineNode.get(j).get("1at").asText() : "");

                        lineDtos.add(lineDto);
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
}
