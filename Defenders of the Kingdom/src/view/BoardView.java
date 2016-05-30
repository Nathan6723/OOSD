package view;

import java.awt.*;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;
import javax.swing.border.*;
import javax.swing.text.DefaultCaret;

import com.google.java.contract.Requires;

import model.board.Board;
import model.board.Cell;
import model.entity.Entity;
import model.manager.ValidDirection;
import model.unit.Unit;

public class BoardView implements Observer
{
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] squares = new JButton[10][10];
    private JLabel panel;
    private final JLabel status = new JLabel(STARTING_STATUS);
    private static final String COLS = "ABCDEFGHIJ";
    private JTextPane messageBox;
    private Board board;
    private JButton newButton = new JButton("New");
    private JButton resignButton = new JButton("Resign");
    private JLabel timer = new JLabel("0");
    private JLabel timeLimit = new JLabel("Time limit:");
    private JLabel time = new JLabel("Time:");
    private JTextField timeInput = new JTextField("60");
    private JButton movementStyleButton = new JButton(CLICK_TO_MOVE);
    private JButton loadButton = new JButton("Load");
    private JButton saveButton = new JButton("Save");
    private JButton undoButton = new JButton("Undo");
    private ValidDirection validDirection = new ValidDirection();
    
    public final static String CLICK_TO_MOVE = "Click to move";
    public final static String STARTING_STATUS = "Ready to play!";
    public final static String STARTING_MESSAGE = "Messages:\n";
    
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
        tools.add(newButton);
        tools.add(loadButton);
        saveButton.setEnabled(false);
        tools.add(saveButton);
        resignButton.setEnabled(false);
        tools.add(resignButton);
        undoButton.setEnabled(false);
        tools.add(undoButton);
        tools.addSeparator();
        JLabel movementLable = new JLabel("Movement:");
        tools.add(movementLable);
        tools.addSeparator();
        tools.add(movementStyleButton);
        tools.addSeparator();
        tools.add(status);
        tools.addSeparator();
        tools.add(time);
        tools.addSeparator();
        tools.add(timer);
        tools.addSeparator();
        tools.add(timeLimit);
        tools.addSeparator();
        timeInput.setSize(10, 5);
        timeInput.setMargin(new Insets(0, 5, 0, 0));
        tools.add(timeInput);
        
        messageBox = new JTextPane();
        messageBox.setText(STARTING_MESSAGE);
        messageBox.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(messageBox);
        scrollPane.setPreferredSize(new Dimension(0, 85));
        scrollPane.setVerticalScrollBar(new JScrollBar());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        DefaultCaret caret = (DefaultCaret)messageBox.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        gui.add(scrollPane, BorderLayout.SOUTH);

        panel = new JLabel();
        panel.setLayout(new GridLayout(0, 12));
        panel.setBorder(new LineBorder(Color.BLACK));
        ImageIcon image = new ImageIcon("img/bkdg.jpg");
        panel.setIcon(image);
        gui.add(panel);
        
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int height = 0; height < squares.length; height++)
        {
            for (int width = 0; width < squares[height].length; width++)
            {
                JButton b = new JButton();
                b.setActionCommand(width + "," + height);
                b.setMargin(buttonMargin);
                b.setBackground(Color.WHITE);
                squares[width][height] = b;
            }
        }

        //fill the board
        panel.add(new JLabel());
        
        for (int height = 0; height < squares.length; ++height)
        {
        	JLabel label = new JLabel(COLS.substring(height, height + 1),
                    SwingConstants.CENTER); 
        	label.setForeground(Color.WHITE);
        	panel.add(label);
        }
        
        panel.add(new JLabel(""));
        
        for (int height = 0; height < squares.length; height++)
        {
            for (int width = 0; width < squares.length; width++)
            {
                switch (width) {
                    case 0:
                    	JLabel label = new JLabel(String.valueOf((height + 1)),
                                SwingConstants.CENTER);
                    	label.setForeground(Color.WHITE);
                    	panel.add(label);
                    default:
                    	panel.add(squares[width][height]);
                }
            }
            panel.add(new JLabel(""));
        }
        
        panel.add(new JLabel());
        
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
    
    public JButton getUndoButton()
    {
    	return undoButton;
    }
    
    public JButton getLoadButton()
    {
    	return loadButton;
    }
    
    public JButton getSaveButton()
    {
    	return saveButton;
    }
    
    public JButton getMovementStyleButton()
    {
    	return movementStyleButton;
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
    
    public JTextField getTimeInput()
    {
    	return timeInput;
    }
    
    public JButton getNewButton()
    {
    	return newButton;
    }
    
    public JButton[][] getSquares()
    {
		return squares;
	}

    public JTextPane getMessageBox()
    {
    	return messageBox;
    }
    
    private boolean timing;
    
    public void setTiming(boolean timing)
    {
    	this.timing = timing;
    }
    
    public void setBoard(Board board)
    {
    	this.board = board;
    }
    
    public void startTimer()
    {
    	timing = true;
    	new Thread(new Runnable()
    	{
    		public void run()
    		{
    			timeInput.setEnabled(false);
    			if (Integer.parseInt(timeInput.getText()) == 0)
    				return;
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
	    			if (!timing)
	    				return;
	    			timer.setText(String.valueOf(Integer.parseInt(timer.getText()) + 1));	
    			}
    		}
    	}).start();
    }
    
    @Requires("unit.getIcon() is valid")
	public void updateBoard()
	{
		for (int i = 0; i < squares.length; ++i)
			for (int j = 0; j < squares.length; ++j)
				updateCell(board.getCell(i, j));
	}
    
    public void updateCell(Cell cell)
    {
    	JButton square = squares[cell.getX()][cell.getY()];
		if (cell.isCurrentCell())
			square.setBackground(new Color(225, 225, 225));
		else if (cell.isPotentialCell())
			square.setBackground(Color.LIGHT_GRAY);
		else
			square.setBackground(Color.WHITE);
		Entity entity = cell.getEntity();
		if (entity == null)
			square.setText("");
		else if (entity instanceof Unit)
		{
			square.setForeground(((Unit)entity).getTeam().getColour());
			square.setText(String.valueOf(entity.getIcon()));
		}
    }
	
	public void showRange(Unit unit, int x, int y)
	{
		squares[x][y].setBackground(new Color(225, 225, 225));
		for (int i = 0; i < squares.length; ++i)
		{
			for (int j = 0; j < squares.length; ++j)
			{
				if (validDirection.isValidDirection(unit.getMovementDirection(), 
						board.getCell(x, y), board.getCell(i, j), unit.getMovementRadius()))
				{
					if (i != x || j != y)
						if (board.getCell(i, j).getEntity() == null)
						squares[i][j].setBackground(Color.LIGHT_GRAY);
				}
			}
		}
	}

	@Override
	public void update(Observable observable, Object object)
	{
		Cell cell = (Cell)observable;
		updateCell(cell);
	}
}
