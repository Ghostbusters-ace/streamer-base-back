package fr.aelion.streamer.services;

import fr.aelion.streamer.dto.AddCourseDto;
import fr.aelion.streamer.dto.FullCourseDto;

import java.util.List;

public interface CourseService {

    List<FullCourseDto> findAll();
     FullCourseDto findOne(int id);
    void remove(int id);
    FullCourseDto add(AddCourseDto courseDto);
}
