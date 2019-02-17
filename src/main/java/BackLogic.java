// Class BackLogic is intended to pass in the logic required for the Main Application


import java.util.Set;
import java.util.zip.DeflaterOutputStream;

public class BackLogic {

    // Checks to see if the 4 Numbers Can Get to 24
    public boolean ableToArriveAt24Attempt1 (Double[] fourNumbers) {
        boolean ableToGetTo24 = false;
        // for loops to iterate through and assign number positions
        for (int w = 0; w < 4; w++) {
            Double number1 = fourNumbers[w];
            Double[] threeNumbers = removeTheElement(fourNumbers, w);
            for (int x = 0; x < 3; x++){
                Double number2 = threeNumbers[x];
                Double[] twoNumbers = removeTheElement(threeNumbers, x);
                for (int y = 0; y < 2; y++){
                    Double number3 = twoNumbers[y];
                    Double[] oneNumber = removeTheElement(twoNumbers, y);
                    Double number4 = oneNumber[0];
                    // for loops to iterate through and assign operation positions
                    for (int op1 = 0; op1 < 4; op1++) {
                        for (int op2 = 0; op2 < 4; op2++) {
                            for (int op3 = 0; op3 < 4; op3++) {
                                // check 1 op 2 op 3 op 4
                                if (checkNoParenthesis(number1, number2, number3, number4, op1, op2, op3)){
                                    ableToGetTo24 = true;
                                    break;
                                }
                                // check (1 op 2) op (3 op 4)
                                if (checkTwoParenthesis(number1, number2, number3, number4, op1, op2, op3)){
                                    ableToGetTo24 = true;
                                    break;
                                }
                                // check to break
                                if(ableToGetTo24) {break;}
                            }
                            if(ableToGetTo24) {break;}
                        }
                        if(ableToGetTo24) {break;}
                    }
                    if(ableToGetTo24) {break;}
                }
                if(ableToGetTo24) {break;}
            }
            if(ableToGetTo24) {break;}
        }
        return ableToGetTo24;
    }

    /*
    public boolean ableToArriveAt24Attempt2 (Double[] fourNumbers) {
        boolean getTo24 = false;
        Set<Double> firstSet = new Set<>;
        Set<Double> secondSet = new Set<>;
        Set<Double> thirdSet = new Set<>;

        Set<Double> firstParenthesisSet = new Set<>;
        Set<Double> secondParenthesisSet = new Set<>;
        Set<Double> thirdParenthesisSet = new Set<>;

        mainloop:
        // iterate for first number to apply to 24
        for (Double number1 : fourNumbers){
            Double[] threeNumbers = removeTheElement(fourNumbers, number1);
            for (int operation1 = 0; operation1 < 4; operation1++){
                firstSet.add(performOperation(24.0, number1, operation1));
            }

            // iterate for second number to apply to 24
            for (Double number2 : threeNumbers) {
                Double[] twoNumbers = removeTheElement(threeNumbers, number2);
                for (int operation2 = 0; operation2 < 4; operation2++) {
                    // firstset setmaker
                    for (Double firstSetValue : firstSet) {
                        secondSet.add(performOperation(firstSetValue, number2, operation2));
                    }
                    firstParenthesisSet.add(performOperation(number1, number2, operation2));
                }

                // iterate for third number to apply to 24
                for (Double number3 : twoNumbers) {
                    Double lastNumber = removeTheElement(threeNumbers, number3)[0];
                    for (int operation3 = 0; operation3 < 4; operation3++) {
                        for (Double secondSetValue : secondSet) {
                            thirdSet.add(performOperation(secondSetValue, number3, operation3));
                        }
                        // Create secondParenthesisSet
                        secondParenthesisSet.add(performOperation(number3, lastNumber, operation3));

                                // Create thirdParenthesisSet
                        for (int operation4 = 0; operation4 < 4; operation4++) {
                            for(Double firstParenthesisSetValue : firstParenthesisSet) {
                                for(Double secondParenthesisSetValue : secondParenthesisSet) {
                                    thirdParenthesisSet.add(performOperation(firstParenthesisSetValue, secondParenthesisSetValue, operation4));
                                }
                            }
                        }
                    }

                    // check to see if last number is in third set
                    if (thirdSet.contains(lastNumber)) {
                        getTo24 = true;
                        break mainloop;
                    }
                }
            }
        }
    }
    */

    // Check by recursion

    // lastnumber (0)

