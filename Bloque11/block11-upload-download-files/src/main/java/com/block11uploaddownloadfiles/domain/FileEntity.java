package com.block11uploaddownloadfiles.domain;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class FileEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String fileName;
    private Date uploadDate;
    private String category;


}