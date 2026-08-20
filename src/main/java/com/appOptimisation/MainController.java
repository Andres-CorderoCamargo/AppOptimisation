package com.appOptimisation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import oshi.SystemInfo;
import oshi.hardware.PowerSource;
import java.util.List;

public class MainController {

    @FXML
    private Label etat;

    @FXML
    private Button help;

    @FXML
    private VBox details;

    @FXML
    private Button battery;

    @FXML
    private Button storage;

    @FXML
    private Button cpu;

    @FXML
    private Button pda;

    @FXML
    private Button oa;

    @FXML
    private AnchorPane principal_view;

    @FXML
    private ProgressBar batteryProgressBar;
    
    @FXML
    private Label lblPorcentaje;
    
    @FXML
    private Label lblEstado;

    @FXML
    public void initialize() {
        afficherViewBatterie();
        battery.requestFocus();
    }

    private void afficherViewBatterie() {
        principal_view.getChildren().clear();

        batteryProgressBar = new ProgressBar(0.0);
        batteryProgressBar.setPrefWidth(200);

        lblPorcentaje = new Label("0%");
        lblEstado = new Label("Obteniendo estado...");

        afficherDonneesBatterie();

        VBox binfo = new VBox(10);
        binfo.getChildren().addAll(
            new Label("État de la batterie:"),
            batteryProgressBar,
            lblPorcentaje,
            lblEstado
        );

        AnchorPane.setTopAnchor(binfo, 15.0);
        AnchorPane.setLeftAnchor(binfo, 15.0);

        principal_view.getChildren().add(binfo);
    }

    public void afficherDonneesBatterie() {
        SystemInfo si = new SystemInfo();
        List<PowerSource> powerSources = si.getHardware().getPowerSources();

        if (!powerSources.isEmpty()) {
            PowerSource ps = powerSources.get(0);

            double porcentageNatif = ps.getRemainingCapacityPercent(); 
            boolean charging = ps.isPowerOnline();

            batteryProgressBar.setProgress(porcentageNatif);
            lblPorcentaje.setText(String.format("%.0f%%", porcentageNatif * 100));
            lblEstado.setText(charging ? "Connecté au secteur" : "Sur batterie");
        } 
        else {
            batteryProgressBar.setProgress(0);
            lblEstado.setText("Batterie non détectée (PC fixe)");
        }
    }
}