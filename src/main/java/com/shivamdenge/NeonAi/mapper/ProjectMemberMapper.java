package com.shivamdenge.NeonAi.mapper;

import com.shivamdenge.NeonAi.dto.member.MemberResponseDTo;

import com.shivamdenge.NeonAi.entity.ProjectMember;
import com.shivamdenge.NeonAi.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {

    @Mapping(target = "userId", source = "id")
    @Mapping(target = "projectRole", constant = "OWNER")
    MemberResponseDTo toProjectMemberResponseFromOwner(User owner);

    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "username", source = "user.username")
    @Mapping(target = "name", source = "user.name")
    MemberResponseDTo toProjectMemberResponseFromMember(ProjectMember projectMember);
}