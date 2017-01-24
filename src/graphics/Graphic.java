package graphics;

import leastsquare.LeastSquare;
import sample.CosSample;
import sample.PolynomSample;
import sample.Sample;
import function.CosFunction;
import function.Function;
import function.PolynomFunction;
import function.SinFunction;
import sample.SinSample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class Graphic extends JDialog {
    private JPanel contentPane;
//    private JButton buttonOK;
//    private JButton buttonCancel;
    private JButton SinButton;
    private JButton CosButton;
    private JButton PolynomButton;
    private JCheckBox normalDistortionCheckBox;
    private JComboBox numOfElemComboBox;
    private JFrame currentDaughterFrame;
    private ArrayList<JFrame> daughterFrames;
    private DrawPanel daughterPanel;


    public Graphic() {
        daughterFrames = new ArrayList<>();
        setContentPane(contentPane);
        //setModal(true);
//        getRootPane().setDefaultButton(buttonOK);
//        buttonOK.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onOK();
//            }
//        });

//        buttonCancel.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                onCancel();
//            }
//        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);


        SinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Function sinFunc = new SinFunction();
                Sample sinSample = new SinSample();
                sinFunc.createFunction();
                sinSample.createSample(10*(numOfElemComboBox.getSelectedIndex()+1), 0.3, normalDistortionCheckBox.isSelected());
                LeastSquare sinLs = new LeastSquare(sinSample);
                createDaughterFrame(sinFunc, sinSample, sinLs.getLeastSquareCreatedFunction());
            }
        });
        CosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Function cosFunc = new CosFunction();
                Sample cosSample = new CosSample();
                cosFunc.createFunction();
                cosSample.createSample(10*(numOfElemComboBox.getSelectedIndex()+1), 0.3, normalDistortionCheckBox.isSelected());
                LeastSquare cosLs = new LeastSquare(cosSample);
                createDaughterFrame(cosFunc, cosSample, cosLs.getLeastSquareCreatedFunction());
            }
        });
        PolynomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Function polynomFunc = new PolynomFunction();
                Sample polynomSample = new PolynomSample();
                polynomFunc.createFunction();
                polynomSample.createSample(10*(numOfElemComboBox.getSelectedIndex()+1), 0.3, normalDistortionCheckBox.isSelected());
                LeastSquare polynomLs = new LeastSquare(polynomSample);
                createDaughterFrame(polynomFunc, polynomSample, polynomLs.getLeastSquareCreatedFunction());
            }
        });
    }



    private void createDaughterFrame(Function func, Sample sample, Function newFunc) {
        currentDaughterFrame = new JFrame();
        currentDaughterFrame.setSize(new Dimension(600,400));
        daughterPanel = new DrawPanel();
        daughterPanel.setFunction(func, sample, newFunc);
        currentDaughterFrame.add(daughterPanel);
        currentDaughterFrame.setVisible(true);
        currentDaughterFrame.setFocusable(true);
        currentDaughterFrame.setAutoRequestFocus(true);
        daughterFrames.add(currentDaughterFrame);
    }


    private void onOK() {
        // add your code here
//        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        for(JFrame frame: daughterFrames)
            frame.dispose();
        dispose();
    }

}
