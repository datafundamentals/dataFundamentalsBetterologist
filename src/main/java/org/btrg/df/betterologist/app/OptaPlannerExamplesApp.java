/*
 * Copyright 2010 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.btrg.df.betterologist.app;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

import org.btrg.df.betterologist.common.app.CommonApp;
import org.btrg.df.betterologist.common.swingui.SolverAndPersistenceFrame;
import org.btrg.df.betterologist.common.swingui.TangoColorFactory;

public class OptaPlannerExamplesApp extends JFrame {

    public static void main(String[] args) {
        CommonApp.fixateLookAndFeel();
        OptaPlannerExamplesApp optaPlannerExamplesApp = new OptaPlannerExamplesApp();
        optaPlannerExamplesApp.pack();
        optaPlannerExamplesApp.setLocationRelativeTo(null);
        optaPlannerExamplesApp.setVisible(true);
    }

    private JTextArea descriptionTextArea;

    public OptaPlannerExamplesApp() {
        super("OptaPlanner examples");
        setIconImage(SolverAndPersistenceFrame.OPTA_PLANNER_ICON.getImage());
        setContentPane(createContentPane());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private Container createContentPane() {
        JPanel contentPane = new JPanel(new BorderLayout(10, 10));
        contentPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        JLabel titleLabel = new JLabel("Which example do you want to see?", JLabel.CENTER);
        titleLabel.setFont(titleLabel.getFont().deriveFont(20.0f));
        contentPane.add(titleLabel, BorderLayout.NORTH);
        JScrollPane examplesScrollPane = new JScrollPane(createExamplesPanel());
        examplesScrollPane.getHorizontalScrollBar().setUnitIncrement(20);
        examplesScrollPane.getVerticalScrollBar().setUnitIncrement(20);
        contentPane.add(examplesScrollPane, BorderLayout.CENTER);
        contentPane.add(createDescriptionPanel(), BorderLayout.SOUTH);
        return contentPane;
    }

    private JPanel createExamplesPanel() {
        JPanel examplesPanel = new JPanel();
        examplesPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        GroupLayout layout = new GroupLayout(examplesPanel);
        examplesPanel.setLayout(layout);
        JPanel realExamplesPanel = createRealExamplesPanel();
        layout.setHorizontalGroup(layout.createSequentialGroup()
                .addComponent(realExamplesPanel)
                .addGap(10));
        layout.setVerticalGroup(layout.createParallelGroup()
                .addComponent(realExamplesPanel));
        return examplesPanel;
    }


    private JPanel createRealExamplesPanel() {
        JPanel panel = new JPanel(new GridLayout(5, 1, 5, 5));
        TitledBorder titledBorder = BorderFactory.createTitledBorder("Examples");
        titledBorder.setTitleColor(TangoColorFactory.BUTTER_3);
        panel.setBorder(BorderFactory.createCompoundBorder(titledBorder,
                BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        panel.add(createExampleButton(new ProjectJobSchedulingApp()));
        return panel;
    }


    private JButton createExampleButton(final CommonApp commonApp) {
        String iconResource = commonApp.getIconResource();
        ImageIcon icon = iconResource == null ? null : new ImageIcon(getClass().getResource(iconResource));
        JButton button = new JButton(new AbstractAction(commonApp.getName(), icon) {
            public void actionPerformed(ActionEvent e) {
                commonApp.init(OptaPlannerExamplesApp.this, false);
            }
        });
        button.setHorizontalTextPosition(JButton.CENTER);
        button.setVerticalTextPosition(JButton.BOTTOM);
        button.addMouseListener(new MouseAdapter() {

            public void mouseEntered(MouseEvent e) {
                descriptionTextArea.setText(commonApp.getDescription());
            }

            public void mouseExited(MouseEvent e) {
                descriptionTextArea.setText("");
            }

        });
        return button;
    }

    private JButton createDisabledExampleButton(final CommonApp commonApp) {
        JButton exampleButton = createExampleButton(commonApp);
        exampleButton.setEnabled(false);
        return exampleButton;
    }

    private JPanel createDescriptionPanel() {
        JPanel descriptionPanel = new JPanel(new BorderLayout());
        descriptionPanel.add(new JLabel("Description"), BorderLayout.NORTH);
        descriptionTextArea = new JTextArea(8, 80);
        descriptionTextArea.setEditable(false);
        descriptionPanel.add(new JScrollPane(descriptionTextArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER), BorderLayout.CENTER);
        return descriptionPanel;
    }

}
