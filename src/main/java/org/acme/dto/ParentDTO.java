package org.acme.dto;

public class ParentDTO {
    private long parentId;
    private String firstName;
    private String lastName;

    public ParentDTO() {
    }

    public ParentDTO( long parentId,String firstName, String lastName) {
        this.setFirstName(firstName);
        this.setParentId(parentId);
        this.setLastName(lastName);
    }


    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

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
}
