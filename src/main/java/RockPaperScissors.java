import java.io.Console;
import java.util.Arrays;
import java.util.List;
import static spark.Spark.*;
import java.util.Map;
import java.util.Random;
import java.util.HashMap;
import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class RockPaperScissors {

  public static void main(String[] args){

      String layout = "templates/layout.vtl";
      get("/", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/home.vtl");
          return new ModelAndView(model, layout);
      }, new VelocityTemplateEngine());

      get("/result", (request, response) -> {
          Map<String, Object> model = new HashMap<String, Object>();
          model.put("template", "templates/result.vtl");

          String userInput = request.queryParams("user1input");
          String player1 = userInput;
          String player2 = randomChoice();
          String rpsGame = rpsGame(userInput, player2);

          model.put("rpsGame", rpsGame);
          model.put("player1", player1);
          model.put("player2", player2);
          model.put("result", request.queryParams("result"));
          return new ModelAndView(model, layout);
          }, new VelocityTemplateEngine());
      }



  public static String randomChoice() {
          String player2 = "";
          Random myRandomGenerator = new Random();
          Integer randomanswer = myRandomGenerator.nextInt(3);

            if (randomanswer == 0){
              player2 = "paper";
            } else if (randomanswer == 1){
              player2 = "rock";
            } else {
              player2 = "scissors";
            }

            return player2;
  }


  public static String rpsGame (String userInput, String player2){
        String player1 = userInput;
        String result = "";


        if (player1.equals("rock") && player2.equals("rock")){
        result = "it's a tie";
      } else if (player1.equals("rock") && player2.equals("paper")) {
        result = "player 2 wins";
      } else if (player1.equals("rock") && player2.equals("scissors")){
        result = "player 1 wins";
      } else if (player1.equals("paper") && player2.equals("rock")){
        result = "player 1 wins";
      } else if (player1.equals("paper") && player2.equals("paper")){
        result = "it's a tie";
      } else if (player1.equals("paper") && player2.equals("scissors")){
        result = "player 2 wins";
      } else if (player1.equals("scissors") && player2.equals("rock")){
        result = "player 2 wins";
      } else if (player1.equals("scissors") && player2.equals("paper")){
        result = "player 1 wins";
      } else {
        result = "it's a tie";
      }

      //String finalResult = String.format("Player 1 chose %s and player 2 chose %s. So %s.", player1, player2, result);
      return result;

      }


  }
