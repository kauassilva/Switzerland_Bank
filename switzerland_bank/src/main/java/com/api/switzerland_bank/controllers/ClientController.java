package com.api.switzerland_bank.controllers;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.api.switzerland_bank.entities.BankStatement;
import com.api.switzerland_bank.entities.Cards;
import com.api.switzerland_bank.entities.Client;
import com.api.switzerland_bank.services.BankStatementService;
import com.api.switzerland_bank.services.CardService;
import com.api.switzerland_bank.services.ClientService;

import jakarta.validation.Valid;

@Controller
public class ClientController {

  @Autowired
  private ClientService clientService;
  @Autowired
  private BankStatementService bankStatementService;

  private static Client authenticatedClient;
  
  @Autowired
  private CardService cardService;
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
      model.addAttribute("mensagemErro", "Informações de Login inválidas. Verifique os dados e tente novamente.");
      return "login";
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
      model.addAttribute("mensagemErro", "Informações de Esqueci Senha inválidas. Verifique os dados e tente novamente.");
      return "login";
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

  @RequestMapping("/delete")
  public String delete(){
    clientService.deleteById(authenticatedClient.getId());
    authenticatedClient = null;
    return "redirect:/login";
  }

  @GetMapping("/card")
  public String cartoes(Model model){
    if(authenticatedClient != null){
      model.addAttribute("client", authenticatedClient);
      
      if (cardService.findByClientId(authenticatedClient.getId()) != null) {
        model.addAttribute("botaoJaTenho", "");
      } else {
        model.addAttribute("botaoSolicitar", "");
      }
      return "cartoes";
    }else{
      return "redirect:/login";
    }
  }

  @PostMapping("/transfer")
  public String transfer(@RequestParam("chave") String chave, BigDecimal valor) {
    Client receiver = clientService.findByChave(chave);

    // Se a chave for igual a do próprio usuário
    if (receiver.getId() == authenticatedClient.getId()) {
      return "erro";
    }
    
    // Se o valor for menor ou igual do que o cliente possui na conta
    if (authenticatedClient.getBalance().compareTo(valor) >= 0) {
      
      // Diminui o saldo do remetente
      BigDecimal senderBalance = authenticatedClient.getBalance().subtract(valor);
      authenticatedClient.setBalance(senderBalance);
      clientService.save(authenticatedClient);
      
      // Criar o registro para o extrato do remetente
      var senderStatement = new BankStatement();
      senderStatement.setClientId(authenticatedClient.getId());
      senderStatement.setTipoTransacao("Pix enviado");
      senderStatement.setDescricao("para "+receiver.getName());
      senderStatement.setValor(valor);
      senderStatement.setDataHora(LocalDateTime.now());
      bankStatementService.save(senderStatement);

      // Se o destinatario for encontrado no banco de dados
      if (receiver != null) {
        // Aumenta o saldo do destinatário
        BigDecimal receiverBalance = receiver.getBalance().add(valor);
        receiver.setBalance(receiverBalance);
        clientService.save(receiver);
        
        // Criar o registro para o extrato do destinatário
        var receiverStatement = new BankStatement();
        receiverStatement.setClientId(receiver.getId());
        receiverStatement.setTipoTransacao("Pix recebido");
        receiverStatement.setDescricao("de "+authenticatedClient.getName());
        receiverStatement.setValor(valor);
        receiverStatement.setDataHora(LocalDateTime.now());
        bankStatementService.save(receiverStatement);
      }

      return "redirect:/pix";
    } else {
      return "erro";
    }

  }

  @GetMapping("/bank-statement")
  public String statement(Model model){
    if(authenticatedClient != null){
      List<BankStatement> list = bankStatementService.getAllBankStatement(authenticatedClient.getId());
      model.addAttribute("bankStatement", list);
      return "statement";
    }else{
      return "redirect:/login";
    }
  }

  @GetMapping("/gerarCartao")
  public String gerarCartao(Model model){
    if (authenticatedClient != null) {
      Cards card = cardService.gerarCartao(authenticatedClient);
      cardService.save(card);
      model.addAttribute("card", card);
      return "cartaoDados";
    } else {
      return "redirect:/login";
    }
  }

  @GetMapping("/cartaoDados")
  public String cartaoDados(Model model){
    if(authenticatedClient != null){
      Cards card = cardService.findByClientId(authenticatedClient.getId());
      model.addAttribute("card", card);
      return "cartaoDados";
    }else{
      return "redirect:/login";
    }
  }

}
