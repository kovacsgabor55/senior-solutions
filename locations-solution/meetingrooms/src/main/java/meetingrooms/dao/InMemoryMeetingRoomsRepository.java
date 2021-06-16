package meetingrooms.dao;

import meetingrooms.entity.MeetingRoom;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class InMemoryMeetingRoomsRepository implements MeetingRoomsRepository {
    private List<MeetingRoom> meetingRooms = new ArrayList<>();

    @Override
    public void save(String name, int width, int height) {
        meetingRooms.add(new MeetingRoom(name, width, height));
    }

    @Override
    public List<MeetingRoom> findAll() {
        return meetingRooms.stream()
                .sorted(Comparator.comparing(MeetingRoom::getName))
                .collect(Collectors.toList());
    }

    @Override
    public void deleteAll() {
        meetingRooms.clear();
    }

    @Override
    public List<String> listMeetingRoomsByName() {
        return meetingRooms.stream()
                .map(MeetingRoom::getName)
                .sorted(Collator.getInstance(new Locale("hu", "HU")))
                .collect(Collectors.toList());
    }

    @Override
    public List<String> listMeetingRoomsByNameReverse() {
        return null;
    }
}
