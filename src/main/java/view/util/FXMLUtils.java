package view.util;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import org.apache.commons.lang3.NotImplementedException;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

public class FXMLUtils {

    public static Node getChildWithId(Pane root, String id) {
        ObservableList<Node> children = root.getChildren();
        for (Node child: children) {
            if (child.getId() != null && child.getId().equals(id)) {
                return child;
            } else if (child instanceof Pane) {
                Node recursiveResult = getChildWithId((Pane) child, id);
                if (recursiveResult != null) {
                    return recursiveResult;
                }
            }
        }
        return null;
    }

    public static List<Node> getChildrenWithId(Node root, String id) {
        // TODO
        throw new NotImplementedException("Not implemented");
    }

    public static List<Node> applyStyleClassToAll(List<Node> nodes, String styleClass) {
        // TODO
        throw new NotImplementedException("Not implemented");
    }

    /**
     * Adds css styling and css styleClasses to an FXML node
     * @param css string css to add to given node
     * @param styleClass style classes to add to given node
     * @param node node to add style to
     * @param clearOldStyles if true, previous css styling/styleClasses will be cleared
     */
    public static void addStyling(String css, List<String> styleClass, Node node, boolean clearOldStyles) {
        if (clearOldStyles) {
            node.getStyleClass().clear();
            node.setStyle("");
        }
        if (css != null && css.length() > 0) {
            String oldStyle = node.getStyle();
            if (oldStyle.length() > 0) {
                String lastChar = oldStyle.substring(oldStyle.length()-1);
                oldStyle = lastChar.equals(";") ? oldStyle : oldStyle + ";";
                String combinedCss = oldStyle.concat(css);
                node.setStyle(combinedCss);
            }
            node.setStyle(css);
        }
        if (styleClass != null && styleClass.size() > 0) {
            node.getStyleClass().addAll(styleClass);
        }
    }

    public FXMLLoader fxmlLoaderFromFile(String path) throws MalformedURLException, URISyntaxException {
        System.out.println(path);
        URL url = getClass().getClassLoader().getResource(path);
        System.out.println(url.toString());
        return new FXMLLoader(url);
    }
}
