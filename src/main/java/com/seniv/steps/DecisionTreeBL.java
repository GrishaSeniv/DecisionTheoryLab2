package com.seniv.steps;

import com.seniv.lib.Path;
import com.seniv.lib.GSON;
import com.seniv.lib.MatrixActions;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DecisionTreeBL {

    public void run() {
        GSON<DecisionTreeEntity> gson = new GSON();
        MatrixActions matrixActions = new MatrixActions();
        List<DecisionTreeEntity> decisionsList = gson.readFromFile(new File(Path.LAB2_FILE_DIRECTORY), DecisionTreeEntity[].class);
        ArrayList<Double> resultValues = new ArrayList<>();
        System.out.println("LAB 2\nHRYHORII SENIV\nDECISION TREE\n");

        for (DecisionTreeEntity decision : decisionsList) {
            System.out.println(decision.toString());
            System.out.println(decision.printFormula());
            System.out.print("Coefficient = ");
            resultValues.add(decision.findDecisionValue());
            System.out.println(decision.findDecisionValue() + "\n");
        }

        int indexOfTheBest = resultValues.indexOf(getBiggestInArraylist(resultValues));
        System.out.println("==================================");
        System.out.print("The best solution is: ");
        System.out.println(decisionsList.get(indexOfTheBest));
        System.out.print("Coefficient = ");
        System.out.println(resultValues.get(indexOfTheBest));
        System.out.println("__________________________________\n");
    }

    private Double getBiggestInArraylist(ArrayList<Double> doubleArrayList) {
        return doubleArrayList.stream().max(Double::compareTo).get();
    }

}
