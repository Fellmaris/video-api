package com.examples.service;

import com.examples.entity.Video;
import com.examples.exeption.VideoNotFoundExeption;
import com.examples.repository.VideoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoService {
    private final VideoRepository videoRepository;

    public VideoService(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    public void createVideo (Video video){
        videoRepository.save(video);
    }

    public List<Video> getVideos (){
        return videoRepository.findAll();
    }

    public Video getVideo (UUID id){return videoRepository.findById(id).orElseThrow(()-> new VideoNotFoundExeption(id));}

    public void updateVideo (Video video) {videoRepository.save(video);}

    public void deleteVideo (UUID id){videoRepository.deleteById(id);}

    public List<Video> searchVideoByNameAndDescription (String query) {return videoRepository.findByNameContainingOrDescriptionContaining(query,query);}

}
