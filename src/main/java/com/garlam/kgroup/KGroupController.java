package com.garlam.kgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class KGroupController {

    @Autowired
    KGroupService KGroupService;

    @ExceptionHandler
    public ResponseEntity<String> handleExeptions(RuntimeException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    //WRITE
    @PostMapping("/group")
    public ResponseEntity<KGroup> createKGroup(@RequestBody KGroup kGroup){
        KGroupService.addKGroup(kGroup);
        return ResponseEntity.status(HttpStatus.CREATED).body(kGroup);
    }

    //READ
    @GetMapping("/groups")
    public ResponseEntity<List<KGroup>> getKGroups(@RequestParam(required = false) String company,
                                                   @RequestParam(required = false) String type,
                                                   @RequestParam(defaultValue = "20") int limit){
        if(company != null){
            return ResponseEntity.status(HttpStatus.OK).body(KGroupService.getKGroupsByCompany(company));
        }
        if(type != null){
            return ResponseEntity.status(HttpStatus.OK).body(KGroupService.getKGroupsByType(type));
        }
        return ResponseEntity.status(HttpStatus.OK).body(KGroupService.getAllKGroups(limit));
    }

    @GetMapping("/groups/companies")
    public ResponseEntity<List<String>> getCompanies(){
        return ResponseEntity.status(HttpStatus.OK).body(KGroupService.getCompanies());
    }

    @GetMapping("/groups/types")
    public ResponseEntity<List<String>> getTypes(){
        return ResponseEntity.status(HttpStatus.OK).body(KGroupService.getTypes());
    }

    @GetMapping("/groups/count")
    public ResponseEntity<Long> getGroupCount(){
        return ResponseEntity.status(HttpStatus.OK).body(KGroupService.getNumberOfKGroups());
    }

    @GetMapping("/groups/{id}")
    public ResponseEntity<KGroup> getGroupById(@PathVariable long id){
        return ResponseEntity.status(HttpStatus.OK).body(KGroupService.getKGroupById(id));
    }

    //UPDATE

    @PutMapping("/groups/{id}")
    public ResponseEntity<KGroup> updatePlayer(@RequestBody KGroup newKGroup, @PathVariable long id){
        newKGroup.setId(id);
        KGroupService.updateKGroup(newKGroup,id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(newKGroup);
    }

    //DELETE
    @DeleteMapping("/groups/{id}")
    public String deleteGroupById(@PathVariable long id) {
        KGroupService.deleteKGroupByID(id);
        return "Deleted Group";
    }
}

