package edu.altstu.sociointerview.controllers;

import edu.altstu.sociointerview.entities.Candidate;
import edu.altstu.sociointerview.entities.Income;
import edu.altstu.sociointerview.entities.Question;
import edu.altstu.sociointerview.entities.Respondent;
import edu.altstu.sociointerview.entities.enums.Education;
import edu.altstu.sociointerview.entities.enums.FamityMaterialConditionsEvaluation;
import edu.altstu.sociointerview.entities.enums.Gender;
import edu.altstu.sociointerview.entities.enums.HaveCar;
import edu.altstu.sociointerview.entities.enums.LivingTimeInMoscow;
import edu.altstu.sociointerview.entities.enums.UsingInternet;
import edu.altstu.sociointerview.entities.enums.Work;
import edu.altstu.sociointerview.services.IncomeService;
import edu.altstu.sociointerview.services.RespondentsService;
import edu.altstu.sociointerview.util.ChartData;
import edu.altstu.sociointerview.util.RespondentFilter;
import edu.altstu.sociointerview.util.StringUtils;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController implements Initializable {

    // <editor-fold defaultstate="collapsed" desc="comboboxes and text fields from first page and button">
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
    // </editor-fold>

    private RespondentsService respondentsService;
    private IncomeService incomeService;
    
    @FXML
    private void countData() {
        RespondentFilter filter = new RespondentFilter();
        if (!StringUtils.isEmpty(lowerAge.getText())) {
            filter.setLowerAgeBorder(Integer.parseInt(lowerAge.getText()));
        }
        if (!StringUtils.isEmpty(higherAge.getText())) {
            filter.setHigherAgeBorder(Integer.parseInt(higherAge.getText()));
        }
        filter.setGender(genders.getValue());
        filter.setEducation(educations.getValue());
        filter.setEvaluation(evaluations.getValue());
        filter.setHaveCar(haveCars.getValue());
        filter.setIncome(incomes.getValue());
        filter.setLivingTimeInMoscow(livingTimeImMoscow.getValue());
        filter.setUsingInternet(usingInternet.getValue());
        filter.setWork(works.getValue());
        
        Question asked = questions.getValue();
        List<ChartData> data;
        if (asked.getNeedCandidate()) {
            Candidate candidate = candidates.getValue();
            data = respondentsService.getRespondentsForCandidate(filter, asked, candidate);
        } else {
            data = respondentsService.getRespondentsAnswers(filter, asked);
        }
        
        if (type.getSelectionModel().getSelectedIndex() == 0) {
            pie.setVisible(true);
            pie.setData(FXCollections.observableArrayList(
                    data
                            .stream()
                            .map(piece -> new PieChart.Data(piece.getLegend(), piece.getNumber()))
                            .collect(Collectors.toList())
            ));
            if (asked.getNeedCandidate()) {
                Candidate candidate = candidates.getValue();
                pie.setTitle(asked.getText() + " " + candidate.getId() + " (" + candidate.getFio() + ")");
            } else {
                pie.setTitle(asked.getText());
            }
            
            bar.setVisible(false);
        } else {
            pie.setVisible(false);
            bar.setVisible(true);
        }
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
    private ComboBox<ChartType> type;

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
        genders.getItems().addAll(FXCollections.observableArrayList(Gender.values()));
        evaluations.getItems().addAll(FXCollections.observableArrayList(FamityMaterialConditionsEvaluation.values()));
        educations.getItems().addAll(FXCollections.observableArrayList(Education.values()));
        haveCars.getItems().addAll(FXCollections.observableArrayList(HaveCar.values()));
        usingInternet.getItems().addAll(FXCollections.observableArrayList(UsingInternet.values()));
        livingTimeImMoscow.getItems().addAll(FXCollections.observableArrayList(LivingTimeInMoscow.values()));
        works.getItems().addAll(FXCollections.observableArrayList(Work.values()));
//        incomes.getItems().addAll(FXCollections.observableArrayList(incomeService.getAllIncomes()));
        
        type.getItems().addAll(FXCollections.observableArrayList(ChartType.values()));
        type.getSelectionModel().select(0);
    }
}
