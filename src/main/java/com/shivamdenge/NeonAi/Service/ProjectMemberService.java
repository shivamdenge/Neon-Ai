package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.member.InviteMemberRequestDTO;
import com.shivamdenge.NeonAi.dto.member.MemberResponseDTo;
import com.shivamdenge.NeonAi.dto.member.UpdateMemberRoleRequestDTO;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponseDTo> getProjectMembers(Long projectId);

    MemberResponseDTo inviteMember(Long projectId, InviteMemberRequestDTO request);

    MemberResponseDTo updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequestDTO request);

    void removeProjectMember(Long projectId, Long memberId);
}
