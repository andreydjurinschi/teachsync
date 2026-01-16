package org.cedacri.spring.scheduleservice.dto_s.domain.schedule;


import org.cedacri.spring.scheduleservice.dto_s.domain.class_room.ClassRoomBaseDto;
import org.cedacri.spring.scheduleservice.dto_s.feign.GroupCourseDto;
import org.cedacri.spring.scheduleservice.domain.WeekDays;
import org.cedacri.spring.scheduleservice.dto_s.feign.TeacherDto;

import java.time.LocalTime;
import java.util.Set;

public class ScheduleBaseDto {
    private Long id;
    private LocalTime startTime;
    private LocalTime endTime;
    private Set<WeekDays> weekDays;
    private GroupCourseDto groupCourseId;
    private TeacherDto teacherId;
    private ClassRoomBaseDto dto;

    public ScheduleBaseDto(Long id, LocalTime startTime, LocalTime endTime, Set<WeekDays> weekDays, GroupCourseDto groupCourseId, TeacherDto teacherId, ClassRoomBaseDto dto) {
        this.id = id;
        this.startTime = startTime;
        this.endTime = endTime;
        this.weekDays = weekDays;
        this.groupCourseId = groupCourseId;
        this.teacherId = teacherId;
        this.dto = dto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Set<WeekDays> getWeekDays() {
        return weekDays;
    }

    public void setWeekDays(Set<WeekDays> weekDays) {
        this.weekDays = weekDays;
    }

    public GroupCourseDto getGroupCourseId() {
        return groupCourseId;
    }

    public void setGroupCourseId(GroupCourseDto groupCourseId) {
        this.groupCourseId = groupCourseId;
    }

    public TeacherDto getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(TeacherDto teacherId) {
        this.teacherId = teacherId;
    }

    public ClassRoomBaseDto getDto() {
        return dto;
    }

    public void setDto(ClassRoomBaseDto dto) {
        this.dto = dto;
    }
}
