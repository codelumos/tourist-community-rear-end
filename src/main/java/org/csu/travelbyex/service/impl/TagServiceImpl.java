package org.csu.travelbyex.service.impl;

import org.csu.travelbyex.domain.TagExample;
import org.csu.travelbyex.persistence.TagMapper;
import org.csu.travelbyex.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List getAllTags(){

        TagExample tagExample = new TagExample();
        TagExample.Criteria criteria = tagExample.createCriteria();
        criteria.andTagNameIsNull();
        return tagMapper.selectByExample(tagExample);
    }

}
