package controller;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import javax.swing.text.DefaultCaret;

import model.Board;
import model.Entity;
import model.Player;
import model.Turn;
import model.Unit;
import view.BoardView;

public class BoardController implements ActionListener, PropertyChangeListener
{
	private Board board;
	private BoardView boardView;
	private Turn turn = new Turn(this);

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
		JButton[][] squares = boardView.getBoardSquares();
		int size = squares.length;
		for (int i = 0; i < size; ++i)
			for (int j = 0; j < size; ++j)
				squares[i][j].addActionListener(this);
		boardView.getTimer().addPropertyChangeListener("text", this);
	}
	
	private void startGame()
	{
		if (turn.hasStarted())
			return;
		try  
		{  
			Integer.parseInt(boardView.getEnterTime().getText());
		}  
		catch (NumberFormatException e)  
		{
			JOptionPane.showMessageDialog(null, "Invalid time");
			return;  
		}
		turn.setUpPlayers();
		turn.updateGame();
		board.placeUnits(turn.getPlayers());
		boardView.updateBoard();
		boardView.startTimer();
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
    // Not yet implemented
    private void resignButtonClicked()
    {
    	turn.setStarted(false);
    }
    
    private int x1;
    private int y1;
    private Unit unit;
    private boolean move = false;
    
    private void cellClicked(ActionEvent e)
    {
    	if (!turn.hasStarted())
			return;
		String cellPos = e.getActionCommand();
		String[] pos = cellPos.split(",");
		int x = Integer.parseInt(pos[0]);
		int y = Integer.parseInt(pos[1]);
		if (!move)
		{
			Entity entity = board.getCell(x, y).getEntity();
			if (entity == null || !(entity instanceof Unit))
				return;
			unit = (Unit)entity;
			if (!turn.getCurrentPlayer().getTeam().getName().equals(unit.getTeam().getName()))
			{
				printMessage(unit.getName() + " is not part of your team");
				return;
			}
			boardView.showRange(unit, x, y);
			printMessage("Choose where to move " + unit.getName());
			x1 = x;
			y1 = y;
			move = true;
		}
		else
		{
			if (x == x1 && y == y1)
				printMessage("Movement cancelled");
			else if (!unit.moveUnit(board.getCell(x1, y1), board.getCell(x, y)))
				printMessage("Invalid move");
			else
			{
				printMessage(unit.getName() + " moved from " + String.valueOf((char)(x1 + 64))
						+ "," + y1 + " to " + String.valueOf((char)(x + 64)) + "," + y);
				turn.updateGame();
			}
			boardView.getTimer().setText("0");
			boardView.updateBoard();
			move = false;
		}
    }

	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		if (Integer.parseInt(boardView.getTimer().getText())
				>= Integer.parseInt(boardView.getEnterTime().getText()))
		{
			printMessage("Out of time");
			turn.updateGame();
			boardView.updateBoard();
			boardView.getTimer().setText("0");
		}
	}
}
