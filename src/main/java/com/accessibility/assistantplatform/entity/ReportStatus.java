package com.accessibility.assistantplatform.entity;

public enum ReportStatus {
    OPEN("Open"),
    ACKNOWLEDGED("Acknowledged"),
    IN_PROGRESS("In Progress"),
    RESOLVED("Resolved"),
    CLOSED("Closed");

    private final String displayName;

    ReportStatus(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}