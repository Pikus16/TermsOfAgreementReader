/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package termsofagreementreader;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author benka
 */
public class TextInput extends javax.swing.JFrame {

    /**
     * Creates new form TextInput
     */
    public TextInput() {
        initComponents();
        this.getContentPane().setBackground(new Color(50,200,250));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        title = new javax.swing.JLabel();
        askForText = new javax.swing.JLabel();
        inputName = new javax.swing.JTextField();
        submitURL = new javax.swing.JButton();
        askForName = new javax.swing.JLabel();
        inputText = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        title.setFont(new java.awt.Font("Ubuntu", 3, 36)); // NOI18N
        title.setText("Welcome to the Terms of Conditions Scanner");

        askForText.setText("Please input the text of the conditions of the Terms and Services agreeements.");

        inputName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputNameActionPerformed(evt);
            }
        });

        submitURL.setText("Submit");
        submitURL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitURLActionPerformed(evt);
            }
        });

        askForName.setText("Please input the name of the company of these Terms and Services");

        inputText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputTextActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(355, 355, 355)
                .addComponent(submitURL, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(title, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(askForText, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, 537, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(askForName, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(askForText)
                .addGap(18, 18, 18)
                .addComponent(inputText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(askForName)
                .addGap(29, 29, 29)
                .addComponent(inputName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(submitURL, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputNameActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_inputNameActionPerformed

    private void submitURLActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitURLActionPerformed
        // TODO add your handling code here:
        String name = inputName.getText();
        String text = inputText.getText();
        findRedFlags(text,name);

    }//GEN-LAST:event_submitURLActionPerformed

    public void findRedFlags(String text, String name)
    {
         ArrayList<String> keywords = new ArrayList<String>();
        keywords.add("grant us");  
        keywords.add("give us"); 
        keywords.add("give " + name);
        keywords.add("grant " + name);
        keywords.add("allow us"); 
        keywords.add("allow " + name);
        keywords.add("credit card"); 
        keywords.add("social security");
        keywords.add("location"); 
        keywords.add("contact");
        keywords.add("information");
        keywords.add("pay");
        keywords.add("collect");
        keywords.add("intellectual property");
        ArrayList<String> redFlags = new ArrayList<String>();
        for (String b: keywords)
        {
            if (text.indexOf(b) != -1)
            {
                String current = b;
                int index = text.indexOf(b);
                int i = 1;
                while(true)
                {
                    int size = text.length();
                    int currentIndex = index - i;
                    String letter = text.substring(currentIndex, currentIndex+1);
                    if (letter.equals("."))
                            break;
                    current = letter + current;
                    i++;
                }
                i = 1;
                while(true)
                {
                    int currentIndex = index +b.length() + i;
                    String letter = text.substring(currentIndex, currentIndex+1);
                    if (letter.equals("."))
                            break;
                    current = current + letter;
                    i++;
                }
              try{
                    boolean matches =false;
                    for (String a: redFlags)
                    {
                        if (current.substring(0,10).equals(a.substring(0,10)))
                            matches = true;
                    }
                    if (!matches)
                        redFlags.add(current);
                }
                catch (Exception e){redFlags.add(current);}
            }
        }
        
         Keywords.keywordsHolder(redFlags);
          Results a = new Results();
        String[] empty = new String[5];
        a.main(empty);
        this.dispose();
    }
    
    private void inputTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inputTextActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextInput.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TextInput().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel askForName;
    private javax.swing.JLabel askForText;
    private javax.swing.JTextField inputName;
    private javax.swing.JTextField inputText;
    private javax.swing.JButton submitURL;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
