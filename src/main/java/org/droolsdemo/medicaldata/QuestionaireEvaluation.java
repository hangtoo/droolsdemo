package org.droolsdemo.medicaldata;

public class QuestionaireEvaluation {

    public boolean hasCriticalBodyMassIndex(HealthData input) {
        boolean result = false;

        float bmi = input.getBodyWeight() / (input.getBodyWeight() * input.getBodyWeight());

        if (bmi < 19 || bmi > 25) {
            result = true;
        }

        return result;
    }
}
