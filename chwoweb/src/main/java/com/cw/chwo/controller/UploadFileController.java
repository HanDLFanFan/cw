package com.cw.chwo.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by handl on 2017/8/17.
 */
@RestController
public class UploadFileController {

    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public String upload(MultipartFile file){
        try {
            FileUtils.writeByteArrayToFile(new File("D:/uploadfile/"+file.getOriginalFilename()),
                    file.getBytes());
            return "upload ok!!!";
        } catch (IOException e) {
            e.printStackTrace();
            return "upload wrong!!!";
        }
    }

}
