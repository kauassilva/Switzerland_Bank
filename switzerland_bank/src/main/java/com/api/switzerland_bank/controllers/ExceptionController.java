package com.api.switzerland_bank.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class ExceptionController implements ErrorController {

  @RequestMapping("/error")
  public String handleError(HttpServletRequest request, Model model) {
    Object statusCode = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
    Object message = request.getAttribute(RequestDispatcher.ERROR_MESSAGE);
    int status = Integer.parseInt(statusCode.toString());
    String errorType = HttpStatus.valueOf(status).getReasonPhrase();

    // Se o erro for do tipo 404
    if (statusCode != null && Integer.valueOf(statusCode.toString()) == HttpStatus.NOT_FOUND.value()) {
      return "errors/error404";
    }

    model.addAttribute("errorStatusCode", statusCode);
    model.addAttribute("errorMessage", message);
    model.addAttribute("errorType", errorType);

    return "errors/error";
  }

}
