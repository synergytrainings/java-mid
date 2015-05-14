package StaticMemberClass;

/**
 * Created by Anna on 14.05.2015.
 */
public class Person {
    private String firstName;
    private String lastName;
    private String passportNo;
    /* And Other person info fields*/
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportNo() {
        return passportNo;
    }

    public void setPassportNo(String passportNo) {
        this.passportNo = passportNo;
    }

}
