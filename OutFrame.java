package project;
import java.awt.*;
import javax.swing.*;

public class OutFrame extends javax.swing.JFrame {
    Image img=(new ImageIcon(System.getProperty("user.dir")+"\\src\\project\\Datapath.png")).getImage();
    public OutFrame() {
        initComponents();
    }
    @Override
    public void paint(Graphics g){
        super.paint(g);
        g.drawImage(img,10,40,null);
    }
    public void describe(){
        lblALUO.setText(Tool.toBString(ALUControl.getALUOrder()).substring(28,32));
        lblALUOp.setText(CU.getALUOp());
        lblALUR.setText(Integer.toString(ALU.getResult()));
        lblRD2.setText(Integer.toString(RF.getReaddata2()));
        lblConstant.setText(IM.getImmediate());
        lblSEO.setText(Tool.signExtend(lblConstant.getText()));
        lblALUS2.setText(CU.getALUSrc()? Integer.toString(Tool.toInt(lblSEO.getText())):lblRD2.getText());
        lblALUSrc.setText(CU.getALUSrc()? "1":"0");
        lblALUZ.setText(ALU.getZeroFlag()? "1":"0");
        lblBAI.setText(Integer.toString(Tool.toInt(lblSEO.getText())*4));
        lblBAO.setText(Integer.toString(MUXPC.getBPC()));
        lblBNE.setText(CU.getBNE()? "1":"0");
        lblBranch.setText(CU.getBranch()? "1":"0");
        lblDMR.setText(Integer.toString(DM.getReaddata()));
        lblFC.setText(IM.getFCode());
        lblJAI.setText(IM.getJAddress());
        lblJAI2.setText(Tool.toBString(MUXPC.getNPC()).substring(0,4));
        lblJAO.setText(Integer.toString(MUXPC.getJPC()));
        lblJR.setText(CU.getJR()? "1":"0");
        lblJump.setText(CU.getJump()? "1":"0");
        lblLink.setText(CU.getLink()? "1":"0");
        lblPCA.setText(Integer.toString(MUXPC.getNPC()));
        boolean x=((CU.getBranch()&&ALU.getZeroFlag())||(CU.getBNE()&&(!ALU.getZeroFlag())));
        lblMUXB.setText(x? lblBAO.getText():lblPCA.getText());
        lblMUXJ.setText(CU.getJump()? lblJAO.getText():lblMUXB.getText());
        lblMUXJR.setText(CU.getJR()? lblALUR.getText():lblMUXJ.getText());
        lblRR1.setText(IM.getRS());
        lblRR2.setText(IM.getRT());
        lblRD.setText(IM.getRD());
        lblMUXRTD.setText(CU.getRegDst()? lblRD.getText():lblRR2.getText());
        lblMUXWR.setText(CU.getLink()? "11111":lblMUXRTD.getText());
        lblMemRead.setText(CU.getMemRead());
        lblMemWrite.setText(CU.getMemWrite());
        lblMemtoReg.setText(CU.getMemtoReg()? "1":"0");
        lblOPC.setText(IM.getOPCode());
        lblOR.setText(x? "1":"0");
        lblRD1.setText(Integer.toString(RF.getReaddata1()));
        lblRD2.setText(Integer.toString(RF.getReaddata2()));
        lblRegDst.setText(CU.getRegDst()? "1":"0");
        lblRegWrite.setText(CU.getRegWrite()? "1":"0");
        lblSH.setText(IM.getShamt());
        lblMUXALUDM.setText(CU.getMemtoReg()? lblDMR.getText():lblALUR.getText());
        lblWD.setText(CU.getLink()? lblPCA.getText():lblMUXALUDM.getText());
        lblCI.setText(IM.getCIR());
        lblClock.setText(Integer.toString(Datapath.getClock()));
        txtRF1.setText(RF.toPrint1());
        txtRF2.setText(RF.toPrint2());
        txtRF3.setText(RF.toPrint3());
        txtRF4.setText(RF.toPrint4());
        txtDM.setText(DM.toPrint());
        txtIM.setText(IM.toPrint());
        lblCPC.setText(Integer.toString(MUXPC.getNPC()-4));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblOPC = new javax.swing.JLabel();
        lblRR1 = new javax.swing.JLabel();
        lblRR2 = new javax.swing.JLabel();
        lblRD = new javax.swing.JLabel();
        lblConstant = new javax.swing.JLabel();
        lblFC = new javax.swing.JLabel();
        lblSH = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblMUXRTD = new javax.swing.JLabel();
        lblMUXWR = new javax.swing.JLabel();
        lblRD1 = new javax.swing.JLabel();
        lblRD2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblALUS2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblSEO = new javax.swing.JLabel();
        lblALUR = new javax.swing.JLabel();
        lblDMR = new javax.swing.JLabel();
        lblMUXALUDM = new javax.swing.JLabel();
        lblWD = new javax.swing.JLabel();
        lblPCA = new javax.swing.JLabel();
        lblJAI = new javax.swing.JLabel();
        lblJAO = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblBAI = new javax.swing.JLabel();
        lblBAO = new javax.swing.JLabel();
        lblMUXB = new javax.swing.JLabel();
        lblMUXJ = new javax.swing.JLabel();
        lblMUXJR = new javax.swing.JLabel();
        lblBNE = new javax.swing.JLabel();
        lblJR = new javax.swing.JLabel();
        lblRegDst = new javax.swing.JLabel();
        lblJump = new javax.swing.JLabel();
        lblBranch = new javax.swing.JLabel();
        lblRegWrite = new javax.swing.JLabel();
        lblMemtoReg = new javax.swing.JLabel();
        lblMemRead = new javax.swing.JLabel();
        lblALUOp = new javax.swing.JLabel();
        lblMemWrite = new javax.swing.JLabel();
        lblALUSrc = new javax.swing.JLabel();
        lblLink = new javax.swing.JLabel();
        lblALUO = new javax.swing.JLabel();
        lblJAI2 = new javax.swing.JLabel();
        lblALUZ = new javax.swing.JLabel();
        lblOR = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblClock = new javax.swing.JLabel();
        lblCI = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtRF3 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtRF1 = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtRF4 = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtRF2 = new javax.swing.JTextArea();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDM = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        txtIM = new javax.swing.JTextArea();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        btnNext = new javax.swing.JButton();
        btnFinish = new javax.swing.JButton();
        lblCPC = new javax.swing.JLabel();

        setTitle("MIPS Simulator");
        setBounds(new java.awt.Rectangle(150, 50, 1200, 610));
        setName("OutFrame"); // NOI18N
        setPreferredSize(new java.awt.Dimension(1200, 610));
        setResizable(false);
        setSize(new java.awt.Dimension(1200, 610));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblOPC.setText("000000");
        getContentPane().add(lblOPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 225, -1, -1));

