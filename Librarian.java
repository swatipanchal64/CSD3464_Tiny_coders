public class Librarian {
    private String name;
    private String staffID;
    private String role;

    // Constructor
    public Librarian(String name, String staffID, String role) {
        this.name = name;
        this.staffID = staffID;
        this.role = role;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for staffID
    public String getStaffID() {
        return staffID;
    }

    // Setter for staffID
    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    // Getter for role
    public String getRole() {
        return role;
    }

    // Setter for role
    public void setRole(String role) {
        this.role = role;
    }
}