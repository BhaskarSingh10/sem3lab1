package com.example.lab1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CurrencyConvertor {

    @FXML
    private TextField amountTextField;

    @FXML
    private TextField resultTextField;

    @FXML
    private ComboBox<String> sourceCurrencyComboBox;

    @FXML
    private ComboBox<String> targetCurrencyComboBox;

    @FXML
    private Button button;

    @FXML
    private void initialize() {
        // Initialize ComboBox items and set default values if needed.
        sourceCurrencyComboBox.getItems().addAll("CAD", "JPY", "INR", "CNY");
        targetCurrencyComboBox.getItems().addAll("CAD", "JPY", "INR", "CNY");
        // Set default values or prompts if needed.
        sourceCurrencyComboBox.setValue("CAD");
        targetCurrencyComboBox.setValue("JPY");
    }

    @FXML
    private void handleConvertButton() {
        // Get input amount and selected currencies.
        String sourceCurrency = sourceCurrencyComboBox.getValue();
        String targetCurrency = targetCurrencyComboBox.getValue();

        try {
            double amount = Double.parseDouble(amountTextField.getText());

            // Perform the conversion using hardcoded rates (for simplicity).
            double conversionRate = getConversionRate(sourceCurrency, targetCurrency);
            double convertedAmount = amount * conversionRate;

            // Display the converted amount.
            resultTextField.setText(String.format("%.2f %s", convertedAmount, targetCurrency));
        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric).
            resultTextField.setText("Invalid input");
        }
    }

    // Method to get the conversion rate (you may use an API or a database in a real application).
    private double getConversionRate(String sourceCurrency, String targetCurrency) {
        // Replace with actual currency conversion rates.
        switch (sourceCurrency + "-" + targetCurrency) {
            case "CAD-JPY":
                return 80.15;
            case "CAD-INR":
                return 43.92;
            case "CAD-CNY":
                return 3.12;
            case "JPY-INR":
                return 0.69;
            case "JPY-CNY":
                return 0.90;
            case "INR-CNY":
                return 3.54;
            // Add more currency conversions here as needed.
            default:
                throw new IllegalArgumentException("Unsupported conversion: " + sourceCurrency + "-" + targetCurrency);
        }
    }
}
