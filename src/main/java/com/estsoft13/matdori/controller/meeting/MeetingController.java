package com.estsoft13.matdori.controller.meeting;

import com.estsoft13.matdori.domain.User;
import com.estsoft13.matdori.dto.meeting.AddMeetingRequestDto;
import com.estsoft13.matdori.dto.meeting.MeetingResponseDto;
import com.estsoft13.matdori.dto.meeting.UpdateMeetingDto;
import com.estsoft13.matdori.service.MeetingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MeetingController {

    private final MeetingService meetingService;

    // 모임 전체 조회
    @GetMapping("/api/meetings")
    public List<MeetingResponseDto> getMeetings() {
        return meetingService.getMeetings();
    }

    // 모임 하나 조회
    @GetMapping("/api/meeting/{meetingId}")
    public MeetingResponseDto getOneMeeting(@PathVariable Long meetingId, @AuthenticationPrincipal User user) {
        return meetingService.getOneMeeting(meetingId, user);
    }

    // 모임 생성
    @PostMapping("/api/meeting")
    public MeetingResponseDto createMeeting(@ModelAttribute AddMeetingRequestDto addMeetingRequestDto) {
        return meetingService.createMeeting(addMeetingRequestDto);
    }

    // 모임 수정
    @PutMapping("/api/meeting/{meetingId}")
    public MeetingResponseDto updateMeeting(@PathVariable Long meetingId, @ModelAttribute UpdateMeetingDto updateMeetingDto) {
        return meetingService.updateMeeting(meetingId, updateMeetingDto);
    }

    // 모임 삭제
    @DeleteMapping("/api/meeting/{meetingId}")
    public ResponseEntity<Void> deleteMeeting(@PathVariable Long meetingId) {
        meetingService.deleteMeeting(meetingId);
        return ResponseEntity.ok().build();
    }
}
