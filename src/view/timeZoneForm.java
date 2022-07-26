package view;

import timeZones.GetTimeZones;
import timeZones.IGetTimeZones;
import timeZones.Pair;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class timeZoneForm {
    private JTextField myData;
    private JComboBox myTimeZones;
    private JTextField ansData;
    private JButton countButton;
    private JPanel mainPanel;

    private IGetTimeZones timeZones;

    private static timeZoneForm form;

    public timeZoneForm(){
        countButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String myDate = myData.getText();
                    Pair toTimeZone = (Pair)myTimeZones.getSelectedItem();
                    String result = timeZones.convertDate(myDate, (String)toTimeZone.getName());
                    if(result == null)
                        throw new Exception();
                    ansData.setText(result);
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null, "Zły format daty!");
                }
            }
        });
    }

    public static void init(timeZoneForm frm){
        frm.timeZones = new GetTimeZones();
        frm.timeZones.readZonesFromFile();
    }

    public static void initForm(timeZoneForm frm){
        int i = 0;
        Vector<Pair<String,String>> zonesVector = frm.timeZones.getTimeZones();
        for(i = 0; i < zonesVector.size(); ++i){
            frm.myTimeZones.addItem(zonesVector.get(i));
        }
    }

    public static void main(String args[]){
        JFrame mainFrame = new JFrame("Konwerter stref czasowych");
        form = new timeZoneForm();
        mainFrame.setContentPane(form.mainPanel);
        init(form);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.pack();
        mainFrame.setVisible(true);
        initForm(form);
    }
}
