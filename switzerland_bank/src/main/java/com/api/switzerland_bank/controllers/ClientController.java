package com.api.switzerland_bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.switzerland_bank.entities.Client;
import com.api.switzerland_bank.services.ClientService;

import jakarta.validation.Valid;

@Controller
public class ClientController {

  @Autowired
  ClientService clientService;

  // Rota POST para o cadastro
  @PostMapping("client/save")
  public String addClient(@ModelAttribute @Valid Client c) {
    clientService.save(c);
    return "redirect:/login";
  }

  // Rota POST para o login
  @PostMapping("client/login")
  public String login(@RequestParam("email") String email,
                      @RequestParam("password") String password,
                      Model model) {
    Client client = clientService.findByEmail(email);

    if (client != null && client.getPassword().equals(password)) {
      model.addAttribute("client", client);
      return "dashboard";
    } else {
      return "home"; // Página com mensagem de erro
    }
  }

  @GetMapping("client/account")
  public String account(Model model) {
    model.addAttribute(model);
    return "account";
  }

}