        lblRR1.setText("00000");
        getContentPane().add(lblRR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 280, -1, -1));

        lblRR2.setText("00000");
        getContentPane().add(lblRR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 320, -1, -1));

        lblRD.setText("00000");
        getContentPane().add(lblRD, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 370, -1, -1));

        lblConstant.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblConstant.setText("0000000000000000");
        getContentPane().add(lblConstant, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, -1));

        lblFC.setText("000000");
        getContentPane().add(lblFC, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 480, -1, -1));

        lblSH.setText("00000");
        getContentPane().add(lblSH, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 470, -1, -1));

        jLabel1.setText("MUX RT/RD output");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        jLabel2.setText("Write register address");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, -1, -1));

        lblMUXRTD.setText("00000");
        getContentPane().add(lblMUXRTD, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 480, -1, -1));

        lblMUXWR.setText("00000");
        getContentPane().add(lblMUXWR, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 500, -1, -1));

        lblRD1.setText("100");
        getContentPane().add(lblRD1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, -1, -1));

        lblRD2.setText("100");
        getContentPane().add(lblRD2, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, -1, -1));

        jLabel3.setText("ALU 2nd source");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, -1, -1));

        lblALUS2.setText("100");
        getContentPane().add(lblALUS2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 520, -1, -1));

        jLabel5.setText("Sign-extend output");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, -1, -1));

        lblSEO.setText("00000000000000000000000000000000");
        getContentPane().add(lblSEO, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 540, -1, -1));

        lblALUR.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblALUR.setText("100");
        getContentPane().add(lblALUR, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 350, -1, -1));

        lblDMR.setText("100");
        getContentPane().add(lblDMR, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 340, -1, -1));

        lblMUXALUDM.setText("100");
        getContentPane().add(lblMUXALUDM, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 450, -1, -1));

        lblWD.setText("100");
        getContentPane().add(lblWD, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 460, -1, -1));

        lblPCA.setText("100");
        getContentPane().add(lblPCA, new org.netbeans.lib.awtextra.AbsoluteConstraints(163, 142, -1, -1));

        lblJAI.setText("00000000000000000000000000");
        getContentPane().add(lblJAI, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, -1, -1));

        lblJAO.setText("100");
        getContentPane().add(lblJAO, new org.netbeans.lib.awtextra.AbsoluteConstraints(358, 61, -1, -1));

        jLabel6.setText("Branch adder 2nd source");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, -1, -1));

        lblBAI.setText("100");
        getContentPane().add(lblBAI, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, -1, -1));

        lblBAO.setText("100");
        getContentPane().add(lblBAO, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 140, -1, -1));

        lblMUXB.setText("100");
        getContentPane().add(lblMUXB, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 140, -1, -1));

        lblMUXJ.setText("100");
        getContentPane().add(lblMUXJ, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, -1, -1));

        lblMUXJR.setText("100");
        getContentPane().add(lblMUXJR, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 90, -1, -1));

        lblBNE.setForeground(new java.awt.Color(255, 153, 51));
        lblBNE.setText("0");
        getContentPane().add(lblBNE, new org.netbeans.lib.awtextra.AbsoluteConstraints(459, 152, -1, -1));

        lblJR.setForeground(new java.awt.Color(255, 153, 51));
        lblJR.setText("0");
        getContentPane().add(lblJR, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, -1, -1));

        lblRegDst.setForeground(new java.awt.Color(255, 153, 51));
        lblRegDst.setText("0");
        getContentPane().add(lblRegDst, new org.netbeans.lib.awtextra.AbsoluteConstraints(219, 170, -1, -1));

        lblJump.setForeground(new java.awt.Color(255, 153, 51));
        lblJump.setText("0");
        getContentPane().add(lblJump, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 180, -1, -1));

        lblBranch.setForeground(new java.awt.Color(255, 153, 51));
        lblBranch.setText("0");
        getContentPane().add(lblBranch, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 190, -1, -1));

        lblRegWrite.setForeground(new java.awt.Color(255, 153, 51));
        lblRegWrite.setText("0");
        getContentPane().add(lblRegWrite, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 280, -1, -1));

        lblMemtoReg.setForeground(new java.awt.Color(255, 153, 51));
        lblMemtoReg.setText("0");
        getContentPane().add(lblMemtoReg, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, -1, -1));

        lblMemRead.setForeground(new java.awt.Color(255, 153, 51));
        lblMemRead.setText("000");
        getContentPane().add(lblMemRead, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 210, -1, -1));

        lblALUOp.setForeground(new java.awt.Color(255, 153, 51));
        lblALUOp.setText("000");
        getContentPane().add(lblALUOp, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));

        lblMemWrite.setForeground(new java.awt.Color(255, 153, 51));
        lblMemWrite.setText("00");
        getContentPane().add(lblMemWrite, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 250, -1, -1));

        lblALUSrc.setForeground(new java.awt.Color(255, 153, 51));
        lblALUSrc.setText("0");
        getContentPane().add(lblALUSrc, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 260, -1, -1));

        lblLink.setForeground(new java.awt.Color(255, 153, 51));
        lblLink.setText("0");
        getContentPane().add(lblLink, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 290, -1, -1));

        lblALUO.setForeground(new java.awt.Color(255, 153, 51));
        lblALUO.setText("0000");
        getContentPane().add(lblALUO, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 420, -1, -1));

        lblJAI2.setText("0000");
        getContentPane().add(lblJAI2, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 130, -1, -1));

        lblALUZ.setForeground(new java.awt.Color(255, 153, 51));
        lblALUZ.setText("0");
        getContentPane().add(lblALUZ, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, -1, -1));

        lblOR.setForeground(new java.awt.Color(255, 153, 51));
        lblOR.setText("0");
        getContentPane().add(lblOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 160, -1, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel7.setText("Instruction");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        jLabel8.setText("Clock cycles spanned");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, -1, -1));

        lblClock.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblClock.setText("10");
        getContentPane().add(lblClock, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, -1, -1));

        lblCI.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
        lblCI.setText("00000000000000000000000000000000");
        getContentPane().add(lblCI, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 10, -1, -1));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Register File"));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtRF3.setEditable(false);
        txtRF3.setBackground(new java.awt.Color(240, 240, 240));
        txtRF3.setColumns(1);
        txtRF3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtRF3.setRows(1);
        jScrollPane1.setViewportView(txtRF3);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, 60, 250));

        txtRF1.setEditable(false);
        txtRF1.setBackground(new java.awt.Color(240, 240, 240));
        txtRF1.setColumns(1);
        txtRF1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtRF1.setRows(1);
        jScrollPane2.setViewportView(txtRF1);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 70, 250));

        txtRF4.setEditable(false);
        txtRF4.setBackground(new java.awt.Color(240, 240, 240));
        txtRF4.setColumns(1);
        txtRF4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtRF4.setRows(1);
        jScrollPane3.setViewportView(txtRF4);

        jPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, 60, 250));

        txtRF2.setEditable(false);
        txtRF2.setBackground(new java.awt.Color(240, 240, 240));
        txtRF2.setColumns(1);
        txtRF2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtRF2.setRows(1);
        jScrollPane4.setViewportView(txtRF2);

        jPanel2.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, 70, 250));

        txtDM.setEditable(false);
        txtDM.setBackground(new java.awt.Color(240, 240, 240));
        txtDM.setColumns(1);
        txtDM.setFont(new java.awt.Font("Arial", 0, 13)); // NOI18N
        txtDM.setRows(1);
        jScrollPane5.setViewportView(txtDM);

        jLabel4.setText("Address");

        jLabel9.setText("Value");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel9))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Data Memory", jPanel3);

        txtIM.setEditable(false);
        txtIM.setBackground(new java.awt.Color(240, 240, 240));
        txtIM.setColumns(1);
        txtIM.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txtIM.setRows(1);
        jScrollPane6.setViewportView(txtIM);

        jLabel10.setText("Address");

        jLabel11.setText("Instruction");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel11)
                        .addGap(0, 146, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel11))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        jTabbedPane1.addTab("Instruction Memory", jPanel4);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 10, 300, 580));

        btnNext.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/Next.png"))); // NOI18N
        btnNext.setToolTipText("Next Instruction");
        btnNext.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextActionPerformed(evt);
            }
        });
        getContentPane().add(btnNext, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 10, -1, -1));

        btnFinish.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project/Finish.png"))); // NOI18N
        btnFinish.setToolTipText("Finish Execution");
        btnFinish.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinishActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinish, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 10, -1, -1));

        lblCPC.setText("100");
        getContentPane().add(lblCPC, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextActionPerformed
        Datapath.run();
        this.describe();
        this.repaint();
        if(IM.IS[(PC.getPC()-IM.start)/4]==null){
            this.btnNext.setEnabled(false);
            this.btnFinish.setEnabled(false);
        }
    }//GEN-LAST:event_btnNextActionPerformed

    private void btnFinishActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinishActionPerformed
        this.btnNext.setEnabled(false);
        this.btnFinish.setEnabled(false);
        while(IM.IS[(PC.getPC()-IM.start)/4]!=null)
            Datapath.run();
        this.describe();
        this.repaint();
    }//GEN-LAST:event_btnFinishActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnFinish;
    public javax.swing.JButton btnNext;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lblALUO;
    private javax.swing.JLabel lblALUOp;
    private javax.swing.JLabel lblALUR;
    private javax.swing.JLabel lblALUS2;
    private javax.swing.JLabel lblALUSrc;
    private javax.swing.JLabel lblALUZ;
    private javax.swing.JLabel lblBAI;
    private javax.swing.JLabel lblBAO;
    private javax.swing.JLabel lblBNE;
    private javax.swing.JLabel lblBranch;
    private javax.swing.JLabel lblCI;
    private javax.swing.JLabel lblCPC;
    private javax.swing.JLabel lblClock;
    private javax.swing.JLabel lblConstant;
    private javax.swing.JLabel lblDMR;
    private javax.swing.JLabel lblFC;
    private javax.swing.JLabel lblJAI;
    private javax.swing.JLabel lblJAI2;
    private javax.swing.JLabel lblJAO;
    private javax.swing.JLabel lblJR;
    private javax.swing.JLabel lblJump;
    private javax.swing.JLabel lblLink;
    private javax.swing.JLabel lblMUXALUDM;
    private javax.swing.JLabel lblMUXB;
    private javax.swing.JLabel lblMUXJ;
    private javax.swing.JLabel lblMUXJR;
    private javax.swing.JLabel lblMUXRTD;
    private javax.swing.JLabel lblMUXWR;
    private javax.swing.JLabel lblMemRead;
    private javax.swing.JLabel lblMemWrite;
    private javax.swing.JLabel lblMemtoReg;
    private javax.swing.JLabel lblOPC;
    private javax.swing.JLabel lblOR;
    private javax.swing.JLabel lblPCA;
    private javax.swing.JLabel lblRD;
    private javax.swing.JLabel lblRD1;
    private javax.swing.JLabel lblRD2;
    private javax.swing.JLabel lblRR1;
    private javax.swing.JLabel lblRR2;
    private javax.swing.JLabel lblRegDst;
    private javax.swing.JLabel lblRegWrite;
    private javax.swing.JLabel lblSEO;
    private javax.swing.JLabel lblSH;
    private javax.swing.JLabel lblWD;
    private javax.swing.JTextArea txtDM;
    private javax.swing.JTextArea txtIM;
    private javax.swing.JTextArea txtRF1;
    private javax.swing.JTextArea txtRF2;
    private javax.swing.JTextArea txtRF3;
    private javax.swing.JTextArea txtRF4;
    // End of variables declaration//GEN-END:variables
}
