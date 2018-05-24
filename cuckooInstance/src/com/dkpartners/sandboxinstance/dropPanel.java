package com.dkpartners.sandboxinstance;

import java.io.IOException;

public class dropPanel {

    public dropPanel(){
    }

    public void dragFile(final String privateKey,final String host, final int port, final String user, final String pass, final String remoteDir) throws IOException {

        javax.swing.JFrame frame = new javax.swing.JFrame( "Cuckoo Instance" );

        final javax.swing.JPanel text = new javax.swing.JPanel();
        frame.getContentPane().add(new javax.swing.JScrollPane( text ),java.awt.BorderLayout.CENTER );

        new fileDrop( System.out, text, /*dragBorder,*/ new fileDrop.Listener()
        {   public void filesDropped( java.io.File[] files )
            {   for( int i = 0; i < files.length; i++ )
                {   try
                    {
                        System.out.println(files[i].getCanonicalPath());
                        String file = files[i].getCanonicalPath().toString();
                        sandboxInstance sftpInstance = new sandboxInstance(privateKey,host,port,user,pass,file,remoteDir,System.getProperty("user.name"));
                        sftpUpload upload = new sftpUpload();
                        boolean flag = upload.uploadInstance(sftpInstance);
                        if(flag==true){
                            //System.out.println("True");g
                            javax.swing.JOptionPane.showMessageDialog(frame,"[*] File submitted successfully :: wait for the report");

                        }else{
                            javax.swing.JOptionPane.showMessageDialog(frame,"[*] Failed submission :: contact service desk");
                            //System.out.println("Flase");
                        }
                        //text.append( files[i].getCanonicalPath() + "\n" );
                    }   // end try
                    catch( java.io.IOException e ) {}
                }   // end for: through each dropped file
            }   // end filesDropped
        }); // end FileDrop.Listener

        frame.setBounds( 400, 100, 300, 300 );
        frame.setDefaultCloseOperation( frame.EXIT_ON_CLOSE );
        frame.setVisible(true);
    }   // end main



}
