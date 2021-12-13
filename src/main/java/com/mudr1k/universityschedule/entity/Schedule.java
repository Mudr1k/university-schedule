package com.mudr1k.universityschedule.entity;

import javax.persistence.*;

@Entity
@Table(name = "schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "day_id")
    private Day day;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "groups_id")
    private Group group;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;

    public Schedule() {
    }

    public Schedule(Day day, Group group, Subject subject, Classroom classroom) {
        this.day = day;
        this.group = group;
        this.subject = subject;
        this.classroom = classroom;
    }

    public Schedule(Long id, Day day, Group group, Subject subject, Classroom classroom) {
        this.id = id;
        this.day = day;
        this.group = group;
        this.subject = subject;
        this.classroom = classroom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }
}
