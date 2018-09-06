package moneycollector.service;
/**
 * This is a class which can hold details of a member
 * @author RIYAD
 */
public class MemberDetail {
    private String name,id,ref;
    private int amount;
    private boolean isAll;

    /**
     * Constructor called with all parameters
     * @param name Name of the user
     * @param id ID of the user
     * @param ref Reference name of the user
     * @param amount amount he/she deposited
     */
    public MemberDetail(String name, String id, String ref, int amount) {
        this.name = name;
        this.id = id;
        this.ref = ref;
        this.amount = amount;
        isAll = true;
    }
    
    /**
     * Overloaded constructor without amount parameter
     * @param name Name of the user
     * @param id ID of the user
     * @param ref Reference name of the user
     */
    public MemberDetail(String name, String id, String ref) {
        this.name = name;
        this.id = id;
        this.ref = ref;
        this.amount = 0;
        isAll = true;
    }
    
    /**
     * Overloaded constructor with out any parameter
     */
    public MemberDetail() {
        this.name = null;
        this.id = null;
        this.ref = null;
        this.amount = 0;
    }

    /**
     * Get the name of the user
     * @return Name of the user
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the member
     * @param name name of the member
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the id of the user
     * @return The id of the member
     */
    public String getId() {
        return id;
    }

    /**
     * Set the id of the member
     * @param id ID of the member
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Get the reference name of the member
     * @return The reference name of the member
     */
    public String getRef() {
        return ref;
    }

    /**
     * Set the reference name of the member
     * @param ref The reference name of the member
     */
    public void setRef(String ref) {
        this.ref = ref;
    }

    /**
     * Get the total amount he/she deposited
     * @return Total amount he/she deposited
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Set the total amount of the user
     * @param amount The total amount of the user
     */
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    /**
     * Check is all parameters has been filled up
     * @return True if all parameters filled up
     */
    public boolean isAllFilledUp(){
        if(isAll)   return true;
        return (name != null && id != null && ref != null);
    }
    
    
}
