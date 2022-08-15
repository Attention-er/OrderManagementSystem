package com.binan.buy.controller;

import com.binan.buy.service.IFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping(value = "/file")
public class FileController {
    IFileService fileService;

    @Autowired
    public void setFileService(IFileService fileService){
        this.fileService = fileService;
    }

    @GetMapping(value = "/getFile")
    @ResponseBody
    public ResponseEntity<FileSystemResource> getFile(String filename) throws IOException{
        System.out.println("输出文件"+filename);
        return fileService.getFile(filename);
    }

}
