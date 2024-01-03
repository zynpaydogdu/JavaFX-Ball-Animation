package com.example.animation;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animation extends Application {
    @Override
    public void start(Stage primaryStage){
        Group group = new Group();

        Circle circle= new Circle(0, 0,10);
        circle.setFill(Color.MEDIUMPURPLE);

        Arc arc = new Arc(125,100,80,40,210,125);
        arc.setFill(Color.LIGHTPINK);
        arc.setStroke(Color.DEEPPINK);

        group.getChildren().add(arc);
        group.getChildren().add(circle);

        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(4000));
        pt.setPath(arc);
        pt.setNode(circle);
        pt.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.setAutoReverse(true);
        pt.play();

        group.setOnMousePressed(e-> pt.pause());
        group.setOnMouseReleased(e -> pt.play());

        Scene scene = new Scene(new BorderPane(group),250,200);
        primaryStage.setTitle("Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main (String[] args){
        launch(args);
    }

}
