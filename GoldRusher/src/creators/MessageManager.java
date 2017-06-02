package creators;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Miha on 22.02.2017.
 */
public class MessageManager {
    public static void showInformMessages(Component component, String s) {
        JOptionPane.showMessageDialog(component, s, "Message Dialog", JOptionPane.PLAIN_MESSAGE);
    }

    public static int showYesNoMessage(Component comp, String message) {
        return JOptionPane.showConfirmDialog(comp, message, "Confirm", JOptionPane.YES_NO_OPTION);
    }

    public static int showYesNoCancelMessage(Component comp, String message) {
        return JOptionPane.showConfirmDialog(comp, message, "Confirm", JOptionPane.YES_NO_CANCEL_OPTION);
    }

    public static void showErrorMessage(Component comp, String message) {
        JOptionPane.showMessageDialog(comp, message, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
