package com.api.switzerland_bank.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.switzerland_bank.entities.Client;
import com.api.switzerland_bank.services.ClientService;

import jakarta.validation.Valid;

@Controller
public class ClientController {

  @Autowired
  private ClientService clientService;
  private static Client authenticatedClient;

  // Rota POST para o cadastro
  @PostMapping("/save")
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
      authenticatedClient = client;
      return "redirect:/dashboard";
    } else {
      return "redirect:/login";
    }
  }

  @RequestMapping("client/logout")
  public String logout() {
    authenticatedClient = null;
    return "redirect:/login";
  }

  @GetMapping("/dashboard")
  public String dashboard() {
    if (authenticatedClient != null) {
      return "dashboard";
    } else {
      return "redirect:/login";
    }
  }

  @GetMapping("/account")
  public String account(Model model) {
    if (authenticatedClient != null) {
      model.addAttribute("client", authenticatedClient);
      return "account";
    } else {
      return "redirect:/login";
    }
  }

}
