package com.mehdi.project_school.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "authorities")
public class Authority implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRoleName name;

    /**
     * Get authority.
     *
     * @return authority of user.
     */
    @Override
    public String getAuthority() {
        return name.name();
    }

    /**
     * Get Role name.
     *
     * @return Role name.
     */
    @JsonIgnore
    public UserRoleName getName() {
        return name;
    }

    /**
     * Get role id.
     *
     * @return Id of the Authority.
     */
    @JsonIgnore
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(UserRoleName name) {
        this.name = name;
    }


}
