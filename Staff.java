public class Staff implements Role {
    private String role;
    private String staffName;

    public Staff(String role, String name) {
        this.role = role;
        this.staffName = name;
    }

    public String getStaffName() {
        return staffName;
    }

    @Override
    public String getRole() {
        return role;
    }
}