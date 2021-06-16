package meetingrooms.service;

import meetingrooms.dao.MeetingRoomsRepository;
import meetingrooms.entity.MeetingRoom;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MeetingRoomsService {

    private MeetingRoomsRepository meetingRoomsRepository;

    public MeetingRoomsService(MeetingRoomsRepository meetingRoomsRepository) {
        this.meetingRoomsRepository = meetingRoomsRepository;
    }

    public void save(String name, int width, int height) {
        meetingRoomsRepository.save(name, width, height);
    }

    public List<MeetingRoom> listMeetingRoom() {
        return meetingRoomsRepository.findAll();
    }

    public void deleteAll() {
        meetingRoomsRepository.deleteAll();
    }

    public List<String> everySecond() {
        List<String> ordered = meetingRoomsRepository.listMeetingRoomsByName();

        return IntStream.range(0, ordered.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(ordered::get)
                .collect(Collectors.toList());
    }
}
