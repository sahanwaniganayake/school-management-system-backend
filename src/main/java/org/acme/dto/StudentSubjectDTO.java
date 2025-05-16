package org.acme.dto;

import java.time.LocalDate;

public class StudentSubjectDTO {
    private Long studentId;
    private Long SubjectId;
    private Double marks;
    private LocalDate enrollmentDate;


    public StudentSubjectDTO() {
    }

    public StudentSubjectDTO(Long studentId, Long SubjectId, Double marks, LocalDate enrollmentDate) {
        this.studentId = studentId;
        this.SubjectId = SubjectId;
        this.marks = marks;
        this.enrollmentDate = enrollmentDate;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getSubjectId() {
        return SubjectId;
    }

    public void setSubjectId(Long SubjectId) {
        this.SubjectId = SubjectId;
    }

    public Double getMarks() {
        return marks;
    }

    public void setMarks(Double marks) {
        this.marks = marks;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public void setEnrollmentDate(LocalDate enrollmentDate) {
        this.enrollmentDate = enrollmentDate;
    }
}
