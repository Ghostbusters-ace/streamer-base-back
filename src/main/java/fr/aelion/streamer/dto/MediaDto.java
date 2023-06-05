package fr.aelion.streamer.dto;

import fr.aelion.streamer.entities.Module;
import fr.aelion.streamer.entities.TypeMedia;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class MediaDto {

    private int id;

    private String title;

    private String summary;

    private Float duration;

    private LocalDate createdAt;

    private String url;

    private TypeMediaDto typeMedia;

//Le plus a JL pour recuperer toute la duree du module
    private String totalTime;


 /*   public void addType(TypeMedia typeMedia){

        var typeMediaDto = new TypeMediaDto();
        typeMediaDto.setId(typeMedia.getId());
        typeMediaDto.setTitle(typeMedia.getTitle());

        this.typeMedia = typeMediaDto;}
        */


}