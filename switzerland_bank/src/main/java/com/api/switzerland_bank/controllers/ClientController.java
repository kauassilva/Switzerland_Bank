package com.api.switzerland_bank.controllers;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
    c.setBalance(new BigDecimal(10)); // Adiciona R$10 na conta inicialmente
    c.setChave(clientService.generateRandomValue(10)); // Cria uma chave PIX aleatória de 10 caracteres
    clientService.save(c);
    return "redirect:/login";
  }

  //Rota POST Update
  @PostMapping("/update")
  public String updateClient(@ModelAttribute Client c) {
    clientService.save(c);
    authenticatedClient = c;
    return "redirect:/account";
  }

  //Rota POST Mudar senha
  @PostMapping("/updateNewPassword")
  public String updateNewPasswordClient(@ModelAttribute Client c) {
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

  //Rota POST para Esqueci senha
  @PostMapping("/forgot-password")
  public String ForgotPassword(@RequestParam("email") String email,
                      @RequestParam("cpf") String cpf,
                      Model model) {
    Client client = clientService.findByEmail(email);

    if (client != null && client.getCpf().equals(cpf)) {
      model.addAttribute("client", client);
      return "changePassword";
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

  @GetMapping("/pix")
  public String pix(Model model){
    if(authenticatedClient != null){
      model.addAttribute("client", authenticatedClient);
      return "pix";
    }else{
      return "redirect:/login";
    }
  }

  @RequestMapping("/delete/{id}")
  public String delete(@PathVariable("id") long id){
    clientService.deleteById(id);
    return "redirect:/login";
  }

  @GetMapping("/card")
  public String cartoes(Model model){
    if(authenticatedClient != null){
      model.addAttribute("client", authenticatedClient);
      return "cartoes";
    }else{
      return "redirect:/login";
    }
  }

  @PostMapping("/transfer")
  public String transfer(@RequestParam("chave") String chave, BigDecimal valor) {
    Client receiver = clientService.findByChave(chave);

    // Se o valor for menor ou igual do que o cliente possui na conta
    if (authenticatedClient.getBalance().compareTo(valor) >= 0) {
      // Se o destinatario for encontrado no banco de dados
      if (receiver != null) {
        // Aumenta o saldo do destinatário
        BigDecimal receiverBalance = receiver.getBalance().add(valor);
        receiver.setBalance(receiverBalance);
        clientService.save(receiver);
      }

      // Diminui o saldo do remetente
      BigDecimal senderBalance = authenticatedClient.getBalance().subtract(valor);
      authenticatedClient.setBalance(senderBalance);
      clientService.save(authenticatedClient);

      return "redirect:/pix";
    } else {
      // Se o valor for maior do que o cliente possui
      return "Erro";
    }
  
  }

}
