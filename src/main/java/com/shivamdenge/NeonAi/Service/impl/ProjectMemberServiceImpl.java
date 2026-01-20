package com.shivamdenge.NeonAi.Service.impl;

import com.shivamdenge.NeonAi.Service.ProjectMemberService;
import com.shivamdenge.NeonAi.dto.member.InviteMemberRequestDTO;
import com.shivamdenge.NeonAi.dto.member.MemberResponseDTo;
import com.shivamdenge.NeonAi.dto.member.UpdateMemberRoleRequestDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberServiceImpl implements ProjectMemberService {
    @Override
    public List<MemberResponseDTo> getProjectMembers(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponseDTo inviteMember(Long projectId, InviteMemberRequestDTO request, Long userId) {
        return null;
    }

    @Override
    public MemberResponseDTo updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequestDTO request, Long userId) {
        return null;
    }

    @Override
    public MemberResponseDTo deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
