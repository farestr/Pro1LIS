package com.example.dp1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main extends Application {
    boolean run = false;


    LIS lis;


    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane mainPane = new AnchorPane();
        mainPane.setStyle("-fx-background-color: White;");

        Rectangle barTop = new Rectangle();
        barTop.setFill(Paint.valueOf("#0e2d49"));
        barTop.setLayoutX(-5);
        barTop.setLayoutY(-5);
        barTop.setWidth(606);
        barTop.setHeight(49);

        Rectangle barBottom = new Rectangle();
        barBottom.setFill(Paint.valueOf("#0e2d49"));
        barBottom.setLayoutX(-4);
        barBottom.setLayoutY(352);
        barBottom.setWidth(606);
        barBottom.setHeight(49);

        Label header = new Label("Finding Maximum Number Of Leds Turning ON");

        header.setTextFill(Color.WHITE);
        header.setFont(Font.font("Comic Sans MS",18));
        header.setFont(Font.font(18));
        header.setLayoutX(103);
        header.setLayoutY(7);



        Label SwitchesNumber = new Label("Switches Number");
        SwitchesNumber.setTextFill(Paint.valueOf("#0e2d49"));
        SwitchesNumber.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        SwitchesNumber.setLayoutX(23);
        SwitchesNumber.setLayoutY(82);

        Label BulbsOrder = new Label("Bulbs Order");
        BulbsOrder.setTextFill(Paint.valueOf("#0e2d49"));
        BulbsOrder.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        BulbsOrder.setLayoutX(23);
        BulbsOrder.setLayoutY(123);

        Label LoadData = new Label("Or Load data file");
        LoadData.setTextFill(Paint.valueOf("#0e2d49"));
        LoadData.setFont(Font.font("Tahoma",FontWeight.BOLD,16));
        LoadData.setLayoutX(23);
        LoadData.setLayoutY(209);


        TextField SwitchesNum = new TextField();
        SwitchesNum.setLayoutX(190);
        SwitchesNum.setLayoutY(78);
        SwitchesNum.setPrefWidth(130);
        SwitchesNum.setPrefHeight(27);
        SwitchesNum.setStyle("-fx-border-color: BLACK");

        TextField bulbsOrder = new TextField();
        bulbsOrder.setStyle("-fx-border-color: BLACK");
        bulbsOrder.setPrefWidth(166);
        bulbsOrder.setPrefHeight(27);
        bulbsOrder.setLayoutX(190);
        bulbsOrder.setLayoutY(119);

        TextField FilePath = new TextField();
        FilePath.setPrefWidth(191);
        FilePath.setPrefHeight(26);
        FilePath.setLayoutX(187);
        FilePath.setLayoutY(202);
        FilePath.setStyle("-fx-border-color: BLACK");

        Button RUN = new Button("RUN");
        RUN.setTextFill(Paint.valueOf("#0e2d49"));
        RUN.setFont(Font.font("Serif", FontWeight.BOLD,20));
        RUN.setPrefWidth(119);
        RUN.setPrefHeight(42);
        RUN.setLayoutX(387);
        RUN.setLayoutY(110);
        RUN.setStyle("-fx-background-color: White; -fx-border-color:  #0e2d49; -fx-border-radius: 15;");

        Button Browse = new Button("Browse");
        Browse.setFont(Font.font(12));
        Browse.setTextFill(Color.BLACK);
        Browse.setStyle("-fx-border-color: Black");
        Browse.setLayoutX(387);
        Browse.setLayoutY(206);
        Browse.setPrefWidth(88);
        Browse.setPrefHeight(30);

        Button Results = new Button("Results");
        Button Tables = new Button("Tables");
        Button Simulation = new Button("Simulation");
        Button FullTable = new Button("Full Table");
        FullTable.setDisable(true);
        Results.setDisable(true);
        Tables.setDisable(true);
        Simulation.setDisable(true);
        Results.setTextFill(Color.WHITE);
        Results.setFont(Font.font("Andalus",18));
        Results.setStyle("-fx-background-color:  #0e2d49");
        Results.setLayoutX(121);
        Results.setLayoutY(250);
        Results.setPrefWidth(106);
        Results.setPrefHeight(42);

        FullTable.setTextFill(Color.WHITE);
        FullTable.setFont(Font.font("Andalus",18));
        FullTable.setLayoutX(125);
        FullTable.setLayoutY(250);
        FullTable.setPrefWidth(106);
        FullTable.setPrefHeight(42);

        Tables.setTextFill(Color.WHITE);
        Tables.setFont(Font.font("Andalus",18));
        Tables.setStyle("-fx-background-color:  #0e2d49");
        Tables.setPrefWidth(106);
        Tables.setPrefHeight(42);
        Tables.setLayoutX(247);
        Tables.setLayoutY(250);

        Simulation.setTextFill(Color.WHITE);
        Simulation.setFont(Font.font("Andalus",18));
        Simulation.setStyle("-fx-background-color:  #0e2d49");
        Simulation.setPrefWidth(106);
        Simulation.setPrefHeight(42);
        Simulation.setLayoutX(372);
        Simulation.setLayoutY(250);


        mainPane.getChildren().addAll(barTop,barBottom,header, SwitchesNumber,BulbsOrder, LoadData);
        mainPane.getChildren().addAll(FullTable,SwitchesNum, bulbsOrder, FilePath,RUN,Browse, Results,Tables,Simulation);
        Scene scene = new Scene(mainPane,600,400);
        primaryStage.setResizable(true);
        primaryStage.setScene(scene);
        primaryStage.show();


        RUN.setOnAction(event -> {
            String sw = SwitchesNum.getText();
            String bo = bulbsOrder.getText();
            run = true;
            int size = Integer.parseInt(sw);
            int arr[] = new int[size];
            String[] nums = bo.split(" ");
            for (int i = 0; i < size; i++)
                arr[i] = Integer.parseInt(nums[i]);

            lis = new LIS(arr,size);
            Browse.setDisable(true);
            FilePath.setEditable(false);
            Results.setDisable(false);
            Tables.setDisable(false);
            Simulation.setDisable(false);
            FullTable.setDisable(false);

        });


        Browse.setOnAction(event -> {
            RUN.setDisable(true);
            FileChooser chooser = new FileChooser();
            File file = chooser.showOpenDialog(null);
            if (file==null)
            {
                Alert error = new Alert(Alert.AlertType.ERROR);
                error.setContentText("No File Selected or file not found");
            }
            else {
                try {
                    run = true;
                    FilePath.setText(file.getAbsolutePath());
                    Scanner read = new Scanner(file);
                    int size = Integer.parseInt(read.nextLine().trim());
                    int arr [] = new int[size];
                    int i= 0;
                    while (read.hasNext()) {
                        arr[i] = read.nextInt();
                        i++;
                    }
                    lis = new LIS(arr,size);

                    Results.setDisable(false);
                    Tables.setDisable(false);
                    Simulation.setDisable(false);
                    FullTable.setDisable(false);


                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }

        });

        Results.setOnAction(event -> {
            if (run)
                ShowResultsPane();
        });

        Simulation.setOnAction(event -> {
            try {
                ShowSimulationStage();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        });

        Tables.setOnAction(event -> {
            TablesStage();
        });
        FullTable.setOnAction(event ->{
            PrintTableStat();
        });
    }

    private void ShowResultsPane() {
        Stage ResultsStage = new Stage();
        AnchorPane Result = new AnchorPane();

        Rectangle rectangle1, rectangle2, rectangle3,rectangle4,rectangle5;
        rectangle1 = new Rectangle();
        rectangle2 = new Rectangle();
        rectangle3 = new Rectangle();
        rectangle4 = new Rectangle();
        rectangle5 = new Rectangle();

        rectangle1.setFill(Paint.valueOf("#0e2d49"));
        rectangle1.setLayoutY(0);
        rectangle1.setLayoutX(-5);
        rectangle1.setWidth(610);
        rectangle1.setHeight(49);
        rectangle1.setStrokeWidth(0);

        rectangle2.setFill(Paint.valueOf("#1f93ff"));
        rectangle2.setFill(Color.TRANSPARENT);
        rectangle2.setStrokeWidth(3);
        rectangle2.setStroke(Paint.valueOf("#0e2d49"));
        rectangle2.setLayoutX(25);
        rectangle2.setLayoutY(69);
        rectangle2.setWidth(545);
        rectangle2.setHeight(306);


        rectangle3.setFill(Paint.valueOf("#0e2d49"));
        rectangle3.setWidth(482);
        rectangle3.setHeight(61);
        rectangle3.setLayoutX(52);
        rectangle3.setLayoutY(82);

        rectangle4.setFill(Paint.valueOf("#0e2d49"));
        rectangle4.setWidth(482);
        rectangle4.setHeight(61);
        rectangle4.setLayoutX(52);
        rectangle4.setLayoutY(184);

        rectangle5.setFill(Paint.valueOf("#0e2d49"));
        rectangle5.setWidth(482);
        rectangle5.setHeight(61);
        rectangle5.setLayoutX(52);
        rectangle5.setLayoutY(286);

        Label ResultsTitle = new Label("Results");
        ResultsTitle.setFont(Font.font("Comic Sans MS",18));
        ResultsTitle.setTextFill(Color.WHITE);
        ResultsTitle.setLayoutX(269);
        ResultsTitle.setLayoutY(12);

        Label MaxLedsInfo = new Label("The Number of Maximum LEDS Turning On:");
        Label MaxLeds = new Label(""+lis.max);
        Label OrderInfo = new Label("The Order is:");
        Label Order = new Label(lis.subsequnceString());
        Label SolutionsNum = new Label("The Number of Leds turned off is:");
        Label SNum = new Label(" "+(lis.LEDS.length-lis.max));

        MaxLedsInfo.setFont(Font.font("Andalus",18));
        MaxLedsInfo.setTextFill(Color.WHITE);
        MaxLedsInfo.setPrefHeight(18);
        MaxLedsInfo.setPrefWidth(342);
        MaxLedsInfo.setLayoutX(74);
        MaxLedsInfo.setLayoutY(98);

        MaxLeds.setFont(Font.font("Andalus",20));
        MaxLeds.setTextFill(Color.WHITE);
        MaxLeds.setPrefWidth(33);
        MaxLeds.setPrefHeight(31);
        MaxLeds.setLayoutX(466);
        MaxLeds.setLayoutY(97);

        OrderInfo.setFont(Font.font("Andalus",18));
        OrderInfo.setTextFill(Color.WHITE);
        OrderInfo.setPrefWidth(103);
        OrderInfo.setPrefHeight(30);
        OrderInfo.setLayoutX(74);
        OrderInfo.setLayoutY(200);

        Order.setPrefWidth(356);
        Order.setPrefHeight(30);
        Order.setFont(Font.font("Andalus",18));
        Order.setTextFill(Color.WHITE);
        Order.setLayoutX(177);
        Order.setLayoutY(200);

        SolutionsNum.setFont(Font.font("Andalus",18));
        SolutionsNum.setTextFill(Color.WHITE);
        SolutionsNum.setPrefHeight(18);
        SolutionsNum.setPrefWidth(342);
        SolutionsNum.setLayoutX(74);
        SolutionsNum.setLayoutY(301);

        SNum.setFont(Font.font("Andalus",20));
        SNum.setTextFill(Color.WHITE);
        SNum.setPrefWidth(33);
        SNum.setPrefHeight(31);
        SNum.setLayoutX(466);
        SNum.setLayoutY(300);

        Result.getChildren().addAll(rectangle1,rectangle2,rectangle3,rectangle4,rectangle5);
        Result.getChildren().addAll(ResultsTitle,MaxLedsInfo,MaxLeds,OrderInfo,Order,SolutionsNum,SNum);

        Scene scene = new Scene(Result,606,400);
        ResultsStage.setScene(scene);
        ResultsStage.setResizable(true);
        ResultsStage.show();
    }


    public void ShowSimulationStage() throws FileNotFoundException {
        AnchorPane mainPane = new AnchorPane();
        mainPane.setStyle("-fx-background-color: White;");
        HBox bulbs = new HBox();
        bulbs.setPrefWidth(828);
        bulbs.setPrefHeight(110);
        bulbs.setLayoutX(1);
        bulbs.setLayoutY(139);
        bulbs.setAlignment(Pos.CENTER);
        bulbs.setSpacing(30);
        Image bulbOff = new Image(new FileInputStream("C:\\Users\\SS\\Desktop\\Dp1\\src\\main\\java\\com\\example\\dp1\\bulbOff.png"));
        Image bulbOn = new Image(new FileInputStream("C:\\Users\\SS\\Desktop\\Dp1\\src\\main\\java\\com\\example\\dp1\\bulbOn.png"));
        ImageView[] Bulbs = new ImageView[lis.LEDS.length];
        for (int i = 0; i < lis.LEDS.length; i++) {
            Bulbs[i] = new ImageView(bulbOff);
            Bulbs[i].setFitWidth(46);
            Bulbs[i].setFitHeight(100);
            bulbs.getChildren().add(Bulbs[i]);
        }
        HBox switching = new HBox();
        Circle[] switches = new Circle[lis.LEDS.length];
        Line[] lines = new Line[switches.length];
        switching.setPrefWidth(822);
        switching.setPrefHeight(100);
        switching.setLayoutX(0);
        switching.setLayoutY(306);
        switching.setSpacing(30);
        switching.setAlignment(Pos.CENTER);
        for (int i = 0; i < switches.length; i++) {
            switches[i] = new Circle();
            switches[i].setRadius(24);
            switches[i].setFill(Paint.valueOf("#a1a19d"));
            switching.getChildren().add(switches[i]);
            switches[i].setStrokeWidth(1.5);
            switches[i].setStroke(Color.BLACK);

        }

        HBox circlesN = new HBox();
        circlesN.setAlignment(Pos.CENTER);
        circlesN.setSpacing(30);
        circlesN.setPrefWidth(828);
        circlesN.setPrefHeight(110);
        circlesN.setLayoutX(0);
        circlesN.setLayoutY(69);
        HBox Nums = new HBox();
        Nums.setAlignment(Pos.CENTER);
        Nums.setSpacing(61);
        Nums.setPrefWidth(828);
        Nums.setPrefHeight(110);
        Nums.setLayoutX(0);
        Nums.setLayoutY(69);

        Label[] Numbers = new Label[switches.length];

        Circle[] numsCircles = new Circle[Bulbs.length];
        for (int i = 0; i < numsCircles.length; i++) {
            numsCircles[i] = new Circle();
            numsCircles[i].setRadius(25);
            numsCircles[i].setStrokeWidth(0);
            numsCircles[i].setFill(Color.BLACK);

            circlesN.getChildren().add(numsCircles[i]);

            Numbers[i] = new Label();
            Numbers[i].setText(""+(lis.LEDS[i]));
            Numbers[i].setFont(Font.font("Calibri",FontWeight.LIGHT,30 ));
            Numbers[i].setTextFill(Color.WHITE);

            Nums.getChildren().add(Numbers[i]);
        }

        HBox SwitchsNumbering = new HBox();
        SwitchsNumbering.setLayoutX(-3);
        SwitchsNumbering.setLayoutY(302);
        SwitchsNumbering.setPrefWidth(828);
        SwitchsNumbering.setPrefHeight(110);
        SwitchsNumbering.setSpacing(62);
        SwitchsNumbering.setAlignment(Pos.CENTER);
        Label[] nums = new Label[switches.length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new Label(""+(i+1));
            nums[i].setFont(Font.font("Calibri",FontWeight.LIGHT,30 ));
            nums[i].setTextFill(Color.BLACK);

            SwitchsNumbering.getChildren().add(nums[i]);
        }

        Label turnOnOff = new Label("Turn ON/OFF");
        turnOnOff.setTextFill(Paint.valueOf("#0e0d51"));
        turnOnOff.setFont(Font.font("Andalus",25));
        turnOnOff.setPrefWidth(140);
        turnOnOff.setPrefHeight(46);
        turnOnOff.setLayoutX(203);
        turnOnOff.setLayoutY(16);

        Image ONSwitch = new Image(new FileInputStream("C:\\Users\\SS\\Desktop\\Dp1\\src\\main\\java\\com\\example\\dp1\\OnSwitch.png"));
        Image OffSwitch = new Image(new FileInputStream("C:\\Users\\SS\\Desktop\\Dp1\\src\\main\\java\\com\\example\\dp1\\OffSwitch.png"));
        ImageView OnOff = new ImageView(OffSwitch);
        OnOff.setLayoutX(332);
        OnOff.setLayoutY(-58);
        OnOff.setFitWidth(200);
        OnOff.setFitHeight(200);


        Button buttonOnOff = new Button("");
        buttonOnOff.setStyle("-fx-background-color: Transparent;");
        buttonOnOff.setPrefWidth(140);
        buttonOnOff.setPrefHeight(83);
        buttonOnOff.setLayoutX(361);
        buttonOnOff.setLayoutY(12);

        buttonOnOff.setOnAction(event -> {
            OnOff.setImage(ONSwitch);
            for (int i = 0; i < switches.length; i++) {
                if (lis.ON[i]==true)
                {


                    Bulbs[i].setImage(bulbOn);
                    switches[lis.LEDS[i]-1].setFill(Color.GOLD);
                    // Calculate the coordinates for the line endpoints
                    double x1 = Bulbs[i].getLayoutX() + Bulbs[i].getFitWidth() / 2;
                    double y1 = Bulbs[i].getLayoutY() + Bulbs[i].getFitHeight() / 2;
                    double x2 = switches[lis.LEDS[i]-1].getLayoutX() ;
                    double y2 = switches[lis.LEDS[i]-1].getLayoutY() + switches[lis.LEDS[i]-1].getRadius();
                    Line line = new Line() ;
                    line.setStroke(Color.RED);
                    line.startXProperty().bind(bulbs.layoutXProperty().add(x1));
                    line.startYProperty().bind(bulbs.layoutYProperty().add(y1));

                    line.endXProperty().bind(switching.layoutXProperty().add(x2));
                    line.endYProperty().bind(switching.layoutYProperty().add(y2));

                    mainPane.getChildren().addAll(line);
                }
            }
        });

        mainPane.getChildren().addAll(switching,bulbs,circlesN,Nums,turnOnOff,OnOff,buttonOnOff,SwitchsNumbering);
        Scene scene = new Scene(mainPane,828,480);
        Stage Simulation = new Stage();
        Simulation.setResizable(true);
        Simulation.setScene(scene);
        Simulation.show();
    }

    public void TablesStage() {
        AnchorPane mainPane = new AnchorPane();
        Rectangle topbar = new Rectangle();
        topbar.setFill(Paint.valueOf("#0f3559"));
        topbar.setWidth(606);
        topbar.setHeight(47);
        topbar.setLayoutX(-3);
        topbar.setLayoutY(0);
        mainPane.getChildren().add(topbar);
        Rectangle bar1 = new Rectangle();
        bar1.setWidth(606);
        bar1.setHeight(10);
        bar1.setLayoutX(-3);
        bar1.setLayoutY(153);
        bar1.setFill(Paint.valueOf("#0f3559"));
        mainPane.getChildren().add(bar1);
        Rectangle bar2 = new Rectangle();
        bar2.setFill(Paint.valueOf("#0f3559"));
        bar2.setWidth(606);
        bar2.setHeight(10);
        bar2.setLayoutY(273);
        bar2.setLayoutX(-3);
        mainPane.getChildren().add(bar2);

        Label Lis = new Label();
        Label subarr = new Label();
        Label subsequence = new Label();

        Lis.setPrefWidth(583);
        Lis.setPrefHeight(30);
        Lis.setLayoutX(18);
        Lis.setLayoutY(87);
        Lis.setFont(Font.font("Andalus",28));
        Lis.setTextFill(Color.BLACK);

        String l = "LIS : ";
        for (int i = 0; i <lis.lis1.length-1; i++) {
            l = l + lis.lis1[i]+"  |  ";
        }
        l = l+lis.lis1[lis.lis1.length-1];
        Lis.setTextFill(Color.BLACK);
        Lis.setText(l);
        mainPane.getChildren().add(Lis);

        subarr.setTextFill(Color.BLACK);
        subarr.setFont(Font.font("Andalus",28));
        subarr.setPrefWidth(583);
        subarr.setPrefHeight(30);

        subarr.setLayoutX(18);
        subarr.setLayoutY(200);
        String l2 = "Subarray : ";
        for (int i = 0; i < lis.subArray.length-1; i++) {
            l2 = l2 + lis.subArray[i]+" | ";
        }
        l2 = l2 +lis.subArray[lis.subArray.length-1];
        subarr.setText(l2);
        subsequence.setTextFill(Color.BLACK);
        subsequence.setFont(Font.font("Andalus",28));
        subsequence.setPrefWidth(583);
        subsequence.setPrefHeight(30);

        subsequence.setLayoutX(18);
        subsequence.setLayoutY(318);

        String l3 = "The first array represents the longest increasing subsequnce length on each index,\nthe max of these values is the lis. ";
        subsequence.setText(l3);

        mainPane.getChildren().addAll(subarr);



        Scene scene = new Scene(mainPane,600,400);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();

    }
    public void PrintTableStat(){
        TextArea textarea=new TextArea();
        textarea.setText(LIS.arraystat.toString());
        Stage stage = new Stage() ;
        AnchorPane anchorPane = new AnchorPane() ;
        anchorPane.getChildren().add(textarea);
        Scene scene = new Scene(anchorPane , 500 ,500);
        stage.setScene(scene);
        stage.show();
    }
//    public void printArrayHorizontally(TextArea textArea, Object[] array, String label) {
//        TextArea textArea = new TextArea();
//        textArea.setEditable(false);
//
//        int[] intArray = {1, 2, 3, 4, 5};
//        String[] stringArray = {"apple", "banana", "cherry"};
//
//        printArrayHorizontally(textArea, intArray, "Integer Array:");
//        printArrayHorizontally(textArea, stringArray, "\nString Array:");
//
//        VBox root = new VBox(textArea);
//        Scene scene = new Scene(root, 400, 300);
//
//        textArea.appendText(label + "\n");
//        HBox valuesBox = new HBox();
//        HBox indexesBox = new HBox();
//        for (int i = 0; i < array.length; i++) {
//            valuesBox.getChildren().add(new Text(array[i].toString()));
//            indexesBox.getChildren().add(new Text(i + ":"));
//        }
//        textArea.appendText(valuesBox.getChildren().toString().replaceAll("[\\[\\]]", "") + "\n");
//        textArea.appendText(indexesBox.getChildren().toString().replaceAll("[\\[\\]]", "") + "\n");
//    }

    public static void main(String[] args) {
        launch(args);
    }

}
