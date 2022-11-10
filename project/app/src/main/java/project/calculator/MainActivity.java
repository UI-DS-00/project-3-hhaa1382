package project.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private TextView answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTextValues(findViewById(R.id.number1_button),"1");
        setTextValues(findViewById(R.id.number2_button),"2");
        setTextValues(findViewById(R.id.number3_button),"3");
        setTextValues(findViewById(R.id.number4_button),"4");
        setTextValues(findViewById(R.id.number5_button),"5");
        setTextValues(findViewById(R.id.number6_button),"6");
        setTextValues(findViewById(R.id.number7_button),"7");
        setTextValues(findViewById(R.id.number8_button),"8");
        setTextValues(findViewById(R.id.number9_button),"9");
        setTextValues(findViewById(R.id.number0_button),"0");
        setTextValues(findViewById(R.id.dot_button),".");
        setTextValues(findViewById(R.id.power_button),"^");
        setTextValues(findViewById(R.id.plus_button),"+");
        setTextValues(findViewById(R.id.minus_button),"-");
        setTextValues(findViewById(R.id.divide_button),"/");
        setTextValues(findViewById(R.id.multiple_button),"*");
        setTextValues(findViewById(R.id.open_parenthesis_button),"(");
        setTextValues(findViewById(R.id.close_parenthesis_button),")");

        Button equal=findViewById(R.id.equal_button);
        Button positiveMinus=findViewById(R.id.positive_minus_button);
    }

    private void setTextValues(Button button,String value){
        button.setOnClickListener(e->{
            String temp=String.valueOf(text.getText());
            text.setText(temp+value);
        });
    }
}