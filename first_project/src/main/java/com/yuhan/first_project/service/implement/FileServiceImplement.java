package com.yuhan.first_project.service.implement;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import com.yuhan.first_project.service.FileService;

@Service
public class FileServiceImplement implements FileService {

    @Value("${file.path}")
    private String FILE_PATH;

    @Value("${file.url}")
    private String FILE_URL;

    @Override
    public String upload(MultipartFile file) {
        // 빈 값 검증
        if (file.isEmpty())
            return null;

        // 파일 명 가져오기
        String originalFileName = file.getOriginalFilename();

        // 확장자 가져오기
        int extensionIndex = originalFileName.lastIndexOf(".");
        String extension = originalFileName.substring(extensionIndex);

        // 파일을 사람들이 올렸을때 이름 그대로 저장하면 겹칠 수도 있다.
        // 그래서 새로운 파일들로 지정을 해주는게 좋다.

        // 파일의 새로운 이름 지정
        String uuid = UUID.randomUUID().toString();
        String saveName = uuid + extension; // uuid.확장자 로 바뀜

        // 파일저장 경로 지정
        String savePath = FILE_PATH + saveName;

        try {
            // 파일 저장
            file.transferTo(new File(savePath)); // java.io.file
        } catch (Exception exception) {
            exception.printStackTrace();
            return null;
        }

        // 클라이언트가 해당 파일에 접근하기 위한 url

        String fileUrl = FILE_URL + saveName;
        return fileUrl;
    }

    @Override
    public Resource getFile(String fileName) {

        Resource file = null;
        try {
             // 파일을 URL로 가져오기
            String url = "file:" + FILE_PATH + fileName;
            file = new UrlResource(url);

        } catch (Exception exception) {
            exception.printStackTrace();

        }
        return file;
    }

}
