package com.yuhan.first_project.controller;


import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.yuhan.first_project.common.constant.RequestPattern;
import com.yuhan.first_project.service.FileService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(RequestPattern.FILE_API)
@RequiredArgsConstructor

public class FileController {

    private final FileService fileService;

    private final String UPLOAD_URL = "upload";
    private final String GET_URL = "{fileName}";
    
    //파일 업로드 
    @PostMapping(UPLOAD_URL)
    public String upload(
        @RequestParam("file") MultipartFile file
    ) {
        return fileService.upload(file);
    }

    // 파일 불러오기
    @GetMapping(value=GET_URL, produces={MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    public Resource getFile(
        @PathVariable("fileName") String fileName
    ) {
        
        return fileService.getFile(fileName);
    }

}