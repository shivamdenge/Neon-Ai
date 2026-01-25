package com.shivamdenge.NeonAi.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.shivamdenge.NeonAi.enums.ProjectPermission.*;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {

    EDITOR(VIEW,EDIT,DELETE,VIEW_MEMBERS),
    VIEWER(Set.of(VIEW)),
    OWNER(Set.of(VIEW,EDIT,DELETE,MANAGE_MEMBERS,VIEW_MEMBERS));


    ProjectRole(ProjectPermission... permissions) {
        this.permissions = Set.of(permissions);
    }

    private final Set<ProjectPermission> permissions;
}



/*
    //THIS IS ONE WAY TO MAP PERMISSION WITH ROLE
    EDITOR(OWNER(Set.of(VIEW,EDIT,DELETE));),
    VIEWER(Set.of(VIEW)),
    OWNER(Set.of(VIEW,EDIT,DELETE,MANAGE_MEMBERS));


    private final Set<ProjectPermission> permissions;
    }*/

/*
    THIS IS A SECOND WAY TO MAP PERMISSIONS WITH ROLES
    EDITOR(VIEW,EDIT,DELETE),
    VIEWER(VIEW),
    OWNER(VIEW,EDIT,DELETE,MANAGE_MEMBERS);


    ProjectRole(ProjectPermission... permissions) {
        this.permissions = Set.of(permissions);
    }
*/