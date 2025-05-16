package org.acme.dto;


public class SubjectDTO {
    private long subjectId;
    private String subjectName;
    private String subjectDescription;

    public SubjectDTO() {
    }

    public SubjectDTO(long subjectId, String subjectDescription, String subjectName) {
        this.subjectId = subjectId;
        this.subjectDescription = subjectDescription;
        this.subjectName = subjectName;
    }

    public long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(long subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getSubjectDescription() {
        return subjectDescription;
    }

    public void setSubjectDescription(String subjectDescription) {
        this.subjectDescription = subjectDescription;
    }
}
