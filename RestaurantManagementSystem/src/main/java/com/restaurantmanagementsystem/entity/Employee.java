package com.restaurantmanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="EMPLOYEE")
@DynamicInsert
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME")
    private String name;
    @Column(name = "SURNAME")
    private String surname;
    @Column(name = "DATE_OF_BIRTH")
    @Temporal(TemporalType.DATE)
    private Date dob;
    @Column(name="ADDRESS")
    private String address;
    @Column(name="CONTACT")
    private Long contact;
    @Column(name = "position")
    private String position;
    @Column(name="SALARY")
    private Long salary;
    @Column(name="DATA_DATE")
    @CreationTimestamp()
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_date;
    @Column(name="ACTIVE")
    @ColumnDefault(value = "1")
    private Integer active;

}
