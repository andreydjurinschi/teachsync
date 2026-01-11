package com.teachsync.responses.feign;

import com.teachsync.domain.Role;

public class UserTeacherResponse {
    private Long id;
    private Role role;

    public UserTeacherResponse(Long id, Role role) {
        this.id = id;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
