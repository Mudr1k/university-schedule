package com.mudr1k.universityschedule.service;

import com.mudr1k.universityschedule.entity.Group;
import com.mudr1k.universityschedule.repository.GroupRepository;
import com.mudr1k.universityschedule.response.RestApiException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;

    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public List<Group> findAll() {
        return groupRepository.findAll();
    }

    public void create(Group group) {
        if (groupRepository.findGroupByName(group.getName()).isPresent()) {
            throw new RestApiException("The group '" + group.getName() + "' already exists");
        }
        groupRepository.save(group);
    }

    public void update(Group group) {
        Optional<Group> row = groupRepository.findById(group.getId());
        if (row.isPresent()) {
            Group item = row.get();
            if (!group.getName().isEmpty()) {
                item.setName(group.getName());
            }
            groupRepository.save(item);
        }
    }

    public void delete(Long groupId) {
        groupRepository.deleteById(groupId);
    }
}
