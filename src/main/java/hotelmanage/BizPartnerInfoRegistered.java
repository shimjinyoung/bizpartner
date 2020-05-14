package hotelmanage;

public class BizPartnerInfoRegistered extends AbstractEvent {

    private Integer bizNumber;
    private String address;
    private String roomStatus;
    private Integer roomNumber;

    public BizPartnerInfoRegistered(){
        super();
    }

    public Integer getBizNumber() {
        return bizNumber;
    }

    public void setBizNumber(Integer bizNumber) {
        this.bizNumber = bizNumber;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }
}
