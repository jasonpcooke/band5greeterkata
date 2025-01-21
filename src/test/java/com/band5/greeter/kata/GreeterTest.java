package com.band5.greeter.kata;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {
  @Test
  void greet() {
    var greeter = new Greeter();
    String name = "John Smith";
    assertEquals("Hello John Smith", greeter.greet(name));
  }

  @Test
  void greetTrimsName() {
    var greeter = new Greeter();
    String name = "  John Smith  ";
    assertEquals("Hello John Smith", greeter.greet(name));
  }
}