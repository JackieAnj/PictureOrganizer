package GUI;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    TreeView<File> tv;
    @FXML
    ImageView imageView;

    private static final String[] VALID_PICTURE_TYPES = {".jpg", ".png"};
    private static TreeItem<File> root;

    private static TreeItem<File> createNode(File f) {
        return new TreeItem<File>(f) {
            private boolean isLeaf;
            private boolean isFirstTimeChildren = true;
            private boolean isFirstTimeLeaf = true;

            @Override
            public ObservableList<TreeItem<File>> getChildren() {
                if (isFirstTimeChildren) {
                    isFirstTimeChildren = false;
                    super.getChildren().setAll(buildChildren(this));
                }
                return super.getChildren();
            }

            @Override
            public boolean isLeaf() {
                if (isFirstTimeLeaf) {
                    isFirstTimeLeaf = false;
                    File f = (File) getValue();
                    isLeaf = f.isFile();
                }
                return isLeaf;
            }

            private ObservableList<TreeItem<File>> buildChildren(
                    TreeItem<File> treeItem) {
                File f = treeItem.getValue();
                if (f == null || f.isFile()) {
                    return FXCollections.emptyObservableList();
                }
                File[] files = f.listFiles();
                if (files != null) {
                    ObservableList<TreeItem<File>> children = FXCollections
                            .observableArrayList();
                    for (File childFile : files) {
                        if (childFile.isDirectory()) {
                            children.add(createNode(childFile));
                        } else {
                            for (String suffix : VALID_PICTURE_TYPES) {
                                if (childFile.getPath().endsWith(suffix)) {
                                    children.add(createNode(childFile));
                                }
                            }
                        }
                    }
                    return children;
                }
                return FXCollections.emptyObservableList();
            }
        };
    }

    static void setDirectory(File directory) {
        if (directory != null) {
            root = createNode(directory);
            root.setExpanded(true);
            Main.run = true;
        }
    }

    public void changeDirectory(ActionEvent ae) {
        DirectoryChooser directoryChooser = new DirectoryChooser();
        Stage secondaryStage = new Stage();
        File directory = directoryChooser.showDialog(secondaryStage);
        if (directory != null){
            root = createNode(directory);
            root.setExpanded(true);
            tv.setRoot(root);
        }
    }

    public void delete (ActionEvent ae){

    }

    public void addDirectory(ActionEvent ae){

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageView.setImage(new Image("defaultImage.jpg"));
        tv.setRoot(root);
        tv.getSelectionModel().selectedItemProperty()
                .addListener((v, oldValue, newValue) -> {
                    if (newValue.isLeaf()) {
                        imageView.setImage(new Image("file:" + newValue.getValue().toString()));
                    }
                });
    }
}
