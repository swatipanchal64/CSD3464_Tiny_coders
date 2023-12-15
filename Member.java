public class Member {
    private String name;
    private String membershipStatus;

    public Member(String name, String membershipStatus) {
        this.name = name;
        this.membershipStatus = membershipStatus;
    }

    public String getName() {
        return name;
    }

    public String getMembershipStatus() {
        return membershipStatus;
    }
}