package edu.cnm.deepdive.dicewareservice.controller;

import edu.cnm.deepdive.dicewareservice.service.PassphraseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/passphrases")
public class PassphraseController {


  private final PassphraseGenerator generator;

  @Autowired
  public PassphraseController(
      PassphraseGenerator generator) {
    this.generator = generator;
  }
  //This method is returning an array of String. The entire "body."
  @ResponseBody
  @GetMapping(value = "/transient", produces = MediaType.APPLICATION_JSON_VALUE)
  public String[] generate(@RequestParam(defaultValue = "5") int length) {
    return generator.generate(length);
  }

  //Controller method. Return value is the name of the template.
  @GetMapping(value = "/transient", produces = MediaType.TEXT_HTML_VALUE)
  public String generate(@RequestParam(defaultValue = "5") int length, Model model) {
    model.addAttribute("words", generator.generate(length));
    return "passphrase";

  }


}
