package gui.pizza;
 
import javafx.application.*;
import javafx.stage.*;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
public class Pizza extends Application
{
 
    private Configuration conf;
    private TextArea      bestelltext;
 
    public void start(Stage primaryStage)
    {
        conf = ParameterConverter
                .createConfiguration(getParameters().getNamed());
        VBox root = new VBox();
        for (int i = 0; i < conf.getToppingNames().length; i++)
        {
            CheckBox cb = new CheckBox(conf.getToppingNames()[i]);
            cb.setId(conf.getToppingNames()[i]);
            cb.setAccessibleText(Integer.toString(conf.getToppingPrices()[i]));
            if (i < conf.getNumberOfDefaultToppings())
            {
                cb.setSelected(true);
                cb.setDisable(true);
 
            }
            root.getChildren().add(cb);
        }
 
        ToggleGroup tg = new ToggleGroup();
        for (int i = 0; i < conf.getSizeNames().length; i++)
        {
            RadioButton rb = new RadioButton(conf.getSizeNames()[i]);
            rb.setId(conf.getSizeNames()[i]);
            rb.setAccessibleText(Integer.toString(conf.getSizePrices()[i]));
            rb.setToggleGroup(tg);
            root.getChildren().add(rb);
 
        }
 
        Button btn = new Button("Bestellen!");
        btn.setOnAction(e ->
        {
            String btxt = "Sie haben einer Pizza bestellt";
            String zutaten = "", gr = "";
            int sum = 0;
 
            for (Node currentNode : root.getChildren())
            {
                if (currentNode instanceof CheckBox
                        && ((CheckBox) currentNode).isSelected())
                {
                    zutaten += currentNode.getId();
                    sum += Integer.parseInt(currentNode.getAccessibleText());
                }
                if (currentNode instanceof ToggleButton
                        && ((ToggleButton) currentNode).isSelected())
                {
                    gr = currentNode.getId();
                    sum += Integer.parseInt(currentNode.getAccessibleText());
 
                }
            }
            btxt += "\nZutaten: " + zutaten;
            btxt += "\nDie Grösse ist: " + gr;
            btxt += "\nDer Preis beträgt: " + (sum / 100);
            btxt += "\nVielen Dank.";
            bestelltext.setText(btxt);
 
        });
        root.getChildren().add(btn);
        bestelltext = new TextArea();
        bestelltext.setId("bestelltext");
        bestelltext.setEditable(false);
        root.getChildren().add(bestelltext);
        Scene scene = new Scene(root, 350, 400);
        primaryStage.setTitle("Pizza");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] arg0) throws Exception
    {
        // TODO Auto-generated method stub
        launch(arg0);
    }
 
}