package org.csu.travelbyex.service;

import org.csu.travelbyex.domain.Tag;

import java.util.List;

public interface TagService {

    public List getAllTags();

    public void insertTag(Tag tag);

    public Tag selectTagByTagName(String tagName);

}
