/**
 * The Report class represents a report generated within the crime analysis system.
 * It encapsulates information about the report ID and the content of the report.
 * Instances of this class are used to manage and retrieve details about reports generated in the system.
 * 
 * @author Harshni
 * 
 */
package entity;

public class Report {
    
    private int reportId; // Unique identifier for the report
    private String reportContent; // Content of the report

    /**
     * Default constructor for creating an empty Report object.
     */
    public Report() {}

    /**
     * Parameterized constructor for creating a Report object with provided report ID and content.
     * 
     * @param reportId The unique identifier for the report
     * @param reportContent The content of the report
     */
    public Report(int reportId, String reportContent) {
        this.reportId = reportId;
        this.reportContent = reportContent;
    }

    /**
     * Retrieves the unique identifier for the report.
     * 
     * @return The unique identifier for the report
     */
    public int getReportId() {
        return reportId;
    }

    /**
     * Sets the unique identifier for the report.
     * 
     * @param reportId The unique identifier for the report to set
     */
    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    /**
     * Retrieves the content of the report.
     * 
     * @return The content of the report
     */
    public String getReportContent() {
        return reportContent;
    }

    /**
     * Sets the content of the report.
     * 
     * @param reportContent The content of the report to set
     */
    public void setReportContent(String reportContent) {
        this.reportContent = reportContent;
    }

    /**
     * Returns a string representation of the Report object.
     * 
     * @return A string containing the report ID and content
     */
    @Override
    public String toString() {
        return "Report{" +
                "reportId=" + reportId +
                ", reportContent='" + reportContent + '\'' +
                '}';
    }
}
