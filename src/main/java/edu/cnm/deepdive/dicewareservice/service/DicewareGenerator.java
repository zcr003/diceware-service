package edu.cnm.deepdive.dicewareservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Service;

//This is inheritance. DicewareGenerator implements PassphraseGen. So it essentially is the interface.
@Service
public class DicewareGenerator implements PassphraseGenerator {

  private final List<String> words;
  private final Random rng;

  //Constructor.
  public DicewareGenerator(WordListProvider provider, Random rng) {
    this.words = new ArrayList<>(provider.getWords());
    this.rng = rng;
  }

  //Method to generate the passphrase.
  @Override
  public String[] generate(int length) {
    String[] passPhrase = new String[length];
    for (int i = 0; i < length; i++) {
      passPhrase[i] = words.get(rng.nextInt(words.size()));
    }

    return passPhrase;


  }
}
