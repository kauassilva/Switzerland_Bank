package com.api.switzerland_bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.api.switzerland_bank.entities.Client;
import com.api.switzerland_bank.services.ClientService;

import jakarta.validation.Valid;

@Controller
@CrossOrigin(origins = "*", maxAge = 3600) // Para que possa ser acessado por todos
@RequestMapping("/client")
public class ClientController {

  @Autowired ClientService clientService;

  @PostMapping("/save")
  public String addClient(@ModelAttribute @Valid Client c) {
    clientService.save(c);
    return "redirect:/login";
  }

}
