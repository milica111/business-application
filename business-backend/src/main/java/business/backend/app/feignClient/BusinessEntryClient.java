package business.backend.app.feignClient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import business.backend.app.entities.BusinessEntry;


@FeignClient(value = "businessEntryClient", url = "https://storage.googleapis.com", configuration = FeignClientConfiguration.class)
public interface BusinessEntryClient {

    @RequestMapping(method = RequestMethod.GET, value = "coding-session-rest-api/{placeId}")
    BusinessEntry getBusinessEntry(@PathVariable String placeId);


}
