package com.itsukaa.realtimebus.http.parser;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.itsukaa.realtimebus.entity.Line;
import com.itsukaa.realtimebus.entity.Location;
import com.itsukaa.realtimebus.entity.SingleLine;
import com.itsukaa.realtimebus.entity.Station;
import com.itsukaa.realtimebus.entity.bean.Res;
import com.itsukaa.realtimebus.entity.dto.RespoDto;
import com.itsukaa.realtimebus.entity.dto.StationDto;
import com.itsukaa.realtimebus.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Slf4j
public class WuHanParser {
    static private final OkHttpClient client = new OkHttpClient();

    public static Res getNearByStationsByLocation(Location location) throws IOException, JsonMappingException {
        String url = "http://androidbus.wuhancloud.cn:9087/app/v5/420100/nearby/" +
                location.getLongitude() + "/" + location.getLatitude() + ".do";

        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        Call call = client.newCall(request);
        Response response = call.execute();
        String resBody = response.body().string();
        RespoDto respoDto = JsonUtils.jsonToRespoDto(resBody);
        response.close();

        List<StationDto> stationDtos = respoDto.getData();
        List<Station> stations = new ArrayList<>(stationDtos.size());

        for (StationDto stationDto : stationDtos) {

            Station station = new Station();
            station.setStationId(stationDto.getI());
            station.setStationLocation(new Location(stationDto.getJ(), stationDto.getW(), "武汉"));
            station.setStationName(stationDto.getN());

            final List<Line> lines = (List<Line>) getLinesByStationId(station.getStationId()).getRes();

            station.setStationLines(lines);
            stations.add(station);
        }
        return new Res(200, "ok", stations);
    }

    //List<Line>
    public static Res getLinesByStationId(String stationId) throws IOException {
        List<Line> lines = new ArrayList<>();
        String stationUrl =
                "http://bus.wuhancloud.cn:9087/website/web/420100/stop/"
                        + stationId + ".do";
        Request request = new Request.Builder()
                .get()
                .url(stationUrl)
                .build();
        Call call = client.newCall(request);
        String resBody = call.execute().body().string();
        List<String> lineIds = JsonUtils.getLineIdsFromJsonStr(resBody);

        for (String lineId : lineIds) {
            String lineUrl = "http://bus.wuhancloud.cn:9087/website/web/420100/line/" + lineId
                    + ".do?Type=LineDetail";
            Request lineRequest = new Request.Builder()
                    .get()
                    .url(lineUrl)
                    .build();
            Call lineCall = client.newCall(lineRequest);
            String lineResBody = lineCall.execute().body().string();

            SingleLine singleLine = JsonUtils.jsonStrToSingleLine(lineResBody);
            String returnLineUrl = "http://bus.wuhancloud.cn:9087/website/web/420100/line/" + singleLine.getReturnSingleLineId()
                    + ".do?Type=LineDetail";
            Request returnLineRequest = new Request.Builder()
                    .get()
                    .url(returnLineUrl)
                    .build();
            Call returnLineCall = client.newCall(returnLineRequest);
            String returnLineResBody = returnLineCall.execute().body().string();

            SingleLine returnSingleLine = JsonUtils.jsonStrToSingleLine(returnLineResBody);

            Line line = new Line(singleLine, returnSingleLine);

            lines.add(line);
        }
        log.warn(String.valueOf(lines));
        return new Res(200, "ok", lines);
    }

    public static Res getBusesByLineId(String lineId) throws IOException {
        String lineUrl = "http://bus.wuhancloud.cn:9087/website/web/420100/line/" + lineId
                + ".do?Type=LineDetail";
        Request lineRequest = new Request.Builder()
                .get()
                .url(lineUrl)
                .build();
        Call lineCall = client.newCall(lineRequest);
        String lineResBody = lineCall.execute().body().string();

        SingleLine singleLine = JsonUtils.jsonStrToSingleLine(lineResBody);

        return new Res(200, "ok", singleLine.getSingleLineBuses());
    }
}
