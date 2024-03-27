/**
 * The IncidentNumberNotFoundException class represents an exception that is thrown when
 * an incident with a specific incident number is not found within the crime analysis system.
 * This exception is typically thrown when attempting to retrieve details of a non-existent incident.
 * 
 * @author Harshni
 * 
 */
package exceptions;

public class IncidentNumberNotFoundException extends Exception {

    /**
     * Constructs a new IncidentNumberNotFoundException with the specified detail message.
     * 
     * @param message The detail message which describes the specific incident number not found
     */
    public IncidentNumberNotFoundException(String message) {
        super(message);
    }
}
