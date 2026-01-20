package com.shivamdenge.NeonAi.controller;

import com.shivamdenge.NeonAi.Service.ProjectMemberService;
import com.shivamdenge.NeonAi.dto.member.InviteMemberRequestDTO;
import com.shivamdenge.NeonAi.dto.member.MemberResponseDTo;
import com.shivamdenge.NeonAi.dto.member.UpdateMemberRoleRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects/{projectId}/members")
@RequiredArgsConstructor
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;

    @GetMapping
    public ResponseEntity<List<MemberResponseDTo>> getProjectMembers(@PathVariable Long projectId) {
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId, userId));
    }

    @PostMapping()
    public ResponseEntity<MemberResponseDTo> invitedMember(
            @PathVariable Long projectId,
            @RequestBody InviteMemberRequestDTO request
    ) {
        Long userId = 1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(
                projectMemberService.inviteMember(projectId, request, userId)
        );
    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponseDTo> updateMemberRole(
            @PathVariable Long projectId,
            @RequestBody Long memberId,
            @RequestBody UpdateMemberRoleRequestDTO request
    ) {
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId, memberId, request, userId));
    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<MemberResponseDTo> deleteProjectMember(
            @PathVariable Long projectId,
            @RequestBody Long memberId
    ) {
        Long userId = 1L;
        return ResponseEntity.ok(projectMemberService.deleteProjectMember(projectId, memberId,userId));
    }
}