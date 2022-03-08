package com.starwarsresistence.starWarsResistence.mappers;

import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.starwarsresistence.starWarsResistence.gateways.controllers.requests.RebelRequest;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RebelMapper {
    RebelMapper INSTANCE = Mappers.getMapper(RebelMapper.class);

    Rebel toModel(RebelRequest rebelRequest);

    RebelRequest toDTO(Rebel rebel);
}