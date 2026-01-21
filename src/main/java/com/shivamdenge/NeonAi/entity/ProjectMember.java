package com.shivamdenge.NeonAi.entity;

import com.shivamdenge.NeonAi.enums.ProjectRole;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="project_members")
public class ProjectMember {

    @EmbeddedId
    ProjectMemberId id;

    @ManyToOne
    @MapsId("projectId")
    Project project;

    @ManyToOne
    @MapsId("userId")
    User user;

    @Enumerated(value = EnumType.STRING)
    ProjectRole projectRole;

    Instant invitedAt;
    Instant acceptedAt;
}