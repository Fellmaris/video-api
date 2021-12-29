package com.examples.controller;


import com.examples.service.FileService;
import io.swagger.annotations.Api;
import static com.examples.ApiPath.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping(FILES)
@Api (tags = "Upload/download files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @ApiOperation(value = "Upload file to server", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200 , message = "Failas issaugotas sekmingai"),
            @ApiResponse(code = 403, message = "Neturi permisionu"),
            @ApiResponse(code= 401, message = "Neprisijunges")
    })
    @PostMapping
    public void saveFilesInFileSystem(@RequestParam MultipartFile multipartFile) {
        fileService.saveFileInFileSystem(multipartFile);
    }

    @ApiOperation(value = "Download file from server by name", httpMethod = "GET")
    @ApiResponses(value = {
            @ApiResponse(code = 200 , message = "Failas parsiustas sekmingai"),
            @ApiResponse(code = 403, message = "Neturi permisionu"),
            @ApiResponse(code= 401, message = "Neprisijunges")
    })
    @GetMapping(FILE_BY_NAME)
    public ResponseEntity<Resource> getFileByNameFromFileSystem(@PathVariable(NAME_VARIABLE) String fileName){

        Resource resource = new InputStreamResource(fileService.getFileFromFileSystemByName(fileName));

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition", "attachment; filename=\"" + fileName + "\"");


        return ResponseEntity.ok()
                .body(resource);
    }
}
