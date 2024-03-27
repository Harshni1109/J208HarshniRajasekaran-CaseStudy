package dao;
import entity.Case;

import entity.Incident;
import entity.IncidentType;
import entity.Report;
import entity.Status;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
/**
 * The CrimeAnalysisServiceImlp class provides implementations for various functionalities related to crime analysis.
 * It extends the abstract class ICrimeAnalysisService and implements its abstract methods.
 * This class interacts with the database to perform CRUD operations on incidents and cases.
 * 
 * @author Harshni
 * 
 */
public  class CrimeAnalysisServiceImlp extends ICrimeAnalysisService {
	
	private static Connection connection;
	/**
     * Constructor for CrimeAnalysisServiceImlp class.
     * Initializes the database connection.
     */

    public CrimeAnalysisServiceImlp() {
        connection = DBConnection.getConnection();
    }
    /**
     * Creates a new incident in the database.
     * 
     * @param incident The incident object containing details of the incident to be created
     * @return true if the incident is created successfully, false otherwise
     */

    @Override
    public boolean createIncident(Incident incident) {
        String query = "INSERT INTO incidents (incident_id, incident_date, des_cription, sta_tus, incident_type) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, incident.getIncidentId());
            statement.setDate(2, new java.sql.Date(incident.getincident_date().getTime()));
            statement.setString(3, incident.getdes_cription());
            statement.setString(4, incident.getsta_tus().toString());
            statement.setString(5, incident.getincident_type().toString());
            int rowsInserted = statement.executeUpdate();
            return rowsInserted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Updates the status of an existing incident in the database.
     * 
     * @param status The new status of the incident
     * @param incidentId The ID of the incident to update
     * @return true if the incident status is updated successfully, false otherwise
     */
    @Override
    public boolean updateIncidentStatus(Status status, int incidentId) {
        String query = "UPDATE incidents SET sta_tus = ? WHERE incident_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, status.toString());
            statement.setInt(2, incidentId);
            int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    /**
     * Retrieves incidents that occurred within a specified date range from the database.
     * 
     * @param startDate The start date of the date range
     * @param endDate The end date of the date range
     * @return Collection of Incident objects within the specified date range
     */
    @Override
    public Collection<Incident> getIncidentsInDateRange(Date startDate, Date endDate) {
        List<Incident> incidents = new ArrayList<>();
        String query = "SELECT * FROM incidents WHERE incident_date BETWEEN ? AND ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setDate(1, new java.sql.Date(startDate.getTime()));
            statement.setDate(2, new java.sql.Date(endDate.getTime()));
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Incident incident = new Incident();
                incident.setIncidentId(resultSet.getInt("incident_id"));
                incident.setincident_date(resultSet.getDate("incident_date"));
                incident.setdes_cription(resultSet.getString("des_cription"));
                incident.setsta_tus(Status.valueOf(resultSet.getString("sta_tus")));
                incident.setincident_type(IncidentType.valueOf(resultSet.getString("incident_type")));
                incidents.add(incident);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return incidents;
    }
    /**
     * Searches for incidents based on a specified criteria (incident type) in the database.
     * 
     * @param criteria The incident type criteria to search for
     * @return Collection of Incident objects matching the specified criteria
     */
	@Override
	public Collection<Incident> searchIncidents(IncidentType criteria) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
     * Generates a report for a specific incident from the database.
     * 
     * @param incident The incident for which to generate the report
     * @return Report object containing the generated report
     */

	@Override
	public Report generateIncidentReport(Incident incident) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
     * Creates a new case in the database.
     * 
     * @param caseDescription Description of the case
     * @param incidents Collection of Incident objects associated with the case
     * @return Case object representing the newly created case
     */

	@Override
	public Case createCase(String caseDescription, Collection<Incident> incidents) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
     * Retrieves details of a specific case from the database.
     * 
     * @param caseId The ID of the case to retrieve details for
     * @return Case object containing details of the specified case
     */
	@Override
	public Case getCaseDetails(int caseId) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
     * Updates details of an existing case in the database.
     * 
     * @param caseDetails The Case object containing updated details
     * @return true if the case details are updated successfully, false otherwise
     */

	@Override
	public boolean updateCaseDetails(Case caseDetails) {
		// TODO Auto-generated method stub
		return false;
	}
	/**
     * Retrieves a list of all cases stored in the database.
     * 
     * @return List of Case objects representing all cases
     */
	@Override
	public List<Case> getAllCases() {
		// TODO Auto-generated method stub
		return null;
	}
}
