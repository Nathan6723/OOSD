package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import com.google.java.contract.Requires;

import model.Board;
import model.Cell;
import model.Movement;
import model.Turn;
import model.player.PlayerCreator;
import model.unit.Unit;
import view.BoardView;

public class BoardController implements ActionListener, MouseListener, PropertyChangeListener
{
	private Board board;
	private BoardView boardView;
	private Turn turn = new Turn(this);
	private Movement movement = new Movement(this);
	
	private final static String INVALID_TIME_MESSAGE = "Invalid time";
	private final static String OUT_OF_TIME_MESSAGE = "Out of time";
	
	public BoardController(Board board, BoardView boardView)
	{
		this.board = board;
		this.boardView = boardView;
		addListeners();
	}
	
	private void addListeners()
	{
		boardView.getNewButton().addActionListener(this);
		boardView.getResignButton().addActionListener(this);
		boardView.getMovementStyleButton().addActionListener(this);
		JButton[][] squares = boardView.getSquares();
		int size = squares.length;
		for (int i = 0; i < size; ++i)
		{
			for (int j = 0; j < size; ++j)
			{
				JButton square = squares[i][j];
				square.addActionListener(this);
				square.addMouseListener(this);
			}
		}
		boardView.getTimer().addPropertyChangeListener("text", this);
	}
	
	public int getChoice(String title, String message, String[] options)
	{
		return JOptionPane.showOptionDialog(null, message, title,
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
	}
	
	public void printMessage(String message)
    {
		JTextPane messageBox = boardView.getMessageBox();		
    	messageBox.setText(messageBox.getText() + message + "\n");
    }
	
	public String getInput(String message)
	{
		return JOptionPane.showInputDialog(message);
	}
	
	public void setStatus(String status)
	{
		JLabel statusLabel = boardView.getStatus();
		statusLabel.setForeground(turn.getCurrentPlayer().getTeam().getColour());
		statusLabel.setText(status);
	}
	
    @Override
	public void actionPerformed(ActionEvent e)
	{
    	if (e.getSource() == boardView.getNewButton())
    		startGame();
    	else if (e.getSource() == boardView.getResignButton())
    		resignButtonClicked();
    	else if (e.getSource() == boardView.getMovementStyleButton())
    		movementStyleChanged();
    	else
    		cellClicked(e);
	}
    
    private void movementStyleChanged()
    {
    	JButton button = boardView.getMovementStyleButton();
    	if (dragAndDropEnabled)
    	{
    		button.setText(BoardView.CLICK_TO_MOVE);
    		dragAndDropEnabled = false;
    	}
    	else
    	{
    		button.setText("Drag and drop");
    		dragAndDropEnabled = true;
    	}
    }
    
    private void startGame()
	{
		if (turn.hasStarted())
			return;
		try  
		{  
			Integer.parseInt(boardView.getTimeInput().getText());
		}  
		catch (NumberFormatException e)  
		{
			JOptionPane.showMessageDialog(null, INVALID_TIME_MESSAGE);
			return;  
		}
		PlayerCreator playerCreator = new PlayerCreator(this);
		if (!playerCreator.createPlayers())
			return;
		board.placeUnits(playerCreator.getPlayers());
		turn.setPlayers(playerCreator.getPlayers());
		turn.updateGame();
		boardView.updateBoard();
		boardView.startTimer();
		boardView.getNewButton().setEnabled(false);
		boardView.getResignButton().setEnabled(true);
	}
    
    private void resignButtonClicked()
    {
    	turn.setStarted(false);
    	boardView.getNewButton().setEnabled(true);
    	boardView.getResignButton().setEnabled(false);
    	boardView.getTimeInput().setEnabled(true);
    	boardView.getStatus().setText(BoardView.STARTING_STATUS);
    	boardView.getStatus().setForeground(Color.BLACK);
    	boardView.getTimer().setText("0");
    	boardView.setTiming(false);
    }
    
    @Requires("StartGame()")
    private void cellClicked(ActionEvent e)
    {
    	if (!dragAndDropEnabled)
    		makeMove(e.getActionCommand());
    }

    private void makeMove(String cellPos)
    {
    	if (!turn.hasStarted())
			return;
		String[] pos = cellPos.split(",");
		int x = Integer.parseInt(pos[0]);
		int y = Integer.parseInt(pos[1]);
		Cell cell = board.getCell(x, y);
		if (!movement.getCanMove())
		{
			if (movement.isCellValid(cell, turn.getCurrentPlayer()))
				boardView.showRange((Unit)cell.getEntity(), x, y);
		}
		else
		{
			if (!movement.isSelfClick(cell))
			{
				if (movement.moveUnit(cell))
				{
					turn.updateGame();
					boardView.getTimer().setText("0");	
				}
				else
					return;
			}
			boardView.updateBoard();
			movement.setCanMove(false);
		}
    }
    
	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		if (Integer.parseInt(boardView.getTimer().getText())
				>= Integer.parseInt(boardView.getTimeInput().getText()))
		{
			printMessage(OUT_OF_TIME_MESSAGE);
			movement.setCanMove(false);
			turn.updateGame();
			boardView.updateBoard();
			boardView.getTimer().setText("0");
		}
	}

	private JButton lastButton;
	private JButton pressedButton;
	private boolean dragAndDropEnabled = false;
	
	private JButton findButton(MouseEvent e)
	{
		JButton[][] squares = boardView.getSquares();
		int size = squares.length;
		JButton button = null;
		loops:
		for (int i = 0; i < size; ++i)
		{
			for (int j = 0; j < size; ++j)
			{
				button = squares[i][j];
				if (e.getSource() == button)
					break loops;
			}
		}
		return button;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {}

	@Override
	public void mouseEntered(MouseEvent e)
	{
		if (!turn.hasStarted() || !dragAndDropEnabled || !movement.getCanMove())
			return;
		JButton button = findButton(e);
		if (button != null)
			lastButton = button;
	}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e)
	{
		if (!turn.hasStarted() || !dragAndDropEnabled || movement.getCanMove())
			return;
		JButton button = findButton(e);
		if (button != null)
		{
			pressedButton = button;
			makeMove(button.getActionCommand());
		}
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		if (!turn.hasStarted() || !dragAndDropEnabled || !movement.getCanMove())
			return;
		makeMove(lastButton.getActionCommand());
		if (movement.getCanMove())
			makeMove(pressedButton.getActionCommand());
	}
}
