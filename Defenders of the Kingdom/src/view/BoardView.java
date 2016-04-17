package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.DefaultCaret;

import model.Board;
import model.Entity;
import model.Unit;
import controller.BoardController;

public class BoardView
{
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] BoardSquares = new JButton[10][10];
    private JPanel Board;
    private final JLabel status = new JLabel("Ready to play!");
    private static final String COLS = "ABCDEFGHIJ";
    private JTextPane messageBox;
    private Board board;
    private JButton newButton = new JButton("New");
    private JButton resignButton = new JButton("Resign");
    private JLabel timer = new JLabel("0");
    private JLabel timeLimit = new JLabel("Time limit:");
    private JLabel time = new JLabel("Time:");
    private JTextField enterTime = new JTextField("60");
    
    public BoardView(Board board)
    {
    	this.board = board;
    	initializeGui();
    }
    
    public final void initializeGui()
    {
        //main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        tools.add(newButton); // add functionality!
        tools.add(new JButton("Save")); // add functionality!
        tools.add(new JButton("Restore")); // add functionality!
        tools.addSeparator();
        tools.add(resignButton);
        tools.addSeparator();
        tools.add(status);
        tools.addSeparator();
        tools.add(time);
        tools.addSeparator();
        tools.add(timer);
        tools.addSeparator();
        tools.add(timeLimit);
        tools.addSeparator();
        enterTime.setSize(10, 5);
        tools.add(enterTime);
        
        messageBox = new JTextPane();
        messageBox.setText("Messages:\n");
        messageBox.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageBox);
        scrollPane.setPreferredSize(new Dimension(0, 100));
        scrollPane.setVerticalScrollBar(new JScrollBar());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        DefaultCaret caret = (DefaultCaret)messageBox.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        gui.add(scrollPane, BorderLayout.SOUTH);

        Board = new JPanel(new GridLayout(0, 12));
        Board.setBorder(new LineBorder(Color.BLACK));
        gui.add(Board);

        
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int height = 0; height < BoardSquares.length; height++) {
            for (int width = 0; width < BoardSquares[height].length; width++) {
                JButton b = new JButton();
                b.setActionCommand(width + "," + height);
                b.setMargin(buttonMargin);
                b.setBackground(Color.WHITE);
                BoardSquares[width][height] = b;
            }
        }

        //fill the board
        Board.add(new JLabel());
        
        for (int height = 0; height < 10; height++) {
            Board.add(
                    new JLabel(COLS.substring(height, height + 1),
                    SwingConstants.CENTER));
        }
        
        Board.add(new JLabel(""));
        
        for (int height = 0; height < 10; height++) {
            for (int width = 0; width < 10; width++) {
                switch (width) {
                    case 0:
                        Board.add(new JLabel(String.valueOf((height + 1)),
                                SwingConstants.CENTER));
                    default:
                        Board.add(BoardSquares[width][height]);
                }
            }
            Board.add(new JLabel(""));
        }
        
        Board.add(new JLabel());
        
        JFrame frame = new JFrame();
        frame.add(gui);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setPreferredSize(new Dimension(800, 800));
        // ensures the frame is the minimum size it needs to be
        // in order display the components within it
        frame.pack();
        // ensures the minimum size is enforced.
        frame.setMinimumSize(new Dimension(600, 600));
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
        frame.setVisible(true);
    }

    public JLabel getStatus()
    {
    	return status;
    }
    
    public JButton getResignButton()
    {
    	return resignButton;
    }

    public JLabel getTimer()
    {
    	return timer;
    }
    
    public JTextField getEnterTime()
    {
    	return enterTime;
    }
    
    public JButton getNewButton()
    {
    	return newButton;
    }
    
    public JButton[][] getBoardSquares() {
		return BoardSquares;
	}

    public JTextPane getMessageBox()
    {
    	return messageBox;
    }
    
    public void startTimer()
    {
    	new Thread(new Runnable()
    	{
    		public void run()
    		{
    			enterTime.setEnabled(false);
    			while (true)
    			{
	    			try
	    			{
						Thread.sleep(1000);
					}
	    			catch (InterruptedException e)
	    			{
						e.printStackTrace();
					}
	    			timer.setText(String.valueOf(Integer.parseInt(timer.getText()) + 1));	
    			}
    		}
    	}).start();
    }
    
	public void updateBoard()
	{
		for (int i = 0; i < BoardSquares.length; ++i)
		{
			for (int j = 0; j < BoardSquares.length; ++j)
			{
				JButton square = BoardSquares[i][j];
				square.setBackground(Color.WHITE);
				Entity entity = board.getCell(i, j).getEntity();
				if (entity == null)
				{
					square.setForeground(Color.BLACK);
					square.setText("");
				}
				else
				{
					if (((Unit)entity).getTeamName().equals("Heroes"))
						square.setForeground(Color.BLUE);
					else
						square.setForeground(Color.RED);
					square.setText(String.valueOf(entity.getIcon()));
				}
			}
		}
	}
	
	public void showRange(Unit unit, int x, int y)
	{
		BoardSquares[x][y].setBackground(new Color(225, 225, 225));
		for (int i = 0; i < BoardSquares.length; ++i)
		{
			for (int j = 0; j < BoardSquares.length; ++j)
			{
				if (unit.getMovementRadius() >= Math.abs(x - i) + Math.abs(y - j))
				{
					if (i != x || j != y)
						if (board.getCell(i, j).getEntity() == null)
						BoardSquares[i][j].setBackground(Color.LIGHT_GRAY);
				}
			}
		}
	}
}