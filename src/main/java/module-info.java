module com.example.fxcheck {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    exports lamoreaux_landon.catcafe;
    opens lamoreaux_landon.catcafe to javafx.fxml;
}