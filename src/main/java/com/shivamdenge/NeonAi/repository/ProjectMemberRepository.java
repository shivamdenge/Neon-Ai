package com.shivamdenge.NeonAi.repository;

import com.shivamdenge.NeonAi.entity.ProjectMember;
import com.shivamdenge.NeonAi.entity.ProjectMemberId;
import com.shivamdenge.NeonAi.enums.ProjectRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProjectMemberRepository extends JpaRepository<ProjectMember, ProjectMemberId> {

    List<ProjectMember> findByIdProjectId(Long projectId);

    @Query("""
    SELECT pm.projectRole FROM ProjectMember pm
     WHERE pm.id.userId = :userId 
     AND pm.id.projectId = :projectId
    """)
    Optional<ProjectRole>findRoleByProjectIdAndUserId(@Param("userId") Long userId,@Param("projectId") Long projectId);
}
