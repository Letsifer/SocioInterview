package edu.altstu.sociointerview.controllers;

import edu.altstu.sociointerview.entities.Candidate;
import edu.altstu.sociointerview.entities.Income;
import edu.altstu.sociointerview.entities.Question;
import edu.altstu.sociointerview.entities.enums.Education;
import edu.altstu.sociointerview.entities.enums.FamityMaterialConditionsEvaluation;
import edu.altstu.sociointerview.entities.enums.Gender;
import edu.altstu.sociointerview.entities.enums.HaveCar;
import edu.altstu.sociointerview.entities.enums.LivingTimeInMoscow;
import edu.altstu.sociointerview.entities.enums.UsingInternet;
import edu.altstu.sociointerview.entities.enums.Work;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {
    
    @FXML
    private ComboBox<Gender> genders;
    
    @FXML
    private ComboBox<LivingTimeInMoscow> livingTimeImMoscow;
    
    @FXML
    private ComboBox<Education> educations;
    
    @FXML
    private ComboBox<UsingInternet> usingInternet;
    
    @FXML
    private ComboBox<Income> incomes;
    
    @FXML
    private ComboBox<Work> works;
    
    @FXML
    private ComboBox<FamityMaterialConditionsEvaluation> evaluations;
    
    @FXML
    private ComboBox<HaveCar> haveCars;
    
    @FXML
    private TextField lowerAge;
    
    @FXML
    private TextField higherAge;
    
    @FXML
    private Button buttonCount;
    
    @FXML
    private void countData() {
        
    }
    
    @FXML    
    private BarChart bar;
    
    @FXML
    private PieChart pie;
    
    @FXML
    private ComboBox<Question> questions;
    
    @FXML
    private ComboBox<Candidate> candidates;
    
    @FXML
    private TextArea description;
    
    @FXML
    private ComboBox type;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bar.setVisible(false);
        pie.setVisible(false);
        lowerAge.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    lowerAge.setText(oldValue);
                }
            }
        });
        higherAge.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*")) {
                    higherAge.setText(oldValue);
                }
            }
        });
        genders.setItems(FXCollections.observableArrayList(Gender.values()));
    }    
}
