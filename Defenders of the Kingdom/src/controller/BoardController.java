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

import model.board.Board;
import model.board.Cell;
import model.manager.Attack;
import model.manager.Movement;
import model.manager.Turn;
import model.manager.VictoryConditions;
import model.player.PlayerCreator;
import model.save.GameState;
import model.undo.Undo;
import model.unit.Unit;
import view.BoardView;

public class BoardController implements ActionListener, MouseListener, PropertyChangeListener
{
	private Board board;
	private BoardView boardView;
	private Turn turn = new Turn(this);
	private GameState gameState = new GameState();
	private Movement movement = new Movement(this);
	private Attack attack = new Attack(this);
	private Undo undo = new Undo();
	VictoryConditions victoryConditions;
	
	private final static String INVALID_TIME_MESSAGE = "Invalid time";
	private final static String OUT_OF_TIME_MESSAGE = "Out of time";

	public BoardController(Board board, BoardView boardView)
	{
		this.board = board;
		this.boardView = boardView;
		attack.setBoard(board);
		victoryConditions = new VictoryConditions(board);
		for (int i = 0; i < board.getX(); ++i)
			for (int j = 0; j < board.getY(); ++j)
				board.getCell(i, j).addObserver(boardView);
		addListeners();
	}
	
	private void addListeners()
	{
		boardView.getNewButton().addActionListener(this);
		boardView.getLoadButton().addActionListener(this);
		boardView.getSaveButton().addActionListener(this);
		boardView.getResignButton().addActionListener(this);
		boardView.getUndoButton().addActionListener(this);
		boardView.getMovementStyleButton().addActionListener(this);
		boardView.getTimer().addPropertyChangeListener("text", this);
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
	}
	
