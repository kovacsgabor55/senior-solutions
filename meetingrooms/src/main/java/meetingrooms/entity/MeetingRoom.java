package meetingrooms.entity;

public class MeetingRoom {
    private Long id;
    private String name;
    private int width;
    private int length;

    public MeetingRoom() {
    }

    public MeetingRoom(String name, int width, int length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }

    public MeetingRoom(Long id, String name, int width, int length) {
        this.id = id;
        this.name = name;
        this.width = width;
        this.length = length;
    }

    public int getArea() {
        return length * width;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "MeetingRoom{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", width=" + width +
                ", length=" + length +
                '}';
    }
}
