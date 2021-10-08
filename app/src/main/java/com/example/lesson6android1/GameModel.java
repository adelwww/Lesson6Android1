package com.example.lesson6android1;

import java.io.Serializable;

public class GameModel implements Serializable {
    String level;
    String imageAddressFirst;
    String imageAddressSecond;
    String imageAddressThird;
    String imageAddressFourth;
    String answer;

    public GameModel(String level, String imageAddressFirst, String imageAddressSecond, String imageAddressThird, String imageAddressFourth, String answer) {
        this.level = level;
        this.imageAddressFirst = imageAddressFirst;
        this.imageAddressSecond = imageAddressSecond;
        this.imageAddressThird = imageAddressThird;
        this.imageAddressFourth = imageAddressFourth;
        this.answer = answer;
    }

}
