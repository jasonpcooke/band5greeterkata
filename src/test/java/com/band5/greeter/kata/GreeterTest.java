package com.band5.greeter.kata;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

class GreeterTest {

  private final LocalTime afternoon = LocalTime.of(14, 0);
  @Test
  void greetReturnsHelloAndName() {
    var greeter = new Greeter();
    String name = "John Smith";

    assertEquals("Hello John Smith", greeter.greet(name, afternoon));
  }

  @Test
  void greetTrimsName() {
    var greeter = new Greeter();
    String name = "  John Smith  ";

    assertEquals("Hello John Smith", greeter.greet(name, afternoon));
  }

  @Test
  void greetCapitalisesFirstLetterOfName() {
    var greeter = new Greeter();
    String name = "john";

    assertEquals("Hello John", greeter.greet(name, afternoon));
  }

  @Test
  void greetReturnsGoodMorningWhenTime0600to1200() {
    var greeter = new Greeter();
    LocalTime morning = LocalTime.of(6, 0);
    String name = "John";

    assertEquals("Good morning John", greeter.greet(name, morning));
  }

  @Test
  void greetDoesNotReturnGoodMorningWhenTimeIsOutside0600to1200() {
    var greeter = new Greeter();
    LocalTime morning = LocalTime.of(5, 59);
    String name = "John";

    assertNotEquals("Good morning John", greeter.greet(name, morning));
  }

  @Test
  void greetReturnsGoodMorningWhenTime1800to2200() {
    var greeter = new Greeter();
    LocalTime evening = LocalTime.of(20, 0);
    String name = "John";

    assertEquals("Good evening John", greeter.greet(name, evening));
  }

  @Test
  void greetDoesNotReturnGoodMorningWhenTimeIsOutside1800to2200() {
    var greeter = new Greeter();
    LocalTime evening = LocalTime.of(17, 59);
    String name = "John";

    assertNotEquals("Good evening John", greeter.greet(name, evening));
  }

  @Test
  void greetReturnsGoodNightWhenTime2200to0600() {
    var greeter = new Greeter();
    LocalTime night = LocalTime.of(22, 0);
    String name = "John";

    assertEquals("Good night John", greeter.greet(name, night));
  }
  @Test
  void greetDoesNotReturnGoodMorningWhenTimeIsOutside2200to0600() {
    var greeter = new Greeter();
    LocalTime night = LocalTime.of(17, 59);
    String name = "John";

    assertNotEquals("Good night John", greeter.greet(name, night));
  }

  @Test
  void greetLogsToConsoleWhenCalled() {
    var greeter = new Greeter();
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    PrintStream printStream = System.out;
    System.setOut(new PrintStream(outputStream));

    String name = "John";
    LocalTime time = LocalTime.of(12, 0);

    assertEquals("Hello John", greeter.greet(name, time));
    assertEquals("Hello John\n", outputStream.toString());
    System.setOut(printStream);
  }
}