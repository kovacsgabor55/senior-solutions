package meetingrooms;

import meetingrooms.dao.InMemoryMeetingRoomsRepository;
import meetingrooms.entity.MeetingRoom;
import meetingrooms.service.MeetingRoomsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeesServiceTest {

    MeetingRoomsService meetingroomsService = new MeetingRoomsService(new InMemoryMeetingRoomsRepository());

    @BeforeEach
    void init() {
        meetingroomsService.deleteAll();
    }

    @Test
    void testSaveThanList() {
        meetingroomsService.save("John Room", 0, 0);


        List<MeetingRoom> meetingRooms = meetingroomsService.listMeetingRoom();
        assertEquals(1, meetingRooms.size());
        assertEquals("John Room", meetingRooms.get(0).getName());
    }

    @Test
    void testSaveTwoThanList() {
        meetingroomsService.save("John Room", 0, 0);
        meetingroomsService.save("Jane Room", 0, 0);


        List<MeetingRoom> meetingRooms = meetingroomsService.listMeetingRoom();
        assertEquals(2, meetingRooms.size());
        assertEquals("Jane Room", meetingRooms.get(0).getName());
        assertEquals("John Room", meetingRooms.get(1).getName());
    }
}