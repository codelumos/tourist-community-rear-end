package org.csu.travelbyex.service;

import org.csu.travelbyex.domain.Tag;

import java.util.List;

public interface TagService {

    List getAllTags();

    void insertTag(Tag tag);

    Tag selectTagByTagName(String tagName);

}
