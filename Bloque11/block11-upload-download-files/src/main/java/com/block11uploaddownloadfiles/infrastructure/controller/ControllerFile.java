package com.block11uploaddownloadfiles.infrastructure.controller;

import com.block11uploaddownloadfiles.application.FileServiceImpl;
import com.block11uploaddownloadfiles.domain.FileMapper;
import com.block11uploaddownloadfiles.infrastructure.dto.FileOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("file")
public class ControllerFile {
    @Autowired
    FileServiceImpl fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileOutputDto> uploadFile(@RequestParam("file") MultipartFile file,
                                                    @RequestParam("category") String category) throws IOException {
        return ResponseEntity.ok().body(FileMapper.INSTANCE.FileToFileOutputDto(fileService.updateFile(file, category)));
    }
    @GetMapping("/findId")
    public ResponseEntity<Resource> downloadFileById(@RequestParam Long id) throws IOException {
        Resource resource = fileService.downloadFileById(id);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }

    @GetMapping("/findName")
    public ResponseEntity<Resource> downloadFileByName(@RequestParam String name){
        Resource resource = fileService.downloadFileByName(name);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                .body(resource);
    }



    @GetMapping("/setpath")
    public ResponseEntity<String> updatePathDirectory(@RequestParam String path){
        fileService.updatePath(path);
        return ResponseEntity.ok().body("Se ha actualizado el path a: " + path);
    }
}
