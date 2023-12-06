import java.util.List;
public class Library {
    private String address;
    private List<Librarian> staff;

    // Constructor
    public Library(String address, List<Librarian> staff) {
        this.address = address;
        this.staff = staff;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Setter for address
    public void setAddress(String address) {
        this.address = address;
    }

    // Getter for staff
    public List<Librarian> getStaff() {
        return staff;
    }

    // Setter for staff
    public void setStaff(List<Librarian> staff) {
        this.staff = staff;
    }

}