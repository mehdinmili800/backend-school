package com.mehdi.project_school.repository.user;


import com.mehdi.project_school.entity.user.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Authority findByName(String name);

    @Modifying
    @Query(value = "INSERT INTO authorities(name) VALUES (:roleName)", nativeQuery = true)
    @Transactional
    void saveAuth(@Param("roleName") String roleName);
}