	public int getChoice(String title, String message, String[] options)
	{
		return JOptionPane.showOptionDialog(null, message, title,
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
	}
	
	public int getConfirm(String message, String title)
	{
		return JOptionPane.showConfirmDialog(null, message, title, JOptionPane.YES_NO_OPTION);
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
		statusLabel.setForeground(turn.currentTurnPlayer().getTeam().getColour());
		statusLabel.setText(status);
	}
	
    @Override
	public void actionPerformed(ActionEvent e)
	{
    	Object component = e.getSource();
    	if (component == boardView.getNewButton())
    		startGame();
    	else if (component == boardView.getLoadButton())
    		loadButtonClicked();
    	else if (component == boardView.getSaveButton())
    		saveButtonClicked();
    	else if (component == boardView.getResignButton())
    		resignButtonClicked();
    	else if (component == boardView.getMovementStyleButton())
    		movementStyleChanged();
    	else if (component == boardView.getUndoButton())
    		Undo();
    	else
    		cellClicked(e);
	}
    
    private void Undo()
    {
    	Board newBoard = undo.undoMove();
    	if (newBoard == null)
    	{
    		printMessage("No undos available");
    		return;
    	}
    	printMessage("Turn has been undone");
    	turn.currentTurnPlayer().setHasUsedUndo(true);
    	turn.currentTurnPlayer().incrementUndoCount();
    	if (turn.currentTurnPlayer().getUndoCount() == 3)
    		boardView.getUndoButton().setEnabled(false);
    	board = newBoard;
    	attack.setBoard(board);
    	boardView.setBoard(board);
    	boardView.getTimer().setText("0");
    }
    
    private void loadButtonClicked()
    {
    	boolean loaded = gameState.loadGameState(this);
    	if (loaded)
    	{
    		startGUI();
    		turn.setStatus();
    		printMessage("Game has been loaded");
    	}
    	else
    		printMessage("No saved game exists");
    }
    
    private void saveButtonClicked()
    {
    	if (gameState.saveGameState(this))
    		printMessage("Game has been saved");
    	else
    		printMessage("Failed to save game");
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
		startNextTurn();
		startGUI();
	}
    
    private void startGUI()
    {
		boardView.startTimer();
		boardView.getNewButton().setEnabled(false);
		boardView.getLoadButton().setEnabled(false);
		boardView.getResignButton().setEnabled(true);
		boardView.getSaveButton().setEnabled(true);
		boardView.getUndoButton().setEnabled(true);
    }
    
    private void resignButtonClicked()
    {
    	turn.setStarted(false);
    	boardView.setTiming(false);
    	boardView.getNewButton().setEnabled(true);
    	boardView.getLoadButton().setEnabled(true);
    	boardView.getResignButton().setEnabled(false);
    	boardView.getSaveButton().setEnabled(false);
    	boardView.getTimeInput().setEnabled(true);
    	boardView.getStatus().setForeground(Color.BLACK);
    	boardView.getStatus().setText(BoardView.STARTING_STATUS);
    	boardView.getMessageBox().setText(BoardView.STARTING_MESSAGE);
    	boardView.getUndoButton().setEnabled(false);
    	boardView.getTimer().setText("0");
    	movement.setCanMove(false);
    	attack.setIsAttacking(false);
    	for (int i = 0; i < board.getX(); ++i)
    	{
    		for (int j = 0; j < board.getY(); ++j)
    		{
    			Cell cell = board.getCell(i, j);
    			cell.setEntity(null);
    			cell.setCurrentCell(false);
    			cell.setPotentialCell(false);
    		}
    	}
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
		if (!attack.getIsAttacking())
		{
			if (!movement.getCanMove())
			{
				if (movement.isCellValid(cell, turn.currentTurnPlayer()))
					boardView.showRange((Unit)cell.getEntity(), x, y);
			}
			else
			{
				if (!movement.isSelfClick(cell))
				{
					if (movement.moveUnit(cell))
					{
						if (!attack.captureAttack(cell))
							startNextTurn();
					}
					else
						return;
				}
				movement.setCanMove(false);
			}
		}
		else
		{
			attack.captureAttack(cell);
			if (attack.getIsAttacking())
				return;
			startNextTurn();
		}
    }
    
    private void startNextTurn()
    {
		if (victoryConditions.checkVictory())
		{
			resignButtonClicked();
			printMessage(turn.currentTurnPlayer().getName() + VictoryConditions.VICTORY_MESSAGE);
			return;
		}
    	turn.updateGame();
		boardView.getTimer().setText("0");
		boardView.updateBoard();
		undo.storeMove(board);
		if (turn.currentTurnPlayer().HasUsedUndo())
			boardView.getUndoButton().setEnabled(false);
		else
			boardView.getUndoButton().setEnabled(true);
    }
    
	@Override
	public void propertyChange(PropertyChangeEvent e)
	{
		if (Integer.parseInt(boardView.getTimer().getText())
				>= Integer.parseInt(boardView.getTimeInput().getText()))
		{
			printMessage(OUT_OF_TIME_MESSAGE);
			movement.setCanMove(false);
			startNextTurn();
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
		if (lastButton == null)
		{
			makeMove(pressedButton.getActionCommand());
			return;
		}
		makeMove(lastButton.getActionCommand());
		if (movement.getCanMove())
			makeMove(pressedButton.getActionCommand());
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public Movement getMovement()
	{
		return movement;
	}
	
	public void setMovement(Movement movement)
	{
		this.movement = movement;
	}
	
	public Attack getAttack()
	{
		return attack;
	}
	
	public void setAttack(Attack attack)
	{
		this.attack = attack;
	}
	
	public Turn getTurn()
	{
		return turn;
	}
	
	public void setTurn(Turn turn)
	{
		this.turn = turn;
	}
	
	public BoardView getBoardView()
	{
		return boardView;
	}
	
	public boolean getDragAndDrop()
	{
		return dragAndDropEnabled;
	}
	
	public void setDragAndDrop(boolean dragAndDrop)
	{
		dragAndDropEnabled = dragAndDrop;
	}
}
