/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package goldFrames;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Miha on 17.02.2017.
 */
public abstract class BaseChildFrame extends JFrame{
   

    public BaseChildFrame() {
        setCloseOperation();
    }
    
    private JFrame parentFrame;
    
    public JFrame getParentFrame() {
        return parentFrame;
    }

    public void showFrame(JFrame parent) {
        this.parentFrame = parent;
        parent.setVisible(false);
        super.setVisible(true);
    }

    public void closeFrame() {
        if (parentFrame == null) throw new IllegalArgumentException("Parent frame must not be null");
        super.setVisible(false);
        parentFrame.setVisible(true);
    }

    protected void setCloseOperation() {
        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                closeFrame();
            }
        });

    }
}
