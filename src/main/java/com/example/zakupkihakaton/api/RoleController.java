//package com.example.zakupkihakaton.api;
//
//import com.example.zakupkihakaton.model.response.PermissionCategoryResponse;
//import com.example.zakupkihakaton.model.request.RoleRequest;
//import com.example.zakupkihakaton.model.response.RoleResponse;
//import com.example.zakupkihakaton.service.RoleService;
//import lombok.AccessLevel;
//import lombok.RequiredArgsConstructor;
//import lombok.experimental.FieldDefaults;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/role")
//@RequiredArgsConstructor
//@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
//public class RoleController {
//    RoleService roleService;
//
//    @PostMapping("/")
//    public ResponseEntity<RoleResponse> create(@Valid @RequestBody RoleRequest request) {
//        RoleResponse response = roleService.create(request);
//        return new ResponseEntity<>(response, HttpStatus.CREATED);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<RoleResponse> update(@Valid @RequestBody RoleRequest request, @PathVariable Short id) {
//        RoleResponse response = roleService.update(request, id);
//        return new ResponseEntity<>(response, HttpStatus.OK);
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<RoleResponse> getById(@PathVariable Short id) {
//        RoleResponse roleResponse = roleService.findById(id);
//        return new ResponseEntity<>(roleResponse, HttpStatus.OK);
//    }
//
//    @GetMapping("/")
//    @ResponseStatus(HttpStatus.OK)
//    public List<RoleResponse> findAll() {
//        return roleService.findAll();
//    }
//
//    @GetMapping("/permission/")
//    @ResponseStatus(HttpStatus.OK)
//    public List<PermissionCategoryResponse> getPermissions() {
//        return roleService.getPermissions();
//    }
//
//    @DeleteMapping("/{id}")
//    public Boolean delete(@PathVariable Short id) {
//        return roleService.delete(id);
//    }
//}
