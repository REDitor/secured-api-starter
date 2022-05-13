package nl.inholland.shop.controller;

import nl.inholland.shop.model.dto.LoginDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class LoginController {

    @PostMapping
    public String login(@RequestBody LoginDTO login) {

        return "Fake token";
    }

}
