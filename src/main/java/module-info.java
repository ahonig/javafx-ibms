module py.com.honig.ibmsfx {
    requires javafx.controls;
    requires javafx.fxml;


    opens py.com.honig.ibmsfx to javafx.fxml;
    exports py.com.honig.ibmsfx;
}