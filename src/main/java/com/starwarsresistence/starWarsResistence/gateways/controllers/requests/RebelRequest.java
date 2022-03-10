package com.starwarsresistence.starWarsResistence.gateways.controllers.requests;

import com.starwarsresistence.starWarsResistence.domains.Bag;
import com.starwarsresistence.starWarsResistence.domains.Coordinates;
import com.starwarsresistence.starWarsResistence.domains.Rebel;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;

@AllArgsConstructor
@Setter
@Getter
@Builder
public class RebelRequest {

    @ApiModelProperty(required = true, value="Rebel's name", example = "João")
    private String name;

    @ApiModelProperty(required = true, value="Rebel's age", example = "37")
    private String age;

    @ApiModelProperty(required = true, value="Rebel's genre", example = "Male")
    private String genre;

    @ApiModelProperty(required = true, value="Rebel's bag", example = "Male")
    private BagRequest bag;

    @ApiModelProperty(required = true, value="Rebel's coordinates", example = "Male")
    private CoordinatesRequest coordinates;

    public Rebel toModel(){
        return Rebel.builder()
                .name(name)
                .age(age)
                .genre(genre)
                .bag(new Bag(bag))
                .coordinates(new Coordinates(coordinates))
                .build();
    }


}