    public boolean ableToArriveAt24Attempt3 (Double[] fourNumbers, int codeTry) {
        boolean isSolutionPossible = false;
        int operationOne = codeTry % 4;
        int operationTwo = (codeTry/4) % 4;
        int operationThree = (codeTry/16) % 4;
        Double numberOne = fourNumbers[(codeTry/64) % 4];
        Double[] threeNumbers = removeTheElement(fourNumbers, numberOne);
        Double numberTwo = threeNumbers[(codeTry/256) % 3];
        Double[] twoNumbers = removeTheElement(threeNumbers, numberTwo);
        Double numberThree = twoNumbers[(codeTry/768) % 2];
        Double numberFour = removeTheElement(twoNumbers, numberThree)[0];
        // perform the operations (straight method)
        Double firstOperation = performOperation(numberOne, numberTwo, operationOne);
        Double secondOperation = performOperation(firstOperation, numberThree, operationTwo);
        Double thirdOperation = performOperation(secondOperation, numberFour, operationThree);
        // perform the operations (two parenthesis method)
        Double secondParenthesisOperation = performOperation(numberThree, numberFour, operationThree);
        Double thirdParenthesisOperation = performOperation(firstOperation, secondParenthesisOperation, operationTwo);
        // Check if either is 24
        if (thirdOperation.equals(24.0)) {
            isSolutionPossible = true;
            String message =
                    "" + numberOne + " " + operationConverter(operationOne) + " " +
                            numberTwo + " " + operationConverter(operationTwo) + " " +
                            numberThree + " " + operationConverter(operationThree) + " " +
                            numberFour;
            System.out.println(message);
        }
        else if(thirdParenthesisOperation.equals(24.0)) {
            isSolutionPossible = true;
            String message =
                    "(" + numberOne + " " + operationConverter(operationOne) + " " +
                            numberTwo + ") " + operationConverter(operationTwo) + " (" +
                            numberThree + " " + operationConverter(operationThree) + " " +
                            numberFour + ")";
            System.out.println(message);
        }
        else if (codeTry != 0) {
            isSolutionPossible = ableToArriveAt24Attempt3(fourNumbers, codeTry - 1);
        }
        else {
            isSolutionPossible = false;
        }
        return isSolutionPossible;
    }


    public String operationConverter(int operation) {
        String operator = "";
        if (operation == 0) {operator = "+";}
        if (operation == 1) {operator = "-";}
        if (operation == 2) {operator = "*";}
        if (operation == 3) {operator = "/";}
        return operator;
    }

    public boolean checkTwoParenthesis(Double number1, Double number2, Double number3, Double number4, int op1, int op2, int op3) {
        boolean check = false;
        // Perform first operation
        Double out = performOperation(number1, number2, op1);
        // Perform third operation
        Double out2 = performOperation(number3, number4, op3);
        // Perform second operation
        out = performOperation(out, out2, op2);
        if (out == 24.0) {
            check = true;
            // print how to solve
            String printed = "(" + number1 + op1 + number2 + ")" + op2 + "(" + number3 + op3 + number4 + ")";
            System.out.println(printed);
        }
        return check;
    }

    public boolean checkNoParenthesis(Double number1, Double number2, Double number3, Double number4, int op1, int op2, int op3) {
        boolean check = false;
        // Perform first operation
        Double out = performOperation(number1, number2, op1);
        // Perform second operation
        out = performOperation(out, number3, op2);
        // Perform third operation
        out = performOperation(out, number4, op3);
        if (out == 24.0) {
            check = true;
            // print how to solve
            String printed = "" + number1 + op1 + number2 + op2 + number3 + op3 + number4;
            System.out.println(printed);
        }
        return check;
    }

    public Double performOperation(Double num1, Double num2, int operation) {
        Double output = 0.0;
        if (operation == 0){output = num1 + num2;}
        if (operation == 1){output = num1 - num2;}
        if (operation == 2){output = num1 * num2;}
        if (operation == 3){output = num1 / num2;}
        return output;
    }

    public Double[] removeTheElement(Double[] arr, int index) {
        Double[] returnArray = new Double[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i != index){
                returnArray[k++] = arr[i];
            }
        }
        return returnArray;
    }

    public Double[] removeTheElement(Double[] arr, Double toRemove) {
        Double[] returnArray = new Double[arr.length - 1];
        int i = 0;
        boolean hasRemoved = false;
        for (Double d : arr) {
            if(!d.equals(toRemove) || hasRemoved == true){
                returnArray[i++] = d;
            }
            else {
                hasRemoved = true;
            }
        }
        return returnArray;
    }


}
