package com.block11uploaddownloadfiles.application;

import com.block11uploaddownloadfiles.domain.FileEntity;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface FileService {
    FileEntity updateFile(MultipartFile file, String category) throws IOException;

    Resource downloadFileById(Long id);

    Resource downloadFileByName(String name);

    void updatePath(String path);
}
