package model.save;

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import controller.BoardController;
import model.board.Cell;
import model.entity.Entity;
import model.player.Player;
import model.unit.Avatar;
import model.unit.FireLord;
import model.unit.Henchman;
import model.unit.Marksman;
import model.unit.Scout;
import model.unit.Soldier;
import model.unit.Unit;

public class GameState
{
	public final static String SAVE_FILE = "Save.txt";
	private ObjectMapper mapper = new ObjectMapper();
	
	public GameState()
	{
		mapper.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.registerSubtypes(Unit.class, Avatar.class, FireLord.class, Henchman.class
				, Marksman.class, Scout.class, Soldier.class);
	}
	
	public boolean saveGameState(BoardController boardController)
	{
		try
		{
			PrintWriter writer = new PrintWriter(SAVE_FILE);
			
			ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
			SaveObject saveObject = new SaveObject();
			saveObject.cells = boardController.getBoard().getAllCells();
			saveObject.movement = boardController.getMovement();
			saveObject.turn = boardController.getTurn();
			saveObject.timeLimit = boardController.getBoardView().getTimeInput().getText();
			saveObject.timer = boardController.getBoardView().getTimer().getText();
			saveObject.dragAndDrop = boardController.getDragAndDrop();
			saveObject.messages = boardController.getBoardView().getMessageBox().getText();
			String json = ow.writeValueAsString(saveObject);
			writer.print(json);
			
			writer.close();
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean loadGameState(BoardController boardController)
	{
		try
		{
			Path path = Paths.get(SAVE_FILE);
			if (!Files.exists(path))
				return false;
			String json = new String(Files.readAllBytes(path));
			if (json.isEmpty())
				return false;
			SaveObject saveObject = mapper.readValue(json, SaveObject.class);
			boardController.getBoard().setAllCells(saveObject.cells);
			boardController.setMovement(saveObject.movement);
			boardController.setTurn(saveObject.turn);
			boardController.getBoardView().getMessageBox().setText(saveObject.messages);
			boardController.getBoardView().getTimeInput().setText(saveObject.timeLimit);
			boardController.getBoardView().getTimer().setText(saveObject.timer);
			boardController.setDragAndDrop(saveObject.dragAndDrop);
			boardController.getMovement().setBoardController(boardController);
			boardController.getTurn().setBoardController(boardController);
			Player[] players = boardController.getTurn().getPlayers();
	    	for (int i = 0; i < players.length; ++i)
	    	{
	    		Player player = players[i];
	    		ArrayList<Unit> units = player.getTeam().getUnits();
	    		for (int j = 0; j < units.size(); ++j)
	    		{
	    			units.get(j).setTeam(player.getTeam());
	    			Cell[][] cells = boardController.getBoard().getAllCells();
	    			for (int k = 0; k < cells.length; ++k)
	    			{
	    				for (int l = 0; l < cells.length; ++l)
	    				{
	    					Entity entity = cells[k][l].getEntity();
	    					if (entity instanceof Unit)
	    					{
	    						Unit unit = (Unit)entity;
	    						if (unit.getName().equals(units.get(j).getName()))
	    							cells[k][l].setEntity(units.get(j));
	    					}
	    				}
	    			}
	    		}
	    	}
	    	Cell initialCell = boardController.getMovement().getInitialCell();
	    	boardController.getMovement().setInitialCell(
	    			boardController.getBoard().getCell(initialCell.getX(), initialCell.getY()));
	    	boardController.getBoardView().updateBoard();
	    	if (boardController.getMovement().getCanMove())
			{
				if (!boardController.getDragAndDrop())
				{
					Cell cell = boardController.getMovement().getInitialCell();
					boardController.getBoardView().showRange((Unit)cell.getEntity(), cell.getX(), cell.getY());
				}
			}
			return true;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
}
