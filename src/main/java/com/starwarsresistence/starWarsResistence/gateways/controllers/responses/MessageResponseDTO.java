package com.starwarsresistence.starWarsResistence.gateways.controllers.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class MessageResponseDTO {
    private String message;
}
