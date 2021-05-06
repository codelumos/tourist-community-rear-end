package org.csu.travel.controller;


import io.swagger.annotations.ApiOperation;
import org.csu.travel.core.Result;
import org.csu.travel.core.ResultGenerator;
import org.csu.travel.domain.LargePlace;
import org.csu.travel.domain.ScenicSpot;
import org.csu.travel.domain.SmallPlace;
import org.csu.travel.service.SpotService;
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

    @ApiOperation(value = "根据地点名搜索地点及其下属地点信息")
    @GetMapping("/placesByKeyword")
    public Result getPlaceByPlaceName(@RequestParam(value = "placeName") String placeName) {
        Map message = new LinkedHashMap();
        LargePlace largePlace = spotService.getLPByName(placeName);
        List<SmallPlace> smallPlaces = new ArrayList<>();
        List<ScenicSpot> scenicSpots = new ArrayList<>();
        if (largePlace != null) { // 名字是大地点
            smallPlaces = spotService.getSPsByLPid(largePlace.getLpId());
            for (SmallPlace smallPlace :
                    smallPlaces) {
                List<ScenicSpot> scenicSpots1 = spotService.getScenicSpotsBySPid(smallPlace.getSpId());
                scenicSpots.addAll(scenicSpots1);
            }
        } else {
            SmallPlace smallPlace = spotService.getSPByName(placeName);
            if (smallPlace != null) // 名字是小地点
            {
                smallPlaces.add(smallPlace);
                scenicSpots = spotService.getScenicSpotsBySPid(smallPlace.getSpId());
            } else { // 名字是景点
                ScenicSpot scenicSpot = spotService.getScenicSpotByName(placeName);
                if (scenicSpot != null)
                    scenicSpots.add(scenicSpot);
            }
        }
        if (largePlace == null && smallPlaces.size() == 0 && scenicSpots.size() == 0)
            return ResultGenerator.success(null);
        message.put("largePlace", largePlace);
        message.put("smallPlaces", smallPlaces);
        message.put("spots", scenicSpots);

        return ResultGenerator.success(message);
    }


    @ApiOperation(value = "根据条件获取全部大地点", notes = "flag为0搜索国外，为1搜索国内，为2搜索全部")
    @GetMapping("/allLargePlaces")
    public Result getAllLps(@RequestParam(value = "flag") Integer flag) {
        List<LargePlace> largePlaces = new ArrayList<>();
        switch (flag) {
            case 0:
                largePlaces = spotService.getLPs(false);
                break;
            case 1:
                largePlaces = spotService.getLPs(true);
                break;
            case 2:
                largePlaces = spotService.getLPs(false);
                List<LargePlace> largePlaces1 = spotService.getLPs(true);
                largePlaces.addAll(largePlaces1);
            default:
                break;
        }
        if (largePlaces.size() == 0)
            return ResultGenerator.fail("搜索无结果");
        return ResultGenerator.success(largePlaces);
    }


    @ApiOperation(value = "根据大地点名搜索大地点（模糊查询）")
    @GetMapping("/largePlacesByName")
    public Result getLargePlacesByName(@RequestParam(value = "lpName") String lpName) {
        lpName = lpName + "%";
        List<LargePlace> largePlaces = spotService.getLPsByName(lpName);
        if (largePlaces.size() == 0)
            return ResultGenerator.fail("无此大地点！");

        List<String> largePlaceNames = new ArrayList<>();
        for (LargePlace largePlace :
                largePlaces) {
            largePlaceNames.add(largePlace.getLpName());
        }

        return ResultGenerator.success(largePlaceNames);
    }


    @ApiOperation(value = "根据大地点名和小地点名查询小地点")
    @GetMapping("/smallPlacesByLpNameAndSpName")
    public Result getSmallPlacesByLpNameAndSpName(@RequestParam(value = "lpName") String lpName,
                                                  @RequestParam(value = "spName") String spName) {
        spName = spName + "%";
        List<SmallPlace> smallPlaces = spotService.getSmallPlacesByLpNameAndSpName(lpName, spName);
        if (smallPlaces.size() == 0)
            return ResultGenerator.fail("无此小地点！");

        List<String> smallPlaceNames = new ArrayList<>();
        for (SmallPlace smallPlace :
                smallPlaces) {
            smallPlaceNames.add(smallPlace.getSpName());
        }

        return ResultGenerator.success(smallPlaceNames);
    }


    @ApiOperation(value = "根据小地点名和景点名查询景点")
    @GetMapping("/spotsBySpNameAndSpotName")
    public Result getSpotsBySpNameAndSpotName(@RequestParam(value = "spName") String spName,
                                              @RequestParam(value = "spotName") String spotName) {
        spotName = spotName + "%";
        List<ScenicSpot> scenicSpots = spotService.getSpotsBySpNameAndSpotName(spName, spotName);
        if (scenicSpots.size() == 0)
            return ResultGenerator.fail("该景点不存在！");

        List<String> scenicSpotNames = new ArrayList<>();
        for (ScenicSpot scenicSpot :
                scenicSpots) {
            scenicSpotNames.add(scenicSpot.getSpotName());
        }

        return ResultGenerator.success(scenicSpotNames);
    }


    @ApiOperation(value = "获得所有景点")
    @GetMapping("/allSpots")
    public Result getAllSpots() {
        List<ScenicSpot> scenicSpots = spotService.getAllSpots();
        if (scenicSpots.size() >= 15)
            scenicSpots = scenicSpots.subList(0, 15);
        return ResultGenerator.success(scenicSpots);
    }

}
