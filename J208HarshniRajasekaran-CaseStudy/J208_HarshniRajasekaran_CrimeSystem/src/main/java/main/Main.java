package main;
import dao.CrimeAnalysisServiceImlp;

import dao.ICrimeAnalysisService;
/**
 * The Main class serves as the entry point for the Crime Analysis System application. It provides a menu-driven interface for users to interact with the system functionalities.
 * Users can perform various actions such as creating incidents, updating incident status, generating incident reports, creating cases, updating case details, and more.
 * The class utilizes the CrimeAnalysisServiceImlp class to interact with the underlying data and perform necessary operations.
 * 
 * @author Harshni
 * 
 */
import main.Case;
import entity.Incident;
import entity.Status;
import entity.IncidentType;
import entity.Report;

import exceptions.IncidentNumberNotFoundException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {
	/**
     * The main method is the entry point of the Crime Analysis System application.
     * It displays a menu-driven interface to users and handles user inputs to execute various functionalities.
     * 
     * @param args Command-line arguments (not used)
     */
	public static void main(String[] args) {
		try {
            ICrimeAnalysisService service = new CrimeAnalysisServiceImlp();
            Scanner scanner = new Scanner(System.in);
         // Main menu loop
            while (true) {
            	System.out.println();
                System.out.println("Crime Analysis System");
                System.out.println("----------------------");
                System.out.println("1. Create a new incident");
                System.out.println("2. Update the status of an incident");
                System.out.println("3. Get incidents within a date range");
                System.out.println("4. Search for incidents based on criteria");
                System.out.println("5. Generate incident report");
                System.out.println("6. Create a new case");
                System.out.println("7. Get details of a specific case");
                System.out.println("8. Update case details");
                System.out.println("9. Get a list of all cases");
                System.out.println("0. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
             // Switch statement to execute corresponding functionality based on user choice
                switch (choice) {
                    case 1:
                        createIncident(service);
                        break;
                    case 2:
                        updateIncidentStatus(service);
                        break;
                    case 3:
                        getIncidentsInDateRange(service);
                        break;
                    case 4:
                        searchIncidents(service);
                        break;
                    case 5:
                        generateIncidentReport(service);
                        break;
                    case 6:
                        createCase(service);
                        break;
                    case 7:
                        getCaseDetails(service);
                        break;
                    case 8:
                        updateCaseDetails(service);
                        break;
                    case 9:
                        getAllCases(service);
                        break;
                    case 0:
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	/**
     * This method facilitates the creation of a new incident by taking user inputs.
     * It prompts the user for incident details such as ID, date, description, status, and type.
     * 
     * @param service Instance of ICrimeAnalysisService used for interacting with incident-related operations
     */
    private static void createIncident(ICrimeAnalysisService service) {
        Scanner scanner = new Scanner(System.in);
        Incident incident = new Incident();
        System.out.print("Enter Incident ID: ");
        incident.setIncidentId(scanner.nextInt());
        System.out.print("Enter Date (yyyy-MM-dd): ");
        String dateStr = scanner.next();
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            incident.setincident_date(date);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter in yyyy-MM-dd format.");
            return;
        }
        System.out.print("Enter Description: ");
        incident.setdes_cription(scanner.nextLine());
        System.out.print("Enter Status (OPEN, IN_PROGRESS, CLOSED): ");
        incident.setsta_tus(Status.valueOf(scanner.nextLine().toUpperCase()));
        System.out.print("Enter Type (TYPE1, TYPE2, TYPE3): ");
        incident.setincident_type(IncidentType.valueOf(scanner.nextLine().toUpperCase()));
        boolean incidentCreated = service.createIncident(incident);
        if (incidentCreated)
            System.out.println("Incident created successfully.");
        else
            System.out.println("Failed to create incident.");
    }
    /**
     * This method facilitates updating the status of an existing incident.
     * It prompts the user for the incident ID and the new status.
     * 
     * @param service Instance of ICrimeAnalysisService used for interacting with incident-related operations
     */
    private static void updateIncidentStatus(ICrimeAnalysisService service) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Incident ID: ");
        int incidentId = scanner.nextInt();
        System.out.print("Enter Status (OPEN, IN_PROGRESS, CLOSED): ");
        Status status = Status.valueOf(scanner.nextLine().toUpperCase());
        boolean statusUpdated = service.updateIncidentStatus(status, incidentId);
        if (statusUpdated)
            System.out.println("Incident status updated successfully.");
        else
            System.out.println("Failed to update incident status.");
    }
    /**
     * This method retrieves incidents within a specified date range.
     * It prompts the user for the start and end dates of the range.
     * 
     * @param service Instance of ICrimeAnalysisService used for interacting with incident-related operations
     */

    private static void getIncidentsInDateRange(ICrimeAnalysisService service) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Start Date (yyyy-MM-dd): ");
        String startDateStr = scanner.next();
        System.out.print("Enter End Date (yyyy-MM-dd): ");
        String endDateStr = scanner.next();
        try {
            Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(startDateStr);
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateStr);
            Collection<Incident> incidentsInRange = service.getIncidentsInDateRange(startDate, endDate);
            System.out.println("Incidents within date range:");
            for (Incident incident : incidentsInRange) {
                System.out.println(incident);
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please enter in yyyy-MM-dd format.");
        }
    }
    /**
     * This method searches for incidents based on a specific criteria (incident type).
     * It prompts the user for the incident type criteria.
     * 
     * @param service Instance of ICrimeAnalysisService used for interacting with incident-related operations
     */
    private static void searchIncidents(ICrimeAnalysisService service) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Criteria (TYPE1, TYPE2, TYPE3): ");
        IncidentType criteria = IncidentType.valueOf(scanner.nextLine().toUpperCase());
        Collection<Incident> searchedIncidents = service.searchIncidents(criteria);
        System.out.println("Searched incidents:");
        for (Incident incident : searchedIncidents) {
            System.out.println(incident);
        }
    }
    /**
     * This method generates a report for a specified incident.
     * It prompts the user for the incident ID.
     * 
     * @param service Instance of ICrimeAnalysisService used for interacting with incident-related operations
     */
    private static void generateIncidentReport(ICrimeAnalysisService service) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Incident ID: ");
        int incidentId = scanner.nextInt();
        Incident incident = new Incident();
        incident.setIncidentId(incidentId);
        Report report = service.generateIncidentReport(incident);
        System.out.println("Generated report:");
        System.out.println(report);
    }
    /**
     * This method facilitates the creation of a new case.
     * It prompts the user for the case description and associated incident IDs.
     * 
     * @param service Instance of ICrimeAnalysisService used for interacting with case-related operations
     */


    private static void createCase(ICrimeAnalysisService service) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Case Description: ");
        String caseDescription = scanner.nextLine();
        Collection<Incident> incidents = new ArrayList<>();
        while (true) {
            System.out.print("Enter Incident ID (or 0 to stop adding incidents): ");
            int incidentId = scanner.nextInt();
            if (incidentId == 0)
                break;
            Incident incident = new Incident();
            incident.setIncidentId(incidentId);
            incidents.add(incident);
        }
        entity.Case newCase = service.createCase(caseDescription, incidents);
        System.out.println("New case created:");
        System.out.println(newCase);
    }
    /**
     * This method retrieves details of a specific case based on the provided case ID.
     * It prompts the user for the case ID.
     * 
     * @param service Instance of ICrimeAnalysisService used for interacting with case-related operations
     */
    private static void getCaseDetails(ICrimeAnalysisService service) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Case ID: ");
        int caseId = scanner.nextInt();
        entity.Case caseDetails = service.getCaseDetails(caseId);
        System.out.println("Case details:");
        System.out.println(caseDetails);
    }
    /**
     * This method updates details of a specific case based on the provided case ID.
     * It prompts the user for the case ID and the updated description.
     * 
     * @param service Instance of ICrimeAnalysisService used for interacting with case-related operations
     */
    private static void updateCaseDetails(ICrimeAnalysisService service) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Case ID: ");
        int caseId = scanner.nextInt();
        entity.Case caseDetails = service.getCaseDetails(caseId);
        if (caseDetails != null) {
            
            System.out.println("Current Case Details:");
            System.out.println(caseDetails);

           
            System.out.print("Enter Updated Case Description: ");
            String updatedDescription = scanner.nextLine();
            caseDetails.setCaseDescription(updatedDescription);

            
            boolean updated = service.updateCaseDetails(caseDetails);
            if (updated) {
                System.out.println("Case details updated successfully.");
            } else {
                System.out.println("Failed to update case details.");
            }
        } else {
            System.out.println("Case with ID " + caseId + " not found.");
        }
    }
    /**
     * This method retrieves a list of all cases stored in the system.
     * 
     * @param service Instance of ICrimeAnalysisService used for interacting with case-related operations
     */
    private static void getAllCases(ICrimeAnalysisService service) {
        List<entity.Case> allCases = service.getAllCases();
        System.out.println("All cases:");
        for (entity.Case caseDetails : allCases) {
            System.out.println(caseDetails);
        }
		 try {
	            ICrimeAnalysisService service1 = new CrimeAnalysisServiceImlp();
	            Scanner scanner = new Scanner(System.in);

	            System.out.print("Enter the incident ID: ");
	            int incidentId = scanner.nextInt();

	            try {
	                Incident incident = service1.getIncidentDetails(incidentId);
	                if (incident == null) {
	                    throw new IncidentNumberNotFoundException("Incident with ID " + incidentId + " not found");
	                }
	               
	            } catch (IncidentNumberNotFoundException e) {
	                System.out.println(e.getMessage());
	                
	            }

	           

	        } catch (Exception e) {
	           
	            e.printStackTrace();
	        }	

	}

}
