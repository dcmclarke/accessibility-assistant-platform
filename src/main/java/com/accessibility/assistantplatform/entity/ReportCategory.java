package com.accessibility.assistantplatform.entity;

public enum ReportCategory {
    MOBILITY_ACCESS("Mobility Access"),
    VISUAL_BARRIERS("Visual Barriers"),
    HEARING_BARRIERS("Hearing Barriers"),
    SIGNAGE("Signage Issues"),
    PARKING("Parking Issues"),
    RESTROOM("Restroom Access"),
    OTHER("Other");

    private final String displayName;

    ReportCategory(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}