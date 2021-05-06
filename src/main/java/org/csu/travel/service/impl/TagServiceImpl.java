package org.csu.travel.service.impl;

import org.csu.travel.domain.Tag;
import org.csu.travel.domain.TagExample;
import org.csu.travel.persistence.TagMapper;
import org.csu.travel.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    TagMapper tagMapper;

    @Override
    public List getAllTags() {

        TagExample tagExample = new TagExample();
        TagExample.Criteria criteria = tagExample.createCriteria();
        criteria.andTagNameIsNotNull();
        return tagMapper.selectByExample(tagExample);
    }

    @Override
    public void insertTag(Tag tag) {
        tagMapper.insert(tag);
    }

    @Override
    public Tag selectTagByTagName(String tagName) {
        if (tagName == null)
            return null;
        TagExample tagExample = new TagExample();
        TagExample.Criteria criteria = tagExample.createCriteria();
        criteria.andTagNameEqualTo(tagName);
        List<Tag> tags = tagMapper.selectByExample(tagExample);
        return tags.size() > 0 ? tags.get(0) : null;
    }

}
