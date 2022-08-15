package com.binan.buy.service;

import org.springframework.core.io.FileSystemResource;
import org.springframework.http.ResponseEntity;

public interface IFileService {
    ResponseEntity<FileSystemResource> getFile(String filename);
}
