/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Durga
 */
import java.sql.*;
import java.util.Random;
public class regenerate1 extends javax.swing.JInternalFrame {

    /**
     * Creates new form regenerate1
     */
    public regenerate1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        SAVE = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        op = new javax.swing.JOptionPane();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Regenerate");

        jButton1.setText("REGENERATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        SAVE.setText("SAVE");
        SAVE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SAVEActionPerformed(evt);
            }
        });

        jEditorPane1.setInheritsPopupMenu(true);
        jEditorPane1.setPreferredSize(new java.awt.Dimension(150, 150));
        jScrollPane1.setViewportView(jEditorPane1);

        jButton2.setText("CLOSE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(260, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SAVE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addComponent(op, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 766, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(496, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(SAVE)
                    .addComponent(jButton2))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(op, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGap(45, 45, 45)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
        String [] fac=new String[50];
        String [] sub=new String[50];
        String [] sem=new String[50];
        String [] Type=new String[50];

        int [] lec=new int[50];
        int [] lab=new int[50];
        int [] tut=new int[50];

        String [][] CSE3=new String[50][50];
        String [][] CSE5=new String[50][50];
        String [][] CSE7=new String[50][50];

        String [][] CSEf3=new String[50][50];
        String [][] CSEf5=new String[50][50];
        String [][] CSEf7=new String[50][50];
    
    
       int line=0;
        int line1=0;
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
       jScrollPane1.setHorizontalScrollBar(jScrollPane1.createHorizontalScrollBar());
        //slot details
        
        call();
        

    }//GEN-LAST:event_jButton1ActionPerformed

    
    
    
     void call()
    {
        
        
        String [] start=new String[15];
        String [] end=new  String[15];
         int slotno=0;

        for(int i=0;i<50;i++)
        {
            for(int j=0;j<50;j++)
            {
                CSE3[i][j]="s";
                CSE5[i][j]="s";
                CSE7[i][j]="s";
                CSEf3[i][j]="s";
                CSEf5[i][j]="s";
                CSEf7[i][j]="s";
            }
        }

        int count=0,lp1;

        try
        {
            Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
            Connection con=DriverManager.getConnection("jdbc:odbc:College");
            Statement stm=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            Statement stm1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            ResultSet rs=stm.executeQuery("Select * from Subject_FacultyAllotment");
            ResultSet rs1=stm1.executeQuery("Select * from Slot_Details");

            
           
           while(rs1.next())
           {
              start[slotno]=rs1.getString("START");
              end[slotno]=rs1.getString("END");
              slotno++;
           }
            
            
            while(rs.next())
            {
                fac[count]=rs.getString("FACULTY").trim();
                sub[count]=rs.getString("SUBJECT").trim();
                sem[count]=rs.getString("SEM").trim();
                Type[count]=rs.getString("TYPE").trim();
                lec[count]=rs.getInt("L");
                tut[count]=rs.getInt("T");
                lab[count]=rs.getInt("P");
                count++;
            }

            int check;
            int checklab;
           
            //   System.out.println("Total="+count);
            for(int lp=0;lp<count;lp++)
            {
                if(sem[lp].equals("CSE3"))/////////////////////////////////////
                {
                    if(Type[lp].trim().equals("Laboratory"))
                    {
                        lab1(lab,lp,sub,fac,CSEf3,CSEf5,CSEf7,CSE3);  
                    }
                    else{

                            theory1(lec,lp,sub,fac,CSEf3,CSEf5,CSEf7,CSE3,5);
                        }
                    if(tut[lp]>0)
                        theory1(tut,lp,sub,fac,CSEf3,CSEf5,CSEf7,CSE3,8);  
                    }//////////////////////////////////////////////////
                
                    else if(sem[lp].equals("CSE5"))///////////////////////////////////////////////
                    {
                        if(Type[lp].trim().equals("Laboratory"))
                        {
                            lab1(lab,lp,sub,fac,CSEf5,CSEf3,CSEf7,CSE5);//////lab
                        }
                        else{

                            theory1(lec,lp,sub,fac,CSEf5,CSEf3,CSEf7,CSE5,5);//////lec
                           }
                        if(tut[lp]>0)///////////tut
                        {
                            theory1(tut,lp,sub,fac,CSEf5,CSEf3,CSEf7,CSE5,8);  
                        }
                      } //////////////////////////////////////////////
                    
                 else if(sem[lp].equals("CSE7"))
                       {
               
                         if(Type[lp].trim().equals("Laboratory")) //lab 
                        {
                          lab1(lab,lp,sub,fac,CSEf7,CSEf5,CSEf3,CSE7);
                       }
                         else{
                              theory1(lec,lp,sub,fac,CSEf7,CSEf5,CSEf3,CSE7,5);
                            }
                         if(tut[lp]>0)
                        theory1(tut,lp,sub,fac,CSEf7,CSEf5,CSEf3,CSE7,8); 
                    }
                }

            
            
            
            
          ///////////////////////////////////////////////////////////////////
            //////////DISPLAY IN TEXTEDITOR????????????????????
            ////////////////////////////////////////////
            display( slotno,start,end,CSE3,CSEf3,CSE5,CSEf5,CSE7,CSEf7);

            }
            catch(Exception ex)
            {
                System.out.println(ex);
            }

      }
    
    
    
    
    
    private void SAVEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SAVEActionPerformed
         try///////////////////////////////////////for Insert Generated data into
         { /////////////////////////////////////////table
              String [] day={"Mon","Tue","Wed","Thr","Fri","Sat"};
              String [] br={"CSE3","CSE5","CSE7"};
              int l1=day.length;
              int l2=br.length;
              Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection con=DriverManager.getConnection("jdbc:odbc:College");
                 Statement stm1=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                 Statement stm2=con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
                  ResultSet rs1=stm1.executeQuery("Select count(SLOT_NO) from Slot_Details");
        
             rs1.next();
            int a=rs1.getInt(1);
          
          if(line==0 && line1==0)
          {
           for(int i=0;i<l1;i++)
           {
              for(int  j=0;j<l2;j++)
              {
                  for(int k=0;k<a;k++)
                  {
                      int l=k+1;
                      
                      if(j==0)
                   stm2.executeUpdate("Update format set slot"+l+"='"+CSE3[i][k]+" ["+CSEf3[i][k].trim()+"]' where Day='"+day[i]+"' and Branch='"+br[j]+"'");
                      else if(j==1)
                   stm2.executeUpdate("Update format set slot"+l+"='"+CSE5[i][k]+" ["+CSEf5[i][k].trim()+"]' where Day='"+day[i]+"' and Branch='"+br[j]+"'");
                      else if(j==2)
                   stm2.executeUpdate("Update format set slot"+l+"='"+CSE7[i][k]+" ["+CSEf7[i][k].trim()+"]' where Day='"+day[i]+"' and Branch='"+br[j]+"'");
                  }
                
              }
             }
          op.showMessageDialog(this,"Successfully Saved");
          }   
      }
        catch(Exception e)
        {
          System.out.println(e);
        }
    }//GEN-LAST:event_SAVEActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    
   
              String [] day={"Mon","Tue","Wed","Thr","Fri","Sat"};
              String [] br={"CSE3","CSE5","CSE7"};
    
   
    void display( int slotno,String start[],String end[],String CSE3[][],String CSEf3[][],String CSE5[][],String CSEf5[][],String CSE7[][],String CSEf7[][])
    {
            jEditorPane1.setText("");
             
             jEditorPane1.setText(jEditorPane1.getText()+"_____________________________________________________________________________________________________________________________________________________________________________________________\n");
             jEditorPane1.setText(jEditorPane1.getText()+"\t\t");
             for(int i=0;i<slotno;i++)
            {
                if(i>=4)
                {
                jEditorPane1.setText(jEditorPane1.getText()+"Period"+(i+1)+"\t");   
                }else
                jEditorPane1.setText(jEditorPane1.getText()+"Period"+(i+1)+"\t\t");
                //System.out.println(slotno);
            }
            jEditorPane1.setText(jEditorPane1.getText()+"\n");
             jEditorPane1.setText(jEditorPane1.getText()+"DAY\tBRANCH\t");
            for(int i=0;i<slotno;i++)
            {
                if(i>=4)
                {
                 jEditorPane1.setText(jEditorPane1.getText()+"["+start[i].trim()+"-"+end[i].trim()+"]\t");
                }else
                jEditorPane1.setText(jEditorPane1.getText()+"["+start[i].trim()+"-"+end[i].trim()+"]\t\t");
            }
             jEditorPane1.setText(jEditorPane1.getText()+"\n_____________________________________________________________________________________________________________________________________________________________________________________________");
          
            
            ///////dislpay subject and faculty in ediotr pane
         //   jEditorPane1.setText(jEditorPane1.getText()+"\n");
              for(int i=0;i<6;i++)
                {
                     jEditorPane1.setText(jEditorPane1.getText()+"\n\n");
                  //jEditorPane1.setText(jEditorPane1.getText()+"\t\t");
                    jEditorPane1.setText(jEditorPane1.getText()+day[i]+"\t"+br[0]+"\t");
                    for(int j=0;j<slotno;j++)////////////////////////////////CSE3
                    {
                        if(j>=4)
                         {
                            jEditorPane1.setText(jEditorPane1.getText()+CSE3[i][j]+"\t");   
                         }else
                        jEditorPane1.setText(jEditorPane1.getText()+CSE3[i][j]+"\t\t");
                    }
                    jEditorPane1.setText(jEditorPane1.getText()+"\n");
                    jEditorPane1.setText(jEditorPane1.getText()+"\t\t");
                    for(int j=0;j<slotno;j++)
                    {
                        if(j>=4)
                         {
                            jEditorPane1.setText(jEditorPane1.getText()+CSEf3[i][j]+"\t");   
                         }else
                        jEditorPane1.setText(jEditorPane1.getText()+"["+CSEf3[i][j].trim()+"]\t\t");
                    }
                    jEditorPane1.setText(jEditorPane1.getText()+"\n\n");/////////////////////
                    
                    
                    
                    
                   // jEditorPane1.setText(jEditorPane1.getText()+"\t\t");
                   
                    
                    jEditorPane1.setText(jEditorPane1.getText()+day[i]+"\t"+br[1]+"\t");
                    for(int j=0;j<slotno;j++)/////////////////////////////////////CSE5
                    {
                        if(j>=4)
                         {
                            jEditorPane1.setText(jEditorPane1.getText()+CSE5[i][j]+"\t");   
                         }else
                        jEditorPane1.setText(jEditorPane1.getText()+CSE5[i][j]+"\t\t");
                    }
                    jEditorPane1.setText(jEditorPane1.getText()+"\n");
                    jEditorPane1.setText(jEditorPane1.getText()+"\t\t");
                     for(int j=0;j<slotno;j++)
                    {
                        if(j>=4)
                         {
                            jEditorPane1.setText(jEditorPane1.getText()+CSEf5[i][j]+"\t");   
                         }else
                        jEditorPane1.setText(jEditorPane1.getText()+"["+CSEf5[i][j].trim()+"]\t\t");
                    }
                    jEditorPane1.setText(jEditorPane1.getText()+"\n\n");/////////////////////

                    
                  ///////////////////////////////////////////////////////////////////////////////////////
                    jEditorPane1.setText(jEditorPane1.getText()+day[i]+"\t"+br[2]+"\t");
                    for(int j=0;j<slotno;j++)/////////////////////////////////CSE7
                    {
                        if(j>=4)
                         {
                            jEditorPane1.setText(jEditorPane1.getText()+CSE7[i][j]+"\t");   
                         }else
                        jEditorPane1.setText(jEditorPane1.getText()+CSE7[i][j]+"\t\t");
                    }
                    jEditorPane1.setText(jEditorPane1.getText()+"\n");
                    jEditorPane1.setText(jEditorPane1.getText()+"\t\t");
                     for(int j=0;j<slotno;j++)
                    {
                        if(j>=4)
                         {
                            jEditorPane1.setText(jEditorPane1.getText()+"["+CSEf7[i][j].trim()+"]\t");   
                         }else
                        jEditorPane1.setText(jEditorPane1.getText()+"["+CSEf7[i][j].trim()+"]\t\t");
                    }
                      jEditorPane1.setText(jEditorPane1.getText()+"\n_____________________________________________________________________________________________________________________________________________________________________________________________");
                   /////////////////////////////////////////////////////////////////////////////////////////////////
                }

        } 
        
        
    
    

    
    
     int i1,i2,i3;

     int status(String sub[],int lp1,String day[][],int i,int search)//for check suject on that day
       {
           int check=0;
           for(int j=0;j<search;j++)   
                  {
                      if(sub[lp1].equals(day[i][j]))
                          check=1;   
                  }
           return check;
       }
    
     
     
    void assign(String insertf[][],int f,String other1[][],String other2[][],String sub[],int lp,String subject[][],String fac[])
    {
        int j=0,f1;
       for(int i=0;i<5;i++)
       { 
           int com1=other1[f][i].compareTo(fac[lp]);
           int com2=other2[f][i].compareTo(fac[lp]);
           if(f>0)
           {
              f1=f-1;
           }
           else
               f1=f;
           int com3=sub[lp].compareTo(subject[f1][i]);
       //    System.out.println(lp+" "+sub[lp]+" "+com1+" "+insertf[f][i]);
           if(insertf[f][i]=="s" && com1!=0 && com2!=0 && com3!=0 )
           {
             
              if(i==0)
                   {
                   insertf[f][i]=fac[lp];
                   subject[f][i]=sub[lp];   
               //    System.out.println(subject[f][i]+" "+sub[lp]);
                   break;
                  }
              else
               {   
                   int k=i-1; 
                   int com=insertf[f][k].compareTo(fac[lp]);
                   if(com!=0)
                   {
                   insertf[f][i]=fac[lp];
                   subject[f][i]=sub[lp];
                  // System.out.println(subject[f][i]+" "+sub[lp]);
                   break;
                   }
               }
            }
               
           }
       }
    
    
    
    
    
    int labcheck(String sub[],int lp1,String day[][],int j)
    {
        int check=0;
        for(int i=5;i<7;i++)
        {
            if(sub[lp1]==day[j][i])
                check=1;
        }
     return check;   
    }
    
    int cals(String day[][],int j)
    {
        int check=0;
        for(int i=0;i<5;i++)
        {
            if(day[j][i].equals("s"))
                check++;
        }
        return check;
    }
    
    
    //////////////////lab check no. of s
    int calslab(String day[][],int j)
    {
        int check=0;
        for(int i=5;i<7;i++)
        {
            if(day[j][i].equals("s"))
                check++;
        }
        return check;
    }
    
    
    
    void assignlab(String insertf[][],int f,String other1[][],String other2[][],String sub[],int lp,String subject[][],String fac[])
    {
         for(int i=5;i<7;i++)
       {

               int com1=other1[f][i].compareTo(fac[lp]);
               int com2=other1[f][i].compareTo(fac[lp]);
           
               if(insertf[f][i]=="s" && com1!=0 && com2!=0)
                {
                   if(i==0)
                   {
                   insertf[f][i]=fac[lp];
                   subject[f][i]=sub[lp];
                   break;
                  }
               else
               {   
                   int k=i-1; 
                   int com=insertf[f][k].compareTo(fac[lp]);
               
              
                   if(com!=0)
                   {
                   insertf[f][i]=fac[lp];
                   subject[f][i]=sub[lp];
                   break;
                   }
               }
                }
       }
    }//////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////
    
    
    
    /////////////////////////LAb assign
    void lab1(int lab[],int lp,String sub[],String fac[],String CSEf[][],String other1[][],String other2[][],String CSE[][])    
    {
        int checklab;
        int check1;
        for(
                int i=0;i<lab[lp];i++)
                     {
                       checklab=labcheck(sub,lp,CSE,0);
                       check1=calslab(CSE,0);
                       if(checklab==0 && check1>0)
                       {
                           assignlab(CSEf,0, other1,other2,sub,lp,CSE,fac);
                       }
                       else
                       {
                           check1=calslab(CSE,1);
                          checklab=labcheck(sub,lp,CSE,1);//Monady
                           if(checklab==0 && check1>0)
                           {
                           assignlab(CSEf,1, other1,other2,sub,lp,CSE,fac);
                          }
                          else
                          {
                            check1=calslab(CSE,2);
                            checklab=labcheck(sub,lp,CSE,2);//Tuesday
                            if(checklab==0 && check1>0)
                            {
                            assignlab(CSEf,2, other1,other2,sub,lp,CSE,fac);
                            }
                            else
                            {
                                check1=calslab(CSE,3);
                                checklab=labcheck(sub,lp,CSE,3);//Wednesday
                                if(checklab==0 && check1>0)
                                {
                                  assignlab(CSEf,3, other1,other2,sub,lp,CSE,fac);
                                }
                                else
                                {
                                     check1=calslab(CSE,4);
                                    checklab=labcheck(sub,lp,CSE,4);//Thursday
                                    if(checklab==0 && check1>0)
                                    {
                                     assignlab(CSEf,4, other1,other2,sub,lp,CSE,fac);
                                    }
                                    else
                                    {
                                        check1=calslab(CSE,5);
                                       checklab=labcheck(sub,lp,CSE,5);//Friday
                                        if(checklab==0 && check1>0)
                                        {
                                         assignlab(CSEf,5, other1, other2,sub,lp,CSE,fac);
                                        } 
                                    }
                                }
                            }
                        }
                       } 
                     }
                  }
    ////////////////////////////////////////////////////////////////Theory
    ///////////////////////////////////////////Assign
   void theory1(int lec[],int lp,String sub[],String fac[],String CSEf[][],String other1[][],String other2[][],String CSE[][],int searchno)
    {
      //System.out.println();
        int check;
        int check1;
      for(int i=0;i<lec[lp];i++)
                 {
                    check=status(sub,lp,CSE,0,searchno);//Monady
                    check1=cals(CSE,0);
                    if(check==0 && check1>0)
                    {
                        assign(CSEf,0,other1, other2,sub,lp,CSE,fac);
                    }
                    else
                    {
                        check=status(sub,lp,CSE,1,searchno);//Tuesday
                        check1=cals(CSE,1);
                        if(check==0 && check1>0)
                        {
                          assign(CSEf,1,other1, other2,sub,lp,CSE,fac);
                        }
                        else
                        {
                            check=status(sub,lp,CSE,2,searchno);//Wednesday
                            check1=cals(CSE,2);
                            if(check==0 && check1>0)
                            {
                              assign(CSEf,2,other1, other2,sub,lp,CSE,fac);
                            }
                            else
                            {
                                int check11;
                                check11=cals(CSE,3);
                                check=status(sub,lp,CSE,3,searchno);//Thursday
                                 i1=check11;
                                if(check==0 && check11>0)
                                {
                                  assign(CSEf,3,other1, other2,sub,lp,CSE,fac);
                                }
                                else
                                {
                                    int check12=cals(CSE,4);
                                    check=status(sub,lp,CSE,4,searchno);//Friday
                                    i2=check12;
                                    if(check==0 && check12>0)
                                    {
                                     assign(CSEf,4,other1, other2,sub,lp,CSE,fac);
                                    }
                                    else
                                    {
                                        int check13;
                                        check13=cals(CSE,5);
                                        check=status(sub,lp,CSE,5,searchno);//Saturday
                                        i3=check13;
                                        if(check==0 && check13>0)
                                        {
                                         assign(CSEf,5,other1, other2,sub,lp,CSE,fac);
                                        } 
                                        else
                                        {
                                            int dialogButton=0;
               dialogButton = op.showConfirmDialog (null, "Too much burdern on "+fac[lp]+"\nDo you want to break contraint for "+fac[lp],"WARNING", dialogButton);
                                         if(dialogButton==0)
                                            {
                                            int min=0;
                                            if(i1>1)
                                            {
                                             min=3;  
                                            }
                                            else if(i2>1)
                                            {
                                              min=4;  
                                            }
                                            else if(i3>1)
                                            {
                                                min=5;
                                            }
                                            Random rn = new Random();
                                            
                                            int ran=rn.nextInt((5 - min) + 1) + min;
                                            assignafterbreakconstraint(CSEf,ran,other1, other2,sub,lp,CSE,fac); 
                                            }
                                        }
                                        
                                    }
                                }
                            }
                        }
                    }    
                 }  
    }
   /////////////////////////////////////////////////
   ////////////////////////////////////////////////Break Constraint  Then assign
    
    
   
   
    void assignafterbreakconstraint(String insertf[][],int f,String other1[][],String other2[][],String sub[],int lp,String subject[][],String fac[])
    {
        int j=0;
       for(int i=0;i<5;i++)
       {
           
           if(insertf[f][i]=="s" && other1[f][i]!=fac[lp] && other2[f][i]!=fac[lp])
           {
                  insertf[f][i]=fac[lp];
                   subject[f][i]=sub[lp];
                   break;                
           }
               
            }
               
           }
    
    
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton SAVE;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JOptionPane op;
    // End of variables declaration//GEN-END:variables
}
