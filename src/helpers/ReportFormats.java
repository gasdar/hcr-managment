package helpers;

import javax.swing.*;

public class ReportFormats {

    public static int getIntUpperThanZero(String m) {
        int num;
        try {
            do {
                num = Integer.parseInt(JOptionPane.showInputDialog(null, m));
                if(num <= 0) {
                    JOptionPane.showMessageDialog(null,
                            "Debe ingresar un número mayor a 0",
                            "INGRESAR NÚMERO MAYOR",
                            JOptionPane.WARNING_MESSAGE);
                }
            } while (num <= 0);
            return num;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "Debe ingresar un número entero",
                    "ERROR FORMATO",
                    JOptionPane.ERROR_MESSAGE);
            return getIntUpperThanZero(m);
        }
    }

    public static int roundedFormat(float num) {
        // redondeamos el decimal y volvemos el puntero
        float decimalValue = roundedFormatHelper(num * 10) / 10;
        // redondeamos el último número
        return (int) roundedFormatHelper(decimalValue);
    }

    public static int roundedDecimalFormat(float num) {
        return (int) (roundedFormatHelper(num * 10) / 10);
    }

    private static float roundedFormatHelper(float num) {
        String sNum = Float.toString(num); // 2434.0 => a String
        sNum = sNum.substring(0, sNum.indexOf('.')); // "2434.0" => "2434"
        int finalNum = Integer.parseInt(sNum.substring(sNum.length()-1)); // "2434" => 4
        if(finalNum == 0) {
            return num;
        }
        return (finalNum >= 5) ? num + ((finalNum - 10) * -1) : num - finalNum;
    }

    public static String reportNumberFormat(int num) {
        int counter=0;
        String sNum = Integer.toString(num);
        StringBuilder sb = new StringBuilder();
        for(int i=sNum.length()-1; i>=0; i--) {
            counter++;
            if(counter%3 == 0 && i-1 >= 0) {
                sb.append(sNum.charAt(i)).append(".");
            } else {
                sb.append(sNum.charAt(i));
            }
        }
        // Número con formato al revés y reseteamos el String Builder
        sNum = sb.toString();
        sb.delete(0, sb.toString().length());
        for(int i=sNum.length()-1; i>=0; i--) {
            sb.append(sNum.charAt(i));
        }
        return sb.toString();
    }

    public static void reportAbout(String name) {
        JOptionPane.showMessageDialog(null,
                "Ingrese los datos solicitados para obtener\nel informe de " + name.toLowerCase(),
                "INFORME DE CUENTA DE " + name.toUpperCase(),
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void informationMessage(String t, String m, int option) {
        switch (option) {
            case 0 -> JOptionPane.showMessageDialog(null, m, t, JOptionPane.ERROR_MESSAGE);
            case 1 -> JOptionPane.showMessageDialog(null, m, t, JOptionPane.INFORMATION_MESSAGE);
            case 2 -> JOptionPane.showMessageDialog(null, m, t, JOptionPane.WARNING_MESSAGE);
            default -> JOptionPane.showMessageDialog(null, m, t, JOptionPane.PLAIN_MESSAGE);
        }
    }

}
