package hotelmanage;

import javax.persistence.*;
import org.springframework.beans.BeanUtils;
import java.util.List;

@Entity
@Table(name="BizPartnerManagement_table")
public class BizPartnerManagement {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer bizNumber;
    private String address;
    private String roomStatus;
    private Integer roomNumber;

    @PostPersist
    public void onPostPersist(){
        BizPartnerInfoRegistered bizPartnerInfoRegistered = new BizPartnerInfoRegistered();
        BeanUtils.copyProperties(this, bizPartnerInfoRegistered);
        bizPartnerInfoRegistered.publishAfterCommit();

        //Following code causes dependency to external APIs
        // it is NOT A GOOD PRACTICE. instead, Event-Policy mapping is recommended.

        hotelmanage.external.BizPartnerManagement bizPartnerManagement = new hotelmanage.external.BizPartnerManagement();
        // mappings goes here
        Application.applicationContext.getBean(hotelmanage.external.BizPartnerManagementService.class)
            .roomInformationRegistration(bizPartnerManagement);


        BizPartnerInfoModified bizPartnerInfoModified = new BizPartnerInfoModified();
        BeanUtils.copyProperties(this, bizPartnerInfoModified);
        bizPartnerInfoModified.publishAfterCommit();


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
