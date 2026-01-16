package org.cedacri.spring.scheduleservice.mappers.schedule;

import org.cedacri.spring.scheduleservice.domain.Schedule;
import org.cedacri.spring.scheduleservice.dto_s.domain.schedule.ScheduleBaseDto;
import org.cedacri.spring.scheduleservice.dto_s.domain.schedule.ScheduleCreateDto;
import org.cedacri.spring.scheduleservice.dto_s.domain.schedule.ScheduleUpdateDto;

public class ScheduleMapper {


    public static ScheduleBaseDto mapToBaseDto(Schedule schedule) {
        return new ScheduleBaseDto(
                schedule.getId(), schedule.getStartTime(), schedule.getEndTime(), schedule.getWeekDays(), null, null, null
        );
    }


    // TODO: groupCourseId, teacherId (from feign request), classRoomId
    public static Schedule mapScheduleUpdateDtoToEntity(ScheduleUpdateDto dto){
        return new Schedule(
                dto.getStartTime(), dto.getEndTime(), dto.getWeekDays(), null, null, null
        );
    }

    // TODO: groupCourseId, teacherId (from feign request), classRoomId
    public static Schedule mapScheduleCreateDtoToEntity(ScheduleCreateDto dto) {
        return new Schedule(
                dto.getStartTime(), dto.getEndTime(), dto.getWeekDays(), null, null, null
        );
    }
}
