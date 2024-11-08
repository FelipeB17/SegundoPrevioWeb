package co.edu.ufps.entities;

import jakarta.persistence.*;
import lombok.Data;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employee")
@Data
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_n", length = 50)
    private String firstName;

    @Column(name = "last_n", length = 50)
    private String lastName;

    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private Date birthdate;

    @ManyToOne
    @JoinColumn(name = "dep_id")
    private Department department;

    @ManyToOne
    @JoinColumn(name = "pos_id")
    private Position position;

    @Column(name = "entry_date")
    @Temporal(TemporalType.DATE)
    private Date entryDate;

    @OneToMany(mappedBy = "employee")
    private List<ProjectAssignment> projectAssignments;

    @OneToMany(mappedBy = "employee")
    private List<Visit> visits;
}