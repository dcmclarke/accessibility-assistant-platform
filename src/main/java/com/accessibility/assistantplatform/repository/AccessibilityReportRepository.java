package com.accessibility.assistantplatform.repository;

import com.accessibility.assistantplatform.entity.AccessibilityReport;
import com.accessibility.assistantplatform.entity.ReportCategory;
import com.accessibility.assistantplatform.entity.ReportStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessibilityReportRepository extends JpaRepository<AccessibilityReport, Long> {

    // Spring Data JPA automatically provides these basic methods:
    // save(report) - saves a new report or updates existing
    // findById(id) - finds report by ID
    // findAll() - gets all reports
    // deleteById(id) - deletes a report
    // count() - counts total reports

    // Custom query methods - Spring generates the SQL for us!

    /**
     * Find all reports with a specific status
     * Example: findByStatus(ReportStatus.OPEN) gets all open reports
     */
    List<AccessibilityReport> findByStatus(ReportStatus status);

    /**
     * Find all reports in a specific category
     * Example: findByCategory(ReportCategory.MOBILITY) gets all mobility reports
     */
    List<AccessibilityReport> findByCategory(ReportCategory category);

    /**
     * Find reports by both status and category
     * Example: Find all OPEN MOBILITY reports
     */
    List<AccessibilityReport> findByStatusAndCategory(ReportStatus status, ReportCategory category);

    /**
     * Find reports by location (contains text)
     * Example: findByLocationContainingIgnoreCase("trinity") finds reports mentioning Trinity
     */
    List<AccessibilityReport> findByLocationContainingIgnoreCase(String location);

    /**
     * Find reports within a geographic area (custom SQL query)
     * This finds reports within a certain distance of a lat/lng point
     * Useful for "show me reports near my location"
     */
    @Query("SELECT r FROM AccessibilityReport r WHERE " +
            "r.latitude BETWEEN :minLat AND :maxLat AND " +
            "r.longitude BETWEEN :minLng AND :maxLng")
    List<AccessibilityReport> findReportsInArea(
            @Param("minLat") Double minLat,
            @Param("maxLat") Double maxLat,
            @Param("minLng") Double minLng,
            @Param("maxLng") Double maxLng);

    /**
     * Count reports by status - useful for dashboard analytics
     * Example: How many OPEN reports do we have?
     */
    long countByStatus(ReportStatus status);

    /**
     * Find the most recent reports (useful for homepage)
     */
    List<AccessibilityReport> findTop10ByOrderByCreatedAtDesc();
}