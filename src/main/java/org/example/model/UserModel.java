package org.example.model;

public class UserModel {
    private String firstName;
    private String lastName;
    private Integer membershipId;

    public UserModel(String firstName, String lastName, Integer membershipId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.membershipId = membershipId;
    }
    public UserModel() {}
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getMembershipId() {
        return membershipId;
    }
}


