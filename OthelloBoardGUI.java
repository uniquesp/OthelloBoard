package OOP4.OthelloBoard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OthelloBoardGUI extends JFrame {

    private final OthelloBoardLogic board;
    private final JButton[][] buttons;
    private boolean p1Turn = true;

    public OthelloBoardGUI() {
        board = new OthelloBoardLogic();
        buttons = new JButton[8][8];

        setTitle("Othello Game");
        setLayout(new GridLayout(8, 8));
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initializeBoard();
        updateBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                buttons[i][j] = new JButton();
                buttons[i][j].setPreferredSize(new Dimension(60, 60));
                buttons[i][j].setFont(new Font("Arial", Font.BOLD, 24));
                buttons[i][j].setBackground(Color.GREEN);
                buttons[i][j].addActionListener(new ButtonClickListener(i, j));
                add(buttons[i][j]);
            }
        }
    }

    private void updateBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                int symbol = board.getCell(i, j);
                if (symbol == OthelloBoardLogic.player1Symbol) {
                    buttons[i][j].setText("X");
                    buttons[i][j].setForeground(Color.BLACK);
                } else if (symbol == OthelloBoardLogic.player2Symbol) {
                    buttons[i][j].setText("O");
                    buttons[i][j].setForeground(Color.WHITE);
                } else {
                    buttons[i][j].setText("");
                }
            }
        }
    }

    private void showGameOverDialog() {
        int winner = board.getWinner();
        if (winner == 0) {
            JOptionPane.showMessageDialog(
                this,
                "The game is a tie!",
                "Game Over",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else if (winner == OthelloBoardLogic.player1Symbol) {
            JOptionPane.showMessageDialog(
                this,
                "Player 1 (X) wins!",
                "Game Over",
                JOptionPane.INFORMATION_MESSAGE
            );
        } else {
            JOptionPane.showMessageDialog(
                this,
                "Player 2 (O) wins!",
                "Game Over",
                JOptionPane.INFORMATION_MESSAGE
            );
        }
        System.exit(0); // Exit the game after showing the message
    }

    private class ButtonClickListener implements ActionListener {
        private final int x, y;

        public ButtonClickListener(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean validMove;
            if (p1Turn) {
                validMove = board.move(OthelloBoardLogic.player1Symbol, x, y);
            } else {
                validMove = board.move(OthelloBoardLogic.player2Symbol, x, y);
            }

            if (validMove) {
                updateBoard();
                p1Turn = !p1Turn;

                if (board.isBoardFull()) {
                    showGameOverDialog();
                }
            } else {
                JOptionPane.showMessageDialog(
                    OthelloBoardGUI.this,
                    "Invalid move. Please try again.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
                );
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            OthelloBoardGUI game = new OthelloBoardGUI();
            game.setVisible(true);
        });
    }
}
