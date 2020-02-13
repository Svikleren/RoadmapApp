package lv.svikleren.roadmapapp.dto;

import lombok.Data;

@Data
public class ContactDto {

    private Long id;
    private String name;
    private String surname;
    private String group;
    private String phoneNumber;
    private String email;
    private String comments;
}