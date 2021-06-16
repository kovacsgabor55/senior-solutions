package meetingrooms.dao;

import meetingrooms.entity.MeetingRoom;

import java.util.List;

public interface MeetingRoomsRepository {
    void save(String name, int width, int height);

    List<MeetingRoom> findAll();

    void deleteAll();

    List<String> listMeetingRoomsByName();

    List<String> listMeetingRoomsByNameReverse();
}
