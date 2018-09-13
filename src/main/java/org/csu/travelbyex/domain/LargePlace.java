package org.csu.travelbyex.domain;

public class LargePlace {
    private Integer lpId;

    private String lpName;

    private Boolean isHome;

    private String description;

    public LargePlace(Integer lpId, String lpName, Boolean isHome, String description) {
        this.lpId = lpId;
        this.lpName = lpName;
        this.isHome = isHome;
        this.description = description;
    }

    public LargePlace() {
        super();
    }

    public Integer getLpId() {
        return lpId;
    }

    public void setLpId(Integer lpId) {
        this.lpId = lpId;
    }

    public String getLpName() {
        return lpName;
    }

    public void setLpName(String lpName) {
        this.lpName = lpName == null ? null : lpName.trim();
    }

    public Boolean getIsHome() {
        return isHome;
    }

    public void setIsHome(Boolean isHome) {
        this.isHome = isHome;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
}