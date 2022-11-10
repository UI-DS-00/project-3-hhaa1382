package project.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView text;
    private TextView answer;
    private Calculator calculator=new Calculator();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeValues();
    }

    private void initializeValues(){
        text=findViewById(R.id.text_value);
        answer=findViewById(R.id.answer);

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
        equal.setOnClickListener(e->{
            double ans=calculator.getAnswer(String.valueOf(text.getText()));
            answer.setText(String.valueOf(ans));
        });

        Button positiveMinus=findViewById(R.id.positive_minus_button);
        positiveMinus.setOnClickListener(e->{
            if(checkMinus(String.valueOf(text.getText()))){
                String temp=String.valueOf(text.getText());
                text.setText(temp+"-");
            }
        });

        Button clean=findViewById(R.id.clean_button);
        clean.setOnClickListener(e->{
            text.setText("");
            answer.setText("");
        });
    }

    private void setTextValues(Button button,String value){
        button.setOnClickListener(e->{
            String temp=String.valueOf(text.getText());
            text.setText(temp+value);
        });
    }

    private boolean checkMinus(String text){
        return text.length()==0 || text.charAt(text.length()-1)=='(';
    }
}