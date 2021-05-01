package org.csu.travelbyex.service.impl;

import org.csu.travelbyex.domain.*;
import org.csu.travelbyex.persistence.LargePlaceMapper;
import org.csu.travelbyex.persistence.ScenicSpotMapper;
import org.csu.travelbyex.persistence.SmallPlaceMapper;
import org.csu.travelbyex.service.SpotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SpotServiceImpl implements SpotService {

    @Autowired
    LargePlaceMapper largePlaceMapper;
    @Autowired
    SmallPlaceMapper smallPlaceMapper;
    @Autowired
    ScenicSpotMapper scenicSpotMapper;

    // 大地点
    @Override
    public LargePlace getLPByName(String lpName) {
        LargePlaceExample largePlaceExample = new LargePlaceExample();
        LargePlaceExample.Criteria criteria = largePlaceExample.createCriteria();
        criteria.andLpNameEqualTo(lpName);
        List list = largePlaceMapper.selectByExampleWithBLOBs(largePlaceExample);

        return list.size() > 0 ? (LargePlace) list.get(0) : null;
    }


    @Override
    public List getLPsByName(String lpName) {
        LargePlaceExample largePlaceExample = new LargePlaceExample();
        LargePlaceExample.Criteria criteria = largePlaceExample.createCriteria();
        criteria.andLpNameLike(lpName);
        List list = largePlaceMapper.selectByExampleWithBLOBs(largePlaceExample);
        return list;
    }


    @Override
    public List getLPs(Boolean inHome) {
        LargePlaceExample largePlaceExample = new LargePlaceExample();
        LargePlaceExample.Criteria criteria = largePlaceExample.createCriteria();
        criteria.andIsHomeEqualTo(inHome);
        return largePlaceMapper.selectByExampleWithBLOBs(largePlaceExample);
    }

    // 小地点
    @Override
    public SmallPlace getSPByName(String spName) {
        SmallPlaceExample smallPlaceExample = new SmallPlaceExample();
        SmallPlaceExample.Criteria criteria = smallPlaceExample.createCriteria();
        criteria.andSpNameEqualTo(spName);
        List list = smallPlaceMapper.selectByExampleWithBLOBs(smallPlaceExample);

        return list.size() > 0 ? (SmallPlace) list.get(0) : null;
    }

    @Override
    public List getSPsByLPid(Integer lpId) {
        SmallPlaceExample smallPlaceExample = new SmallPlaceExample();
        SmallPlaceExample.Criteria criteria = smallPlaceExample.createCriteria();
        criteria.andLpIdEqualTo(lpId);
        return smallPlaceMapper.selectByExampleWithBLOBs(smallPlaceExample);
    }

    @Override
    public List getSmallPlacesByLpNameAndSpName(String lpName, String spName) {

        LargePlace largePlace = getLPByName(lpName);
        if (largePlace == null) return new ArrayList();
        SmallPlaceExample smallPlaceExample = new SmallPlaceExample();
        SmallPlaceExample.Criteria criteria = smallPlaceExample.createCriteria();
        criteria.andLpIdEqualTo(largePlace.getLpId());
        criteria.andSpNameLike(spName);
        return smallPlaceMapper.selectByExampleWithBLOBs(smallPlaceExample);

    }


    // 景点
    @Override
    public ScenicSpot getScenicSpotByName(String spotName) {
        ScenicSpotExample smallPlaceExample = new ScenicSpotExample();
        ScenicSpotExample.Criteria criteria = smallPlaceExample.createCriteria();
        criteria.andSpotNameEqualTo(spotName);
        List list = scenicSpotMapper.selectByExampleWithBLOBs(smallPlaceExample);

        return list.size() > 0 ? (ScenicSpot) list.get(0) : null;
    }

    @Override
    public List getScenicSpotsBySPid(Integer spId) {
        ScenicSpotExample smallPlaceExample = new ScenicSpotExample();
        ScenicSpotExample.Criteria criteria = smallPlaceExample.createCriteria();
        criteria.andPlaceIdEqualTo(spId);
        return scenicSpotMapper.selectByExampleWithBLOBs(smallPlaceExample);
    }

    @Override
    public void insertSpot(ScenicSpot scenicSpot) {
        scenicSpotMapper.insert(scenicSpot);
    }

    @Override
    public List getSpotsBySpNameAndSpotName(String spName, String spotName) {

        SmallPlace smallPlace = getSPByName(spName);
        if (smallPlace == null) return new ArrayList();
        ScenicSpotExample scenicSpotExample = new ScenicSpotExample();
        ScenicSpotExample.Criteria criteria = scenicSpotExample.createCriteria();
        criteria.andPlaceIdEqualTo(smallPlace.getSpId());
        criteria.andSpotNameLike(spotName);
        return scenicSpotMapper.selectByExampleWithBLOBs(scenicSpotExample);

    }

    @Override
    public List getAllSpots() {

        ScenicSpotExample scenicSpotExample = new ScenicSpotExample();
        ScenicSpotExample.Criteria criteria = scenicSpotExample.createCriteria();
        criteria.andSpotNameIsNotNull();
        List<ScenicSpot> scenicSpots = scenicSpotMapper.selectByExampleWithBLOBs(scenicSpotExample);
        return scenicSpots;
    }

}
