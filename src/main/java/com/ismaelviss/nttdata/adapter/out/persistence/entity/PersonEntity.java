package com.ismaelviss.nttdata.adapter.out.persistence.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "person",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "identification"),
        })
@Inheritance(strategy = InheritanceType.JOINED)
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private Integer age;
    private String identification;
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;
}
