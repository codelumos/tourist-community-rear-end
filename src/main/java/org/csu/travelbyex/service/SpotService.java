package org.csu.travelbyex.service;

import org.csu.travelbyex.domain.LargePlace;
import org.csu.travelbyex.domain.ScenicSpot;
import org.csu.travelbyex.domain.SmallPlace;

import java.util.List;

public interface SpotService {

    // 大地点
    LargePlace getLPByName(String lpName);

    List getLPs(Boolean inHome);  // 国内外

    List getLPsByName(String lpName); // 模糊查询

    // 小地点
    SmallPlace getSPByName(String spName);

    List getSPsByLPid(Integer lpId);

    List getSmallPlacesByLpNameAndSpName(String lpName, String spName); // 级联模糊查询


    // 景点
    ScenicSpot getScenicSpotByName(String spotName);

    List getScenicSpotsBySPid(Integer spId);

    void insertSpot(ScenicSpot scenicSpot);

    List getSpotsBySpNameAndSpotName(String spName, String spotName); // 级联模糊查询


    List getAllSpots();

}
