package org.IsanHorizons.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

import org.IsanHorizons.util.EmailService;

@RestController
public class GeneralNotComplexController {

    //private Connection con;

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/status", method = RequestMethod.GET)
    public HashMap<String, String> Status()
    {
        HashMap<String, String> response = new HashMap<String, String>();
        response.put("Status", "Success");
        return response;
    }
}
