package fr.aelion.streamer.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class AddCourseDto {

    @NotBlank(message = "Title cannot be null")
    private String title;

    private String objective;

    private Set<ModuleAddDto> modules;

}
