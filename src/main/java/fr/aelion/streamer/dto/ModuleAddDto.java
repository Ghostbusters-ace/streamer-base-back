package fr.aelion.streamer.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModuleAddDto {

    @NotBlank(message = "Module name cannot be null")
    private String name;

    private String objective;
}
