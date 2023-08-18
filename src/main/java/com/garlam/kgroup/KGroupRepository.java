package com.garlam.kgroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KGroupRepository extends JpaRepository<KGroup, Long> {
    void deleteKGroupById(long id);

    List<KGroup>  getAllByCompanyIgnoreCase (String company);

    @Query(value = "SELECT DISTINCT company FROM group", nativeQuery = true)
    List<String> getDistinctCompanies();

    List<KGroup>  getAllByTypeIgnoreCase (String type);


    @Query(value = "SELECT DISTINCT type FROM group", nativeQuery = true)
    List<String> getDistinctTypes();


}
