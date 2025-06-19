package com.example.calculator;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView result;
    TextView working;

    String formula = "";
    String workingText = "";
    String tempFormula = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        initTextViews();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        workingText = "2^3+4^2"; // Example input
        checkForPower();
        Log.d("ParsedFormula", tempFormula); // Output: Math.pow(2,3)+Math.pow(4,2)
    }

    private void initTextViews() {
        result = findViewById(R.id.result);
        working = findViewById(R.id.working);
    }
    private void setWorkings(String givenValues)
    {
        workingText = workingText + givenValues;
        working.setText(workingText);
    }
    private void checkForPower() {
        ArrayList<Integer> indexOfPower = new ArrayList<>();
        for (int i = 0; i < workingText.length(); i++) {
            if (workingText.charAt(i) == '^') {
                indexOfPower.add(i);
            }
        }

        formula = workingText;
        tempFormula = workingText;

        for (int index : indexOfPower) {
            changeFormula(index);
        }

        formula = tempFormula;
    }

    private void changeFormula(Integer index) {
        String numberLeft = "";
        String numberRight = "";

        for (int i = index + 1; i < workingText.length(); i++) {
            if (isNumeric(workingText.charAt(i))) {
                numberRight += workingText.charAt(i);
            } else {
                break;
            }
        }

        for (int i = index - 1; i >= 0; i--) {
            if (isNumeric(workingText.charAt(i))) {
                numberLeft = workingText.charAt(i) + numberLeft;
            } else {
                break;
            }
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow(" + numberLeft + "," + numberRight + ")";
        tempFormula = tempFormula.replace(original, changed);
    }

    private boolean isNumeric(char c) {
        return (c >= '0' && c <= '9') || c == '.';
    }
    public void clearOnClick(View view)
    {
        working.setText("");
        result.setText("");
        workingText="";
        leftBracket = false;
    }
    boolean leftBracket = true;
    public void bracketsOnClick(View view)
    {
        if(leftBracket == true)
        {
            setWorkings("(");
            leftBracket = false;
        }
        else{
            setWorkings(")");
            leftBracket = true;
        }
    }
    public void powerOfOnClick(View view)
    {
        setWorkings("^");
    }
    public void oneOnClick(View view)
    {
        setWorkings("1");
    }
    public void twoOnClick(View view)
    {
        setWorkings("2");
    }
    public void threeOnClick(View view)
    {
        setWorkings("3");
    }
    public void fourOnClick(View view)
    {
        setWorkings("4");
    }
    public void fiveOnClick(View view)
    {
        setWorkings("5");
    }
    public void sixOnClick(View view)
    {
        setWorkings("6");
    }
    public void sevenOnClick(View view)
    {
        setWorkings("7");
    }
    public void eightOnClick(View view)
    {
        setWorkings("8");

    }
    public void nineOnClick(View view)
    {
        setWorkings("9");
    }
    public void zeroOnClick(View view)
    {
        setWorkings("0");
    }
    public void multiplyOnClick(View view)
    {
        setWorkings("*");
    }
    public void divisionOnClick(View view)
    {
        setWorkings("/");
    }
    public void subractOnClick(View view)
    {
        setWorkings("-");
    }
    public void addOnClick(View view)
    {
        setWorkings("+");
    }
    public void clearOnClick(View view)
    {
        setWorkings("C");
    }
    public void bracketsOnClick(View view)
    {
        setWorkings("()");
    }
    public void equaltoOnClick(View view)
    {
        setWorkings("=");
    }
    public void decimalOnClick(View view)
    {
        setWorkings(".");
    }
}
