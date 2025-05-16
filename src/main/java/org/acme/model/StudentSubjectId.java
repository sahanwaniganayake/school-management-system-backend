package org.acme.model;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class StudentSubjectId implements Serializable {

    private Long studentId;
    private Long subjectId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentSubjectId that = (StudentSubjectId) o;
        return Objects.equals(getStudentId(), that.getStudentId()) &&
                Objects.equals(getSubjectId(), that.getSubjectId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStudentId(), getSubjectId());
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }
}
