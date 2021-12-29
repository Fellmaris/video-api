package com.examples.controller;

import static com.examples.ApiPath.*;
import com.examples.entity.Video;
import com.examples.service.VideoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(VIDEOS)
public class VideoController {

    private final VideoService videoService;

    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List <Video> getVideos(){return videoService.getVideos();}

    @GetMapping(value = VIDEO, produces = MediaType.APPLICATION_JSON_VALUE)
    public Video getVideo (@PathVariable(ID_VARIABLE)UUID id) {return videoService.getVideo(id);}

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus (HttpStatus.CREATED)
    public void createVideo (@RequestBody Video video){videoService.createVideo(video);}

    @PutMapping (consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateVideo (@RequestBody Video video) {videoService.updateVideo(video);}

    @DeleteMapping(VIDEO)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteVideo (@PathVariable (ID_VARIABLE) UUID id) {videoService.deleteVideo(id);}

    @GetMapping(SEARCH)
    public List<Video> searchVideos (@RequestParam String query){
        return videoService.searchVideoByNameAndDescription(query);
    }
}
