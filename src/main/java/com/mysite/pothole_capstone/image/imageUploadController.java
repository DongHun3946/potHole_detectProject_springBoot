package com.mysite.pothole_capstone.image;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/api")
public class imageUploadController {
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        if(file.isEmpty()){
            return "파일이 없습니다.";
        }
        String saveDir = "C:/Users/cdh39/pothole_capstone/src/main/resources/static/pothole_images/";
        File saveFile = new File(saveDir + file.getOriginalFilename());

        try{
            file.transferTo(saveFile);
            return "파일이 업로드 되었습니다.";
        }
        catch(IOException e){
            e.printStackTrace();
            return "파일 업로드에 실패했습니다" + e.getMessage();
        }
    }
}
