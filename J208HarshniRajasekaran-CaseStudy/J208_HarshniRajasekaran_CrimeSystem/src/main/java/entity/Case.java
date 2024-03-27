/**
 * The Case class represents a case within the crime analysis system.
 * It encapsulates information about the case description and the collection of incidents associated with the case.
 * Instances of this class are used to manage and retrieve details about cases in the system.
 * 
 * @author Harshni
 * 
 */
package entity;
import java.util.Collection;
public class Case {
	private String caseDescription;
    private Collection<Incident> incidents;
    /**
     * Default constructor for creating an empty Case object.
     */
    public Case() {}
    
    /**
     * Parameterized constructor for creating a Case object with provided case description and associated incidents.
     * 
     * @param caseDescription The description of the case
     * @param incidents The collection of incidents associated with the case
     */
    public Case(String caseDescription, Collection<Incident> incidents) {
        this.caseDescription = caseDescription;
        this.incidents = incidents;
    }
    /**
     * Retrieves the description of the case.
     * 
     * @return The description of the case
     */
   
    public String getCaseDescription() {
        return caseDescription;
    }
    /**
     * Sets the description of the case.
     * 
     * @param caseDescription The description of the case to set
     */

    public void setCaseDescription(String caseDescription) {
        this.caseDescription = caseDescription;
    }
    /**
     * Retrieves the collection of incidents associated with the case.
     * 
     * @return The collection of incidents associated with the case
     */
    public Collection<Incident> getIncidents() {
        return incidents;
    }
    /**
     * Sets the collection of incidents associated with the case.
     * 
     * @param incidents The collection of incidents to set
     */
    public void setIncidents(Collection<Incident> incidents) {
        this.incidents = incidents;
    }
}
