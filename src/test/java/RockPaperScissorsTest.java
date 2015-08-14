import org.fluentlenium.adapter.FluentTest;
import static org.junit.Assert.*;
import org.junit.*;
import org.junit.ClassRule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

import static org.assertj.core.api.Assertions.assertThat;

public class RockPaperScissorsTest extends FluentTest {

  public WebDriver webDriver = new HtmlUnitDriver();
  public WebDriver getDefaultDriver() {
      return webDriver;
  }

  @ClassRule
  public static ServerRule server = new ServerRule();

  @Test
  public void rootTest() {
    goTo("http://localhost:4567/");
    assertThat(pageSource()).contains("Rock Paper Scissors Game");
  }

  @Test
  public void rpsGame() {
     goTo("http://localhost:4567/");
     find("#rock").click();
     submit(".btn");
     assertThat(pageSource()).contains("Player 1 said: rock");
 }

}
