package com.codebind;

import javax.swing.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VulgarDetector extends Thread {

    JTextArea window;
    volatile boolean terminate;

    public VulgarDetector(JTextArea comp) {
        window = comp;
        terminate = false;
    }

    public void run() {
        while (! terminate) {
            try {
                String text = window.getText();
                String patternString = ".*cholera.*";

                Pattern pattern = Pattern.compile(patternString);
                Matcher matcher = pattern.matcher(text);

                if (matcher.matches() == true)
                    JOptionPane.showMessageDialog(window, "Vulgar word identified");

                sleep(10000);
            } catch (Exception e) {}
        }
    }
}
