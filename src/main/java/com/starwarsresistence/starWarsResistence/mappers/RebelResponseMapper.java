package com.starwarsresistence.starWarsResistence.mappers;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.gateways.controllers.responses.RebelResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RebelResponseMapper {
    RebelResponseMapper INSTANCE = Mappers.getMapper(RebelResponseMapper.class);

    Rebel toModel(RebelResponse rebelResponse);

    RebelResponse toDTO(Rebel rebel);
}
