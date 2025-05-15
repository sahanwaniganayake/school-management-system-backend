package org.acme.dto;

public class ParentDTO {
    private long parentId;
    private String firstName;

    public ParentDTO(long parentId, String firstName, String lastName) {
        this.parentId = parentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    private String lastName;

    public ParentDTO() {
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
