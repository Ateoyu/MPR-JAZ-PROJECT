package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

//public class NameDto {
//    @JsonProperty("full")
//    private String full;
//    @JsonProperty("native")
//    private String local;
//}

public record NameDto(
        String full,
        @JsonProperty("native")
        String local
) {
}
