package lv.svikleren.roadmapapp.dto;

import lombok.Data;

@Data
public class ItemDto {

    private Long id;

    private String name;

    private String type;

    private float price;

    private int count;

    private String description;
}
