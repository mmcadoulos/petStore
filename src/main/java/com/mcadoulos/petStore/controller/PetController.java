package com.mcadoulos.petStore.controller;

import com.mcadoulos.petStore.model.Pet;
import jakarta.websocket.server.PathParam;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@Controller
//@ResponseBody
@RestController // does multiple things including @Controller and @ResponseBody
@RequestMapping("pet") // maps to what you are controlling e.g. the "pet" in PetController
public class PetController {

//    // with no @ResponseBody under @controlller
//    public ResponseEntity getPet(){
//        return ResponseEntity.ok().body("My Pet");
//    }

//    @GetMapping("/")
//    public String getPet(){
//        return "My Pet";
//    }

    @GetMapping("create/{name}/{species}")
    public String createPet(@PathVariable String name, @PathVariable String species){
        return "<h1>My Pet</h1>" +
                "<h3>" + name + "</h3>" +
                "<h3> the </h3>" +
                "<h3>"+species+"</h3>";
    }

    @PostMapping("create")
    public String createPetRequest(@RequestParam String name, @RequestParam String species){
        Pet myPet = new Pet(name, species);
//        return myPet;

        return "<h1>My Pet</h1>" +
                "<h3>" + myPet.getName() + "</h3>" +
//                "<h3> the </h3>" +
                "<h3>"+ myPet.getSpecies()+"</h3>";
    }

    @GetMapping("createForm")
    public String createPetForm(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div>\n" +
                "    <form action=\"create\" method=\"post\">\n" +
                "        <div>\n" +
                "            <label>Name: </label>\n" +
                "            <input type=\"text\" name=\"name\">\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <label>Species: </label>\n" +
                "            <input type=\"text\" name=\"species\">\n" +
                "        </div>\n" +
                "        <div>\n" +
                "            <input type=\"submit\" value=\"GO!\"/>\n" +
                "        </div>\n" +
                "    </form>\n" +
                "</div>\n" +
                "\n" +
                "</body>\n" +
                "</html>";
    }




}
