package bsu.rfe.java.group8.lab3.Potapnev.var12B;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class GornerTableCellRenderer implements TableCellRenderer {
    private JPanel panel = new JPanel();
    private JLabel label = new JLabel();

    private String needle = null;
    private DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance();

    public GornerTableCellRenderer() {

        formatter.setMaximumFractionDigits(5);

        formatter.setGroupingUsed(false);

        DecimalFormatSymbols dottedDouble = formatter.getDecimalFormatSymbols();
        dottedDouble.setDecimalSeparator('.');
        formatter.setDecimalFormatSymbols(dottedDouble);

        panel.add(label);

        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        String formattedDouble = formatter.format(value);
        label.setText(formattedDouble);
        int index = formattedDouble.length() - formattedDouble.indexOf(".") - 1;
        int indexDot = formattedDouble.indexOf(".");
        int count = 0;

        if (indexDot != -1) {
            for (int i = indexDot + 1; i < formattedDouble.length(); i++) {
                char letter = formattedDouble.charAt(i);
                if (letter == '1') {
                    count += 1;
                }
                if (letter == '3') {
                    count += 1;
                }
                if (letter == '5') {
                    count += 1;
                }
            }
        }

        if (count == formattedDouble.length() - formattedDouble.indexOf(".") - 1)
        {
            if (col==1 && needle!=null && needle.equals(formattedDouble))
                panel.setBackground(Color.RED);
            else panel.setBackground(Color.YELLOW);
        }
        else
        {
            if (col==1 && needle!=null && needle.equals(formattedDouble))
                panel.setBackground(Color.RED);
            else panel.setBackground(Color.WHITE);
        }

        return panel;
    }

    public void setNeedle(String needle) {
        this.needle = needle;
    }
}

