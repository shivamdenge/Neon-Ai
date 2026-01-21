package com.shivamdenge.NeonAi.repository;

import com.shivamdenge.NeonAi.dto.member.MemberResponseDTo;
import com.shivamdenge.NeonAi.entity.ProjectMember;
import com.shivamdenge.NeonAi.entity.ProjectMemberId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);
}
