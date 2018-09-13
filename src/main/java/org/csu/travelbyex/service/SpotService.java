package org.csu.travelbyex.service;

import org.csu.travelbyex.domain.LargePlace;
import org.csu.travelbyex.domain.ScenicSpot;
import org.csu.travelbyex.domain.SmallPlace;

import java.util.List;

public interface SpotService {

    //大地点
    public LargePlace getLPByName(String lpName);
    public List getLPs(Boolean inHome);  //国内外

    //小地点
    public SmallPlace getSPByName(String spName);
    public List getSPsByLPid(Integer lpId);

    //景点
    public ScenicSpot getScenicSpotByName(String spotName);
    public List getScenicSpotsBySPid(Integer spId);
    
}
