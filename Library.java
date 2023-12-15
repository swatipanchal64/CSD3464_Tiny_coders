import java.util.List;

public class Library {
    private String address;
    private List<Member> members;
    private List<Librarian> staff;

    public Library(String address, List<Member> members,List<Librarian> staff) {
        this.address = address;
        this.members = members;
        this.staff = staff;
    }

    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void addMember(Member member) {
        members.add(member);
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