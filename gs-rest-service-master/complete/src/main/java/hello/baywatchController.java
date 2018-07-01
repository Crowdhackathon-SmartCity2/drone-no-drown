	package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class baywatchController {


    @RequestMapping("/drown")
    public String greeting(@RequestParam(value="lat", defaultValue="lat") String latitude,
    						 @RequestParam(value="long", defaultValue="long") String longtitude) {
        return "coming to " + latitude + "latitude" + longtitude;
    }
}
