/**
 * The Incident class represents an incident within the crime analysis system.
 * It encapsulates information about the incident ID, date, description, status, and type.
 * Instances of this class are used to manage and retrieve details about incidents in the system.
 * 
 * @author Harshni
 * 
 */
package entity;
import java.util.Date;
public class Incident {
	private int incidentId;
    private Date incident_date;
    private String des_cription;
    private Status sta_tus;
    private IncidentType incident_type;
    /**
     * Default constructor for creating an empty Incident object.
     */
    public Incident() {}
    /**
     * Parameterized constructor for creating an Incident object with provided attributes.
     * 
     * @param incidentId The unique identifier for the incident
     * @param incident_date The date when the incident occurred
     * @param des_cription The description of the incident
     * @param sta_tus The status of the incident
     * @param incident_type The type of the incident
     */
    public Incident(int incidentId, Date incident_date, String des_cription, Status sta_tus, IncidentType incident_type) {
        this.incidentId = incidentId;
        this.incident_date = incident_date;
        this.des_cription = des_cription;
        this.sta_tus = sta_tus;
        this.incident_type =incident_type;
    }
    /**
     * Retrieves the unique identifier for the incident.
     * 
     * @return The unique identifier for the incident
     */
   
    public int getIncidentId() {
        return incidentId;
    }
    /**
     * Sets the unique identifier for the incident.
     * 
     * @param incidentId The unique identifier for the incident to set
     */

    public void setIncidentId(int incidentId) {
        this.incidentId = incidentId;
    }
    /**
     * Retrieves the date when the incident occurred.
     * 
     * @return The date when the incident occurred
     */

    public Date getincident_date() {
        return incident_date;
    }
    /**
     * Sets the date when the incident occurred.
     * 
     * @param incident_date The date when the incident occurred to set
     */

    public void setincident_date(Date incident_date) {
        this.incident_date = incident_date;
    }
    /**
     * Retrieves the description of the incident.
     * 
     * @return The description of the incident
     */

    public String getdes_cription() {
        return des_cription;
    }
    /**
     * Sets the description of the incident.
     * 
     * @param des_cription The description of the incident to set
     */

    public void setdes_cription(String des_cription) {
        this.des_cription = des_cription;
    }
    /**
     * Retrieves the status of the incident.
     * 
     * @return The status of the incident
     */

    public Status getsta_tus() {
        return sta_tus;
    }
    /**
     * Sets the status of the incident.
     * 
     * @param sta_tus The status of the incident to set
     */
    public void setsta_tus(Status sta_tus) {
        this.sta_tus = sta_tus;
    }
    /**
     * Retrieves the type of the incident.
     * 
     * @return The type of the incident
     */
    public IncidentType getincident_type() {
        return incident_type;
    }
    /**
     * Sets the type of the incident.
     * 
     * @param incident_type The type of the incident to set
     */
    public void setincident_type(IncidentType incident_type) {
        this.incident_type = incident_type;
    }
}
