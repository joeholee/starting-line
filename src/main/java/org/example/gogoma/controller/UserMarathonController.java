package org.example.gogoma.controller;

import lombok.RequiredArgsConstructor;
import org.example.gogoma.common.dto.BooleanResponse;
import org.example.gogoma.controller.request.UpdateUserMarathonRequest;
import org.example.gogoma.controller.response.UpdateUserMarathonResponse;
import org.example.gogoma.controller.response.UserMarathonDetailResponse;
import org.example.gogoma.controller.response.UserMarathonSearchResponse;
import org.example.gogoma.domain.usermarathon.service.UserMarathonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/usermarathons")
public class UserMarathonController {

    private final UserMarathonService userMarathonService;

    @GetMapping
    public ResponseEntity<UserMarathonSearchResponse> searchUserMarathonList(
            @RequestHeader("Authorization") String accessToken) {

        UserMarathonSearchResponse userMarathonSearchResponse =
                userMarathonService.searchUserMarathonList(accessToken);

        return ResponseEntity.ok(userMarathonSearchResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserMarathonDetailResponse> getUserMarathonById(
            @RequestHeader("Authorization") String accessToken, @PathVariable int id) {

        UserMarathonDetailResponse userMarathonDetailResponse =
                userMarathonService.getUserMarathonById(accessToken, id);

        return ResponseEntity.ok(userMarathonDetailResponse);
    }

    @PatchMapping("/{marathonId}")
    public ResponseEntity<BooleanResponse> updateUserMarathon(
            @RequestHeader("Authorization") String accessToken,
            @PathVariable int marathonId,
            @RequestBody UpdateUserMarathonRequest updateUserMarathonRequest) {

        userMarathonService.updateUserMarathon(accessToken, marathonId, updateUserMarathonRequest.getTargetPace());

        return ResponseEntity.ok(BooleanResponse.success());
    }

    @GetMapping("/{marathonId}")
    public ResponseEntity<BooleanResponse> checkDuplicateUserMarathon(
            @RequestHeader("Authorization") String accessToken,
            @PathVariable int marathonId) {

        userMarathonService.checkDuplicateUserMarathon(accessToken, marathonId);

        return ResponseEntity.ok(BooleanResponse.success());
    }
}
