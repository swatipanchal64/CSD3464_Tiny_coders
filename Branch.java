abstract class Branch {
    private String branchName;
    private String address;
    private String phoneNumber;

    public Branch(String name, String address, String phoneNumber) {
        this.branchName = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getBranchName() {
        return branchName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Abstract method for managing books
    public abstract void manageBooks();

    // Abstract method for managing users
    public abstract void manageUsers();

    public abstract void manageStaff();

}