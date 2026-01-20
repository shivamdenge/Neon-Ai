package com.shivamdenge.NeonAi.Service;

import com.shivamdenge.NeonAi.dto.member.InviteMemberRequestDTO;
import com.shivamdenge.NeonAi.dto.member.MemberResponseDTo;
import com.shivamdenge.NeonAi.dto.member.UpdateMemberRoleRequestDTO;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponseDTo> getProjectMembers(Long projectId, Long userId);

    MemberResponseDTo inviteMember(Long projectId, InviteMemberRequestDTO request, Long userId);

    MemberResponseDTo updateMemberRole(Long projectId, Long memberId, UpdateMemberRoleRequestDTO request, Long userId);

    MemberResponseDTo deleteProjectMember(Long projectId, Long memberId, Long userId);
}
