package org.csu.travel.service;

import org.csu.travel.domain.Tag;

import java.util.List;

public interface TagService {

    List getAllTags();

    void insertTag(Tag tag);

    Tag selectTagByTagName(String tagName);

}
