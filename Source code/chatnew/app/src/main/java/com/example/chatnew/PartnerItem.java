package com.example.chatnew;

public class PartnerItem {
    private String name;
    private String identity;
    private String partnerType;
    private int locationMatch;
    private int interestMatch;
    private String recommendReason;
    private String commonTags;

    public PartnerItem(String name, String identity, String partnerType, int locationMatch, 
                       int interestMatch, String recommendReason, String commonTags) {
        this.name = name;
        this.identity = identity;
        this.partnerType = partnerType;
        this.locationMatch = locationMatch;
        this.interestMatch = interestMatch;
        this.recommendReason = recommendReason;
        this.commonTags = commonTags;
    }

    public String getName() {
        return name;
    }

    public String getIdentity() {
        return identity;
    }

    public String getPartnerType() {
        return partnerType;
    }

    public int getLocationMatch() {
        return locationMatch;
    }

    public int getInterestMatch() {
        return interestMatch;
    }

    public String getRecommendReason() {
        return recommendReason;
    }

    public String getCommonTags() {
        return commonTags;
    }
}