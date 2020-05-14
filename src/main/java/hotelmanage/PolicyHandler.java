package hotelmanage;

import hotelmanage.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
public class PolicyHandler{
    
    @StreamListener(KafkaProcessor.INPUT)
    public void wheneverRoomScoreRegistered_객실사업자평가등록(@Payload RoomScoreRegistered roomScoreRegistered){

        if(roomScoreRegistered.isMe()){
            System.out.println("##### listener 객실사업자평가등록 : " + roomScoreRegistered.toJson());
        }
    }

}
