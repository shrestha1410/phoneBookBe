package com.phoneBook.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class PlansResponse {
    private Long id;
    private  String planName;
    private Long amount;
    private Boolean subscription;
}
