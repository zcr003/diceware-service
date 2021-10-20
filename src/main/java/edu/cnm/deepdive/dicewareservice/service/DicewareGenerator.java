package edu.cnm.deepdive.dicewareservice.service;

import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

//This is inheritance. DicewareGenerator implements Passphrasegen. So it essentially is the interface.
@Service
public class DicewareGenerator implements PassphraseGenerator {

  private final List<String> words;
  private final Random rng;

  public DicewareGenerator(List<String> words, Random rng) {
    this.words = words;
    this.rng = rng;
  }

  @Override
  public String[] generate(int length) {
    return new String[0];
  }
}
