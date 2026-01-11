package com.teachsync.courseservice.requests.feign;

/**
 * references: UserTeacherResponse
 */
public class UserTeacherRequest {
    private Long id;
    private Role role;

    public UserTeacherRequest(Long id, Role role) {
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
