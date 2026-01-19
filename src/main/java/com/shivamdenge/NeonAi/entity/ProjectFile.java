package com.shivamdenge.NeonAi.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectFile {

    Long id;

    Project project;

    String path;

    String miniObjectKey;

    Instant createdAt;

    Instant updatedAt;

    User createdBy;

    User updatedBy;
}