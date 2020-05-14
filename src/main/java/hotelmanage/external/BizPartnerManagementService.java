
package hotelmanage.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by uengine on 2018. 11. 21..
 */

@FeignClient(name="roomNumber", url="${api.url.roomManagements}")
public interface BizPartnerManagementService {

    @RequestMapping(method= RequestMethod.POST, path="/roomManagements", consumes = "application/json")
    public void roomInformationRegistration(@RequestBody BizPartnerManagement bizPartnerManagement);

}