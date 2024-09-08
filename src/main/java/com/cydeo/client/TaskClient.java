package com.cydeo.client;

import com.cydeo.dto.TaskResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

@FeignClient(value = "task-microservice", url = "localhost:8083")
public interface TaskClient {

    @GetMapping("/api/v1/task/count/project/{projectCode}")
    ResponseEntity<TaskResponse> getCountsByProject(@PathVariable("projectCode") String projectCode);

    @PutMapping("/api/v1/task/complete/project/{projectCode}")
    ResponseEntity<TaskResponse> completeByProject(@PathVariable("projectCode") String projectCode);

    @DeleteMapping("/api/v1/task/delete/project/{projectCode}")
    ResponseEntity<TaskResponse> deleteByProject(@PathVariable("projectCode") String projectCode);
}
