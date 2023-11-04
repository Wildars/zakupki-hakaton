package com.example.zakupkihakaton.api;

import com.example.zakupkihakaton.convert.UserElement;
import com.example.zakupkihakaton.model.request.UserRequest;
import com.example.zakupkihakaton.model.response.UserResponse;
import com.example.zakupkihakaton.service.UserService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class UserController {
    UserService userService;

    @PostMapping("/")
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserRequest request) {
        UserResponse response = userService.save(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@Valid @RequestBody UserRequest request, @PathVariable UUID id) {
        UserResponse response = userService.update(request, id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable UUID id) {
        UserResponse userResponse = userService.findById(id);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }

    @GetMapping("/")
    public Page<UserResponse> findAll(@RequestParam(defaultValue = "0") int page,
                                      @RequestParam(defaultValue = "25") int size) {
        return userService.findAll(page, size);
    }

    @GetMapping("/managers")
    @ResponseStatus(HttpStatus.OK)
    public List<UserElement> findManagers() {
        return userService.findManagers();
    }

    @GetMapping("/developer")
    @ResponseStatus(HttpStatus.OK)
    public List<UserElement> findDevelopers() {
        return userService.findDevelopers();
    }

    @GetMapping("/event")
    @ResponseStatus(HttpStatus.OK)
    public List<UserElement> findForEvent() {
        return userService.findForEvent();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id) {
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Void> restore(@PathVariable UUID id) {
        userService.restore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/find/region")
    public Page<UserResponse> findRegion(
            @RequestParam(required = false) Short regionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size
    ) {
        return userService.findRegion(
                regionId,
                page,
                size
        );
    }

    @GetMapping("/find/oz")
    public Page<UserResponse> findOZ(
            @RequestParam(required = false) Long OZid,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "25") int size
    ) {
        return userService.findOZ(
                OZid,
                page,
                size
        );
    }
}
