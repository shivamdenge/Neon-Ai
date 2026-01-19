package com.shivamdenge.NeonAi.entity;

import com.shivamdenge.NeonAi.enums.ProjectRole;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectMember {


    ProjectMemberId id;


    Project project;


    User user;

    @Enumerated(value = EnumType.STRING)
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}