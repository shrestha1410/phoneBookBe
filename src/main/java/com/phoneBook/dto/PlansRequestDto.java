package com.phoneBook.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PlansRequestDto {
    private  String planName;
    private Long amount;
    @JsonIgnore
    private Boolean subscription=false;
}
