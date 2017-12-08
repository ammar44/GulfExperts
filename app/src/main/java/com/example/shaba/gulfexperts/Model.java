package com.example.shaba.gulfexperts;

import android.widget.Button;

/**
 * Created by shaba on 2017-10-24.
 */

public class Model {
    private Button button;
  String name ;

    public Model(Button button, String name) {
        button = button;

    }

    public Button getButton() {
        return button;
    }

    public void setButton(Button button) {
        this.button = button;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
