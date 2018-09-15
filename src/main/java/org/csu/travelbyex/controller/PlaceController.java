package org.csu.travelbyex.controller;


import io.swagger.annotations.ApiOperation;
import org.csu.travelbyex.core.Result;
import org.csu.travelbyex.core.ResultGenerator;
import org.csu.travelbyex.domain.LargePlace;
import org.csu.travelbyex.domain.ScenicSpot;
import org.csu.travelbyex.domain.SmallPlace;
import org.csu.travelbyex.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class PlaceController {

    @Autowired
    SpotService spotService;

    @ApiOperation(value = "根据地点名搜索地点信息")
    @GetMapping("/appointmentsByPlace")
    public Result getPlaceByPlaceName(@RequestParam(value = "placeName") String placeName)
    {
        Map message = new LinkedHashMap();
        LargePlace largePlace = spotService.getLPByName(placeName);
        List<SmallPlace> smallPlaces = new ArrayList<>();
        List<ScenicSpot> scenicSpots = new ArrayList<>();
        if (largePlace != null) // 名字是大地点
        {
            smallPlaces = spotService.getSPsByLPid(largePlace.getLpId());
            for (SmallPlace smallPlace:
                 smallPlaces) {
                List<ScenicSpot> scenicSpots1 = spotService.getScenicSpotsBySPid(smallPlace.getSpId());
                scenicSpots.addAll(scenicSpots1);
            }
        }else {
            SmallPlace smallPlace = spotService.getSPByName(placeName);
            if(smallPlace != null) // 名字是小地点
            {
                smallPlaces.add(smallPlace);
                scenicSpots = spotService.getScenicSpotsBySPid(smallPlace.getSpId());
            }
            else // 名字是景点
            {
                ScenicSpot scenicSpot = spotService.getScenicSpotByName(placeName);
                if (scenicSpot != null)
                    scenicSpots.add(scenicSpot);
            }
        }
        if (largePlace == null && smallPlaces.size() == 0 && scenicSpots.size() == 0)
            return ResultGenerator.success("该地点信息暂未收录！");
        message.put("largePlace",largePlace);
        message.put("smallPlaces",smallPlaces);
        message.put("spots",scenicSpots);
        return ResultGenerator.fail(message);
    }

}
