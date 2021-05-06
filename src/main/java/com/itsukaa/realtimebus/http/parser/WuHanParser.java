package com.itsukaa.realtimebus.http.parser;

import com.itsukaa.realtimebus.entity.Location;
import com.itsukaa.realtimebus.entity.Station;
import com.itsukaa.realtimebus.entity.bean.Res;
import com.itsukaa.realtimebus.entity.dto.RespoDto;
import com.itsukaa.realtimebus.entity.dto.StationDto;
import com.itsukaa.realtimebus.utils.JsonUtils;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WuHanParser {
    static private final OkHttpClient client = new OkHttpClient();

    public static Res getNearByStationsByLocation(Location location) throws IOException {
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

            //TODO: 将该公交车站的线路注入station
            //...
        }
        return new Res(200, "ok", stations);
    }
}
