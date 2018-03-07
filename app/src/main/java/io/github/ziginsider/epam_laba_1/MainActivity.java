package io.github.ziginsider.epam_laba_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * @author Alex Kisel
 * @since 2018-03-07
 */
public class MainActivity extends AppCompatActivity {

    TextView textView;
    Button button;
    List<String> words;
    RowsGenerate rowsGenerate = new RowsGenerate();
    int numberRows = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.text_view);
        button = findViewById(R.id.button);

        initClickButton();

    }

    /**
     * <b>Implementation button onClick()</b>
     * <br>
     * If button has pressed then called {@link RowsGenerate#getRows(Integer)}
     * <br>
     * Gets a list of rows and displays on screen.
     *
     * @see RowsGenerate#getRows(Integer)
     */
    void initClickButton() {
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                words = rowsGenerate.getRows(numberRows);
                StringBuilder text = new StringBuilder();
                for (int i = 0; i < words.size(); i++) {
                    text.append(words.get(i) + "\n");
                }
                textView.setText(text);
            }
        });
    }


}

