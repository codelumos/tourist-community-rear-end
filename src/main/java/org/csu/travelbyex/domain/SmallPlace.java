package org.csu.travelbyex.domain;

public class SmallPlace {
    private Integer spId;

    private Integer lpId;

    private String spName;

    private String imagePath1;

    private String imagePath2;

    private String imagePath3;

    private String description;

    public SmallPlace(Integer spId, Integer lpId, String spName, String imagePath1, String imagePath2, String imagePath3, String description) {
        this.spId = spId;
        this.lpId = lpId;
        this.spName = spName;
        this.imagePath1 = imagePath1;
        this.imagePath2 = imagePath2;
        this.imagePath3 = imagePath3;
        this.description = description;
    }

    public SmallPlace() {
        super();
    }

    public Integer getSpId() {
        return spId;
    }

    public void setSpId(Integer spId) {
        this.spId = spId;
    }

    public Integer getLpId() {
        return lpId;
    }

    public void setLpId(Integer lpId) {
        this.lpId = lpId;
    }

    public String getSpName() {
        return spName;
    }

    public void setSpName(String spName) {
        this.spName = spName == null ? null : spName.trim();
    }

    public String getImagePath1() {
        return imagePath1;
    }

    public void setImagePath1(String imagePath1) {
        this.imagePath1 = imagePath1 == null ? null : imagePath1.trim();
    }

    public String getImagePath2() {
        return imagePath2;
    }

    public void setImagePath2(String imagePath2) {
        this.imagePath2 = imagePath2 == null ? null : imagePath2.trim();
    }

    public String getImagePath3() {
        return imagePath3;
    }

    public void setImagePath3(String imagePath3) {
        this.imagePath3 = imagePath3 == null ? null : imagePath3.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}