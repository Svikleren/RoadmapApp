package lv.svikleren.roadmapapp.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "contacts")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String surname;

    @Column(name = "contacts_group")
    private String group;

    private String phoneNumber;

    private String email;

    private String comments;
}
