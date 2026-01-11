package com.teachsync.courseservice.dto_s.groups;

public class GroupBaseDto {
    private String name;

    public GroupBaseDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
