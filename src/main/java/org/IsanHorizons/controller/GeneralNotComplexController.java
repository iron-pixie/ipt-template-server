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

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/email/quote", method = RequestMethod.POST)
    public HashMap<String, String> EmailQuote(@RequestBody HashMap<String, String> request)
        {
            HashMap<String, String> response = new HashMap<String, String>();

            try
            {
                EmailService email = new EmailService();
                String contactRequest = " ";
                while(request.entrySet().iterator().hasNext())
                {
                    HashMap.Entry pair = request.entrySet().iterator().next();
                    contactRequest += pair.getKey() + " = " + pair.getValue();
                }
                email.sendMailAccess("New Contact Request", contactRequest);
            }
            catch(Exception e)
            {
                response.put("ERROR:", e.toString());
            }

            return response;
        }

   /* @CrossOrigin(origins = "*")
    @RequestMapping(value = "/{type}/add", method = RequestMethod.POST)
    public HashMap<String, String> Add(@PathVariable String type, @RequestBody HashMap<String, String> addData) {

        HashMap<String, String> responseMap = new HashMap<String, String>();

        try {
            int i = 1;
            String connectionString = "jdbc:mysql://grimore-db.cebbknh24dty.us-west-2.rds.amazonaws.com/" + type;
            String objectList = "(";
            ArrayList<String> keyList = new ArrayList<String>();
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(connectionString, "grimore", "grimorepos");
            Statement stmt = con.createStatement();
            String queryString = "insert into " + type;
            ArrayList<String> objectArray = new ArrayList<String>();

            addData.forEach((key, value) -> {
                String mapper = key + ", " + "values (";
                objectArray.add(mapper);
                keyList.add(value);
            });

            for (String key: keyList) {
                objectList += key;
                if(i != keyList.size())
                {
                    objectList += "', '";
                }
                else
                {
                    objectList +=  "')";
                }
                i++;
            }

            stmt.executeUpdate(queryString);
            responseMap.put("Success: ", "New Row Added!");
        }
        catch(Exception e)
        {
            responseMap.put("Error: ", e.toString());
        }

        return responseMap;
    }*/


}