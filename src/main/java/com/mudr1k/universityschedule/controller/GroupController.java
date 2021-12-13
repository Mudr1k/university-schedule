package com.mudr1k.universityschedule.controller;

import com.mudr1k.universityschedule.entity.Group;
import com.mudr1k.universityschedule.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("rest/api/v1/groups")
public class GroupController {

    private final GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping(path = "")
    public List<Group> getAllGroups() {
        return groupService.findAll();
    }

    @PostMapping(path = "")
    public void create(@RequestBody Group group) {
        groupService.create(group);
    }

    @PutMapping(path = "")
    public void update(@RequestBody Group group) {
        groupService.update(group);
    }

    @DeleteMapping(path = "/{groupId}")
    public void delete(@PathVariable Long groupId) {
        groupService.delete(groupId);
    }
}
