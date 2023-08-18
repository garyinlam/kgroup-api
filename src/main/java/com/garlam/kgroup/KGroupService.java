package com.garlam.kgroup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class KGroupService {

    @Autowired
    KGroupRepository KGroupRepository;

    //CREATE
    public void addKGroup(KGroup kGroup){
        KGroupRepository.save(kGroup);
    }

    //READ

    public KGroup getKGroupById(long id){
        Optional<KGroup> group = KGroupRepository.findById(id);
        if (group.isPresent()){
            return group.get();
        } else {
            throw new KGroupNotFoundException();
        }
    }

    public List<KGroup> getAllKGroups(int limit){
        return KGroupRepository.findAll()
                .stream()
                .limit(limit)
                .collect(Collectors.toList());
    }

    public List<String> getCompanies(){
        return KGroupRepository.getDistinctCompanies();
    }

    public List<KGroup> getKGroupsByCompany(String company){
        return KGroupRepository.getAllByCompanyIgnoreCase(company);
    }

    public List<String> getTypes(){
        return KGroupRepository.getDistinctTypes();
    }

    public List<KGroup> getKGroupsByType(String type){
        return KGroupRepository.getAllByTypeIgnoreCase(type);
    }

    public long getNumberOfKGroups() {
        return KGroupRepository.count();
    }

    //UPDATE

    public void updateKGroup(KGroup newKGroup, long id){
        if(!KGroupRepository.existsById(id)){
            throw new KGroupNotFoundException();
        }
        newKGroup.setId(id);
        KGroupRepository.save(newKGroup);
    }

    //DELETE
    public void deleteKGroupByID(long id){
        if(!KGroupRepository.existsById(id)){
            throw new KGroupNotFoundException();
        }
        KGroupRepository.deleteKGroupById(id);
    }

}
