package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Main extends JFrame{
    private JTable input;
    private JTextArea output;
    private JCheckBox fileInput;
    private JCheckBox fileOutput;
    private JTextField iFile;
    private JTextField oFile;
    private JButton start1;
    private JPanel panel;
    private JCheckBox tableToFile;
    private JTextField tablePath;
    private JLabel toFole;
    private JLabel sum;
    private JButton start2;
    private JTextField sumField;

    public Main()
    {
        setTitle("Lr 4");
        setContentPane(panel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(512, 512);
        setVisible(true);
        DefaultTableModel model = new DefaultTableModel();
        for(int i = 0; i < 10; i++)
        {
            model.addColumn(" ");
        }

        model.addRow(new Object[] {"", "", "", "", "", "", "", "", "", ""});

        input.setModel(model);
        input.setVisible(true);
        input.setGridColor(Color.BLUE);

        start1.addActionListener(new t5Listener());
        start2.addActionListener(new t5t2Listener());
    }

    public static void main(String[] args)
    {
        Main app = new Main();
        app.setVisible(true);
    }

    private void createUIComponents() {
    }

    public static void arrToTable(List<Integer> Arr, JTable input)
    {
        for(int i = 0; i < Arr.size() && i < input.getModel().getColumnCount(); i++)
        {
            input.getModel().setValueAt(Arr.get(i), 0, i);
        }
    }

    public static void arrToArea(List<List<Integer>> arr, JTextArea output)
    {
            for(int i = 0; i < arr.size(); i++)
            {
                String res = "";
                for(int j = 0; j < arr.get(i).size(); j++)
                {
                    res += arr.get(i).get(j) + " ";
                }
                output.append(res + "\n");
            }
    }

    public static void arrToArea2(List<Integer> arr, JTextArea output)
    {
            String res = "";
            for(int j = 0; j < arr.size(); j++)
            {
                res += arr.get(j) + " ";
            }
            output.append(res + "\n");
    }

    public static ArrayList<Integer> getArr(JTable input)
    {
            ArrayList<Integer> arr = new ArrayList<>();
            for(int j = 0; j < input.getModel().getColumnCount(); j++)
            {
                Object value = input.getModel().getValueAt(0, j);

                if(value.toString() != "")
                {
                    try {
                        arr.add(Integer.parseInt(value.toString()));
                        }
                    catch (NumberFormatException e)
                        {
                        }
                }
            }
            return arr;

    }

    class t5Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            List<List<Integer>> res = new ArrayList<>();

            output.setText("");
            if(fileInput.isSelected())
            {
                List<Integer> arr = IOController.readArr(iFile.getText());
                arrToTable(arr, input);
                int sum = Integer.parseInt(sumField.getText());
                res = Task1.selectionCount(arr, sum);  //
            }
            else
            {
                List<Integer> arr = getArr(input);
                int sum = Integer.parseInt(sumField.getText());
                res = Task1.selectionCount(arr, sum);
                if(tableToFile.isSelected())
                {
                    IOController.writeArr2(arr, tablePath.getText());
                    output.append("Данные из таблицы записаны в файл " + tablePath.getText() + "\n");
                }
            }
            if(!fileOutput.isSelected())
            {
                arrToArea(res, output);
            }
            else
            {
                IOController.writeArr(res, oFile.getText());
                output.setText("Результат записан в файл " + oFile.getText());
            }
        }

    }
    class t5t2Listener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent actionEvent)
        {
            List<Integer> res;
            output.setText("");
            if(fileInput.isSelected())
            {
                List<Integer> arr = IOController.readArr(iFile.getText());
                arrToTable(arr, input);
                res = Task2.process(arr);
            }
            else
            {
                List<Integer> Arr = getArr(input);
                res = Task2.process(Arr);
                if(tableToFile.isSelected())
                {
                    IOController.writeArr2(Arr, tablePath.getText());
                    output.append("Данные из таблицы записаны в файл " + tablePath.getText() + "\n");
                }
            }
            if(!fileOutput.isSelected())
            {
                arrToArea2(res, output);
            }
            else
            {
                IOController.writeArr2(res, oFile.getText());
                output.setText("Результат записан в файл " + oFile.getText());
            }
        }
        }
    }
