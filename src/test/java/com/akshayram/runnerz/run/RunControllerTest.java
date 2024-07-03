package com.akshayram.runnerz.run;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class RunControllerTest {

    @InjectMocks
    RunController runController;

    @Mock
    RunService runService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreateRun() {
        Run run = new Run(1, "Test Run", "Active", LocalDateTime.now(), 5, LocalDateTime.now().plusHours(1), Location.OUTDOOR);
        when(runService.createRun(any(Run.class))).thenReturn(run);

        ResponseEntity<Run> response = runController.addRun(run);

        assertEquals(201, response.getStatusCode().value());

        assertEquals(run, response.getBody());
    }

    @Test
    void testGetRun() {
        Run run = new Run(1, "Test Run", "Active", LocalDateTime.now(), 5, LocalDateTime.now().plusHours(1), Location.OUTDOOR);
        when(runService.getRun(anyInt())).thenReturn(run);

        ResponseEntity<Run> response = runController.getRunById(1);

        assertEquals(200, response.getStatusCode().value());
        assertEquals(run, response.getBody());
    }

    @Test
    void testUpdateRun() {
        Run run = new Run(1, "Test Run", "Active", LocalDateTime.now(), 5, LocalDateTime.now().plusHours(1), Location.OUTDOOR);
        doNothing().when(runService).updateRun(run, 1);

        runController.updateRun(run, 1);

        verify(runService, times(1)).updateRun(run, 1);
    }

    @Test
    void testDeleteRun() {
        doNothing().when(runService).deleteRun(1);

        runController.deleteRun(1);

        verify(runService, times(1)).deleteRun(1);
    }

    @Test
    void testFindByLocation() {
        Run run = new Run(1, "Test Run", "Active", LocalDateTime.now(), 5, LocalDateTime.now().plusHours(1), Location.OUTDOOR);
        when(runService.findByLocation("OUTDOOR")).thenReturn(List.of(run));

        List<Run> response = runController.findByLocation("OUTDOOR");

        assertEquals(1, response.size());
        assertEquals(run, response.getFirst());
    }
}