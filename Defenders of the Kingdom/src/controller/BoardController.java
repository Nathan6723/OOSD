package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import model.Board;
import model.Cell;
import model.Movement;
import model.PlayerCreator;
import model.Turn;
import model.Unit;
import view.BoardView;

public class BoardController implements ActionListener, PropertyChangeListener
{
	private Board board;
	private BoardView boardView;
	private Turn turn = new Turn(this);
	private Movement movement = new Movement(this);
	private PlayerCreator playerCreator = new PlayerCreator(this);
	
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
		JButton[][] squares = boardView.getSquares();
		int size = squares.length;
		for (int i = 0; i < size; ++i)
			for (int j = 0; j < size; ++j)
				squares[i][j].addActionListener(this);
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
		boardView.getStatus().setText(status);
	}
	
    @Override
	public void actionPerformed(ActionEvent e)
	{
    	if (e.getSource() == boardView.getNewButton())
    		startGame();
    	else if (e.getSource() == boardView.getResignButton())
    		resignButtonClicked();
    	else
    		cellClicked(e);
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
		if (!playerCreator.createPlayers())
			return;
		board.placeUnits(playerCreator.getPlayers());
		turn.setPlayers(playerCreator.getPlayers());
		turn.updateGame();
		boardView.updateBoard();
		boardView.startTimer();
	}
    
    // Not implemented
    private void resignButtonClicked()
    {
    	
    }
    
    private void cellClicked(ActionEvent e)
    {
    	if (!turn.hasStarted())
			return;
		String cellPos = e.getActionCommand();
		String[] pos = cellPos.split(",");
		int x = Integer.parseInt(pos[0]);
		int y = Integer.parseInt(pos[1]);
		Cell cell = board.getCell(x, y);
		if (!movement.getCanMove())
		{
			if (movement.canMove(cell, turn.getCurrentPlayer()))
				boardView.showRange((Unit)cell.getEntity(), x, y);
			else return;
		}
		else
		{
			if (movement.moveUnit(board.getCell(x, y)))
			{
				turn.updateGame();
				boardView.getTimer().setText("0");	
			}
			boardView.updateBoard();
		}
    }

	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		if (Integer.parseInt(boardView.getTimer().getText())
				>= Integer.parseInt(boardView.getTimeInput().getText()))
		{
			printMessage(OUT_OF_TIME_MESSAGE);
			turn.updateGame();
			boardView.updateBoard();
			boardView.getTimer().setText("0");
		}
	}
}
