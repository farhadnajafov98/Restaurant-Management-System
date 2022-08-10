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
@Table(name = "MENU")
@DynamicInsert
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "NAME",length = 20)
    private String name;
    @Column(name = "INGREDIENTS", length = 100)
    private String ingredient;
    @Column(name="CATEGORY", length = 30)
    private String category;
    @Column(name="PRICE")
    private Integer price;
    @Column(name="DATA_DATE")
    @CreationTimestamp()
    @Temporal(TemporalType.TIMESTAMP)
    private Date data_date;
    @Column(name="ACTIVE")
    @ColumnDefault(value = "1")
    private Integer active;


}
