package goldFrames;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Miha on 24.02.2017.
 */
public abstract class ConfirmCloseFrame extends BaseChildFrame {
    protected abstract boolean acceptCloseAction();

    @Override
    protected void setCloseOperation() {
        super.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                if (acceptCloseAction()) {
                    closeFrame();
                }
            }
        });
    }
}
