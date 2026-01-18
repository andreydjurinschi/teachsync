package org.cedacri.spring.scheduleservice.mappers.class_room;

import org.cedacri.spring.scheduleservice.domain.ClassRoom;
import org.cedacri.spring.scheduleservice.dto_s.domain.class_room.ClassRoomBaseDto;

public class ClassRoomMapper {
    public static ClassRoomBaseDto mapToBaseDto(ClassRoom classRoom){
        return new ClassRoomBaseDto(classRoom.getId(), classRoom.getName(), classRoom.getCapacity());
    }
}
