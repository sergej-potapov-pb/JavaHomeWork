package com.pb.potapov.hw15;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.Socket;

public class ClientGUI2 extends JFrame implements ActionListener, MiniChatEvent {

    private final JTextArea msgsTextArea = new JTextArea();
    private final JTextField msgText = new JTextField();
    private final JButton sendMsg = new JButton("Send");
    private final JButton exitButton = new JButton("Exit");
    private final JPanel topPanel = new JPanel();
    private final JPanel botPanel = new JPanel(new GridBagLayout());

    private static String serverIp = "127.0.0.1";
    private static int serverPort = 9000;
    private MiniChatConnection mcConnection;

    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new ClientGUI2();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private ClientGUI2() throws IOException {
        setTitle("Chat client");

        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); // не закрывать окно приложения, будет задан перехват события
        setSize(500, 300);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);

        // перехват события закрытия окна приложения
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                exitButton.doClick();
            }
        });

        msgText.setHorizontalAlignment(JTextField.LEFT);
        botPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        botPanel.setLayout(new GridLayout(1, 3, -1, -1));

        sendMsg.addActionListener(this);
        exitButton.addActionListener(this);
        botPanel.add(msgText, FlowLayout.LEFT);
        botPanel.add(sendMsg);
        botPanel.add(exitButton);

        msgText.addActionListener(this);
        add(botPanel, BorderLayout.SOUTH);

        msgsTextArea.setEditable(false);
        msgsTextArea.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        JScrollPane scrollMsgs = new JScrollPane(msgsTextArea);
        scrollMsgs.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        topPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 0));
        topPanel.setLayout(new GridLayout(1, 2, -1, -1));

        topPanel.add(scrollMsgs, BorderLayout.CENTER);
        add(topPanel, BorderLayout.CENTER);


        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mcConnection.diconnect();
                System.exit(-1);
            }
        });
        sendMsg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = msgText.getText().trim();
                if (!msg.equals("")) {
                    mcConnection.sendMessage(msg);
                    printTextArea(msg);
                    msgText.setText("");

                }
            }
        });

        setVisible(true);
        try {
            mcConnection = new MiniChatConnection(new Socket(serverIp, serverPort), this);
        } catch (IOException ex) {
            printTextArea("Возникло исключение в соединении:" + ex);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String msg = msgText.getText().trim();
        if (!msg.equals("")) {
            mcConnection.sendMessage(msg);
            printTextArea(msg);
            msgText.setText("");

        }

    }

    @Override
    public void onConnectionReady(MiniChatConnection mcConnection) {
        printTextArea("Выполнено подключение " + serverIp + ":" + serverPort);

    }

    @Override
    public void onReceiveString(MiniChatConnection mcConnection, String msg) {
        printTextArea(msg);

    }

    @Override
    public void onDisconnect(MiniChatConnection mcConnection) {
        printTextArea("Соединение завершено");

    }

    @Override
    public void onException(MiniChatConnection mcConnection, Exception ex) {
        printTextArea("Возникло исключение в соединении:" + ex);
    }

    private synchronized void printTextArea(String msg) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                msgsTextArea.append(msg + "\n");
                msgsTextArea.setCaretPosition(msgsTextArea.getDocument().getLength());
            }
        });

    }

}
