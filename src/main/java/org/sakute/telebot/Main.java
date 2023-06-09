package org.sakute.telebot;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.sakute.telebot.persistance.dao.UsersDao;
import org.sakute.telebot.persistance.dao.impl.UsersDaoImpl;

public class Main extends Application {

  public static void main(String[] args) {
      UsersDao dao = new UsersDaoImpl();
      System.out.println(dao.getAllUsers());
      launch();

  }

    @Override
    public void start(Stage stage) throws Exception {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();

    }
}