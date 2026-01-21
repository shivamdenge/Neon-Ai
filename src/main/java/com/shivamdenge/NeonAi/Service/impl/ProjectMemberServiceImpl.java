package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.ProjectMemberService;
import com.shivamdenge.NeonAi.dto.member.InviteMemberRequestDTO;
import com.shivamdenge.NeonAi.dto.member.MemberResponseDTo;
import com.shivamdenge.NeonAi.dto.member.UpdateMemberRoleRequestDTO;
import com.shivamdenge.NeonAi.entity.Project;
import com.shivamdenge.NeonAi.entity.ProjectMember;
import com.shivamdenge.NeonAi.entity.ProjectMemberId;
import com.shivamdenge.NeonAi.entity.User;
import com.shivamdenge.NeonAi.mapper.ProjectMemberMapper;
import com.shivamdenge.NeonAi.repository.ProjectMemberRepository;
import com.shivamdenge.NeonAi.repository.ProjectRepository;
import com.shivamdenge.NeonAi.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;
    private final ProjectMemberMapper projectMemberMapper;


    @Override
    public List<MemberResponseDTo> getProjectMembers(Long projectId, Long userId) {
        Project project = getAccessibleProjectById(projectId, userId);

        List<MemberResponseDTo> memberResponseList = new ArrayList<>();
        //Here We Added Owner Because Owner is also part of project
        memberResponseList.add(projectMemberMapper.toProjectMemberResponseFromOwner(project.getOwner()));

        memberResponseList.addAll(projectMemberRepository.findByIdProjectId(projectId).stream().map(projectMemberMapper::toProjectMemberResponseFromMember).toList());

        return memberResponseList;
    }

    @Override
    public MemberResponseDTo inviteMember(Long projectId, InviteMemberRequestDTO request, Long userId) {

        Project project = getAccessibleProjectById(projectId, userId);
        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Not Allowed");
        }

        User invitee = userRepository.findByEmail(request.email()).orElseThrow();

        if (invitee.getId().equals(userId)) {
            throw new RuntimeException("Cannot invite yourself");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, invitee.getId());

        if (projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("you cannot invite once again");
        }

        ProjectMember projectMember = ProjectMember.builder().id(projectMemberId).project(project).user(invitee).projectRole(request.role()).invitedAt(Instant.now()).build();

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);
    }

    @Override
    public MemberResponseDTo updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequestDTO request, Long userId) {

        Project project = getAccessibleProjectById(projectId, userId);

        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Not Allowed");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);
        ProjectMember projectMember = projectMemberRepository.findById(projectMemberId).orElseThrow();

        projectMember.setProjectRole(request.role());

        projectMemberRepository.save(projectMember);

        return projectMemberMapper.toProjectMemberResponseFromMember(projectMember);

    }

    @Override
    public void removeProjectMember(Long projectId, Long memberId, Long userId) {

        Project project = getAccessibleProjectById(projectId, userId);

        if (!project.getOwner().getId().equals(userId)) {
            throw new RuntimeException("Not Allowed");
        }

        ProjectMemberId projectMemberId = new ProjectMemberId(projectId, memberId);

        if (!projectMemberRepository.existsById(projectMemberId)) {
            throw new RuntimeException("Member Not Exist");
        }

        projectMemberRepository.deleteById(projectMemberId);
    }

    /// INTERNAL FUNCTION

    public Project getAccessibleProjectById(Long id, Long userId) {
        return projectRepository.findAccessibleByProjectId(id, userId).orElseThrow();
    }
}
