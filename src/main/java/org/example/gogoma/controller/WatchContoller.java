package org.example.gogoma.controller;


import lombok.RequiredArgsConstructor;
import org.example.gogoma.controller.response.MarathonStartInitDataResponse;
import org.example.gogoma.domain.watch.dto.MarathonReadyDto;
import org.example.gogoma.domain.watch.service.WatchService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/watch")
public class WatchContoller {

    private final WatchService watchService;

    @GetMapping("/start/marathons/{marathonId}")
    public ResponseEntity<MarathonStartInitDataResponse> sendMarathonStartInitData(
            @RequestHeader("Authorization") String accessToken, @PathVariable int marathonId) {

        MarathonStartInitDataResponse marathonStartInitDataResponse =
                watchService.sendMarathonStartInitData(accessToken, marathonId);

        return ResponseEntity.ok(marathonStartInitDataResponse);
    }

    @GetMapping("/start/marathons/{marathonId}/users/{userId}")
    public ResponseEntity<MarathonReadyDto> send(
            @PathVariable int userId, @PathVariable int marathonId) {

        MarathonReadyDto marathonReadyDto =
                watchService.send(userId, marathonId);

        return ResponseEntity.ok(marathonReadyDto);
    }
}
