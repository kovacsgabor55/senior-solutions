package meetingrooms.controller;

import meetingrooms.dao.MariaDbMeetingRoomsRepository;
import meetingrooms.service.MeetingRoomsService;

import java.util.Scanner;

public class MeetingRoomsController {

    private Scanner scanner = new Scanner(System.in);

    private MeetingRoomsService meetingRoomsService =
            new MeetingRoomsService(new MariaDbMeetingRoomsRepository());

    private static String menu = """
            0. Tárgyaló rögzítése
            1. Tárgyalók névsorrendben
            2. Tárgyalók név alapján visszafele sorrendben
            3. Minden második tárgyaló
            4. Területek
            5. Keresés pontos név alapján
            6. Keresés névtöredék alapján
            7. Keresés terület alapján
            """;

    public static void main(String[] args) {
        new MeetingRoomsController().start();
    }

    public void start() {
        System.out.println(menu);

        String name = scanner.nextLine();
        int width = scanner.nextInt();
        scanner.nextLine();
        int height = scanner.nextInt();
        scanner.nextLine();
        meetingRoomsService.save(name, width, height);

        System.out.println(meetingRoomsService.listMeetingRoom());
    }
}
