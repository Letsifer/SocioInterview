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
import edu.altstu.sociointerview.services.CandidateService;
import edu.altstu.sociointerview.services.CandidateServiceImpl;
import edu.altstu.sociointerview.services.IncomeService;
import edu.altstu.sociointerview.services.IncomeServiceImpl;
import edu.altstu.sociointerview.services.InputService;
import edu.altstu.sociointerview.services.InputServiceImpl;
import edu.altstu.sociointerview.services.QuestionServiceImpl;
import edu.altstu.sociointerview.services.QuestionServices;
import edu.altstu.sociointerview.services.RespondentsService;
import edu.altstu.sociointerview.services.RespondentsServiceImpl;
import edu.altstu.sociointerview.util.ChartData;
import edu.altstu.sociointerview.util.RespondentFilter;
import edu.altstu.sociointerview.util.StringUtils;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Side;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Tab;
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

    //<editor-fold defaultstate="collapsed" desc="controls from second page">
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
//</editor-fold>

    private final RespondentsService respondentsService = new RespondentsServiceImpl();
    private final IncomeService incomeService = new IncomeServiceImpl();
    private final InputService inputService = new InputServiceImpl();
    private final QuestionServices questionServices = new QuestionServiceImpl();
//    private final AnswerService answerService = new AnswerServiceImpl();
    private final CandidateService candidateService = new CandidateServiceImpl();

//    private DecimalFormat decimalFormat = new DecimalFormat(pattern)
    
    @FXML
    private void countData() {
        if (questions.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Ошибка");
            alert.setContentText("Выберите вопрос");
            alert.showAndWait();
            return;
        }
        if (questions.getValue().getNeedCandidate() && candidates.getValue() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Ошибка");
            alert.setContentText("Выберите кандидата");
            alert.showAndWait();
            return;
        }
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

        int respondentNumber = respondentsService.getRespondentsNumber(filter);
        String title = "Количество респондентов: " + respondentNumber;
//        if (asked.getNeedCandidate()) {
//            Candidate candidate = candidates.getValue();
//            title = asked.getText() + " " + candidate.getId() + " (" + candidate.getFio() + ")";
//        } else {
//            title = asked.getText();
//        }

        if (type.getSelectionModel().getSelectedIndex() == 0) {
            pie.setVisible(true);
            pie.setData(FXCollections.observableArrayList(
                    data
                            .stream()
                            .map(piece -> new PieChart.Data(piece.getLegend(), piece.getNumber()))
                            .peek(piece
                                    -> piece.nameProperty().bind(
                                    Bindings.concat(
                                            piece.getName(),
                                            " ",
                                            piece.pieValueProperty().intValue(),
                                            "(",
                                            String.format("%.2f", piece.pieValueProperty().divide(respondentNumber).multiply(100).doubleValue()),
                                            "%)"
                                    )
                            ))
                            .collect(Collectors.toList())
            ));
            pie.setTitle(title);
            pie.setLegendSide(Side.LEFT);

            bar.setVisible(false);
        } else {
            pie.setVisible(false);
            bar.setVisible(true);

            XYChart.Series answers = new XYChart.Series();
            answers.setData(FXCollections.observableArrayList(
                    data
                            .stream()
                            .map(piece -> new XYChart.Data<>(piece.getLegend(), piece.getNumber()))
                            .collect(Collectors.toList())
            ));
            bar.setTitle(title);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb
    ) {
        addResps.setDisable(true);
        addAns.setDisable(true);
        bar.setVisible(false);
        pie.setVisible(false);
        description.setDisable(true);

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

        incomes.getItems().add(null);//!!!!
        incomes.getItems().addAll(FXCollections.observableArrayList(incomeService.getAllIncomes()));

        questions.getItems().addAll(questionServices.getAllQuestions());
        questions.setOnAction((event) -> {
            candidates.setDisable(!questions.getValue().getNeedCandidate());
        });

        candidates.getItems().addAll(candidateService.getAllCandidates());
        candidates.setOnAction((event) -> {
            description.setText(candidates.getValue().getDescription());
        });

        type.getItems().addAll(FXCollections.observableArrayList(ChartType.values()));
        type.getSelectionModel().select(0);
    }

    @FXML
    private Tab addDataTab;

    @FXML
    private Button addResps;

    @FXML
    private Button addAns;

    @FXML
    private void addRespsData() {
        try {
            inputService.inputRespondentsData();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void addAnsData() {
        try {
            inputService.inputAnswers();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
