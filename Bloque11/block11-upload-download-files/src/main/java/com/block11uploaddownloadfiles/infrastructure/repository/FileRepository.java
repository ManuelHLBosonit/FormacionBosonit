package com.block11uploaddownloadfiles.infrastructure.repository;

import com.block11uploaddownloadfiles.domain.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FileRepository extends JpaRepository<FileEntity, Long> {
    Optional<FileEntity> findByFileName(String fileName);
}