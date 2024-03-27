/**
 * The ICrimeAnalysisService abstract class defines the interface for interacting with crime analysis service functionalities.
 * It provides methods to perform operations related to incidents and cases within the crime analysis system.
 * Concrete implementations of this interface will provide the actual implementation for these methods.
 * 
 * @author Harshni
 * 
 */
package dao;
import entity.Case;
import entity.Incident;
import entity.IncidentType;
import entity.Report;
import entity.Status;

import java.util.Collection;
import java.util.Date;
import java.util.List;

public abstract class ICrimeAnalysisService {
	/**
     * Creates a new incident in the system.
     * 
     * @param incident The Incident object representing the incident to be created
     * @return true if the incident is successfully created, false otherwise
     */
	
    public abstract boolean createIncident(Incident incident);

    /**
     * Updates the status of an existing incident.
     * 
     * @param status The new status of the incident
     * @param incidentId The ID of the incident to update
     * @return true if the incident status is successfully updated, false otherwise
     */
    public abstract boolean updateIncidentStatus(Status status, int incidentId);
    /**
     * Retrieves incidents that occurred within a specified date range.
     * 
     * @param startDate The start date of the range
     * @param endDate The end date of the range
     * @return A collection of Incident objects within the specified date range
     */
   
    public abstract Collection<Incident> getIncidentsInDateRange(Date startDate, Date endDate);

    /**
     * Searches for incidents based on a specific criteria (incident type).
     * 
     * @param criteria The incident type criteria to search for
     * @return A collection of Incident objects matching the specified criteria
     */
    public abstract Collection<Incident> searchIncidents(IncidentType criteria);

    /**
     * Generates a report for a specified incident.
     * 
     * @param incident The Incident object for which the report is generated
     * @return The generated Report object
     */
    public abstract Report generateIncidentReport(Incident incident);
    /**
     * Creates a new case with the provided description and associated incidents.
     * 
     * @param caseDescription The description of the case
     * @param incidents The collection of incidents associated with the case
     * @return The created Case object
     */
   
    public abstract Case createCase(String caseDescription, Collection<Incident> incidents);
    /**
     * Retrieves details of a specific case based on the provided case ID.
     * 
     * @param caseId The ID of the case to retrieve details for
     * @return The Case object representing the details of the specified case
     */
   
    public abstract Case getCaseDetails(int caseId);

    /**
     * Updates details of a specific case.
     * 
     * @param caseDetails The Case object with updated details
     * @return true if the case details are successfully updated, false otherwise
     */
    public abstract boolean updateCaseDetails(Case caseDetails);
    /**
     * Retrieves a list of all cases stored in the system.
     * 
     * @return A list containing all Case objects in the system
     */
   
    public abstract List<Case> getAllCases();

    /**
     * Retrieves details of a specific incident based on the provided incident ID.
     * 
     * @param incidentId The ID of the incident to retrieve details for
     * @return The Incident object representing the details of the specified incident
     */
	public Incident getIncidentDetails(int incidentId) {
		// TODO Auto-generated method stub
		return null;
	}
}
