package com.mypackage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
public class Logo extends ImageView{
    Logo(){
        super();
        setImage(new Image("com/mypackage/logo.jpg"));
        setFitWidth(200);
        setFitHeight(200);
        setPreserveRatio(true);
        setSmooth(true);
        setCache(true);
    }
}
