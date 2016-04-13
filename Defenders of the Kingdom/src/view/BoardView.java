package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.swing.border.*;

import controller.BoardController;

public class BoardView implements ActionListener
{
    private final JPanel gui = new JPanel(new BorderLayout(3, 3));
    private JButton[][] BoardSquares = new JButton[10][10];
    private JPanel Board;
    private final JLabel message = new JLabel(
            "Ready to play!");
    private static final String COLS = "ABCDEFGHIJ";
    private JLabel messageBox;

    public BoardView()
    {
        initializeGui();
    }
    
    private BoardController boardController;
    
    public void setController(BoardController boardController)
    {
    	this.boardController = boardController;
    }

    public final void initializeGui()
    {
        //main GUI
        gui.setBorder(new EmptyBorder(5, 5, 5, 5));
        JToolBar tools = new JToolBar();
        tools.setFloatable(false);
        gui.add(tools, BorderLayout.PAGE_START);
        JButton newButton = new JButton("New");
        newButton.addActionListener(new ActionListener()
		{
		    public void actionPerformed(ActionEvent e)
		    {
		    	printMessage(boardController.getNextMessage());
		    }
		});
        tools.add(newButton); // add functionality!
        tools.add(new JButton("Save")); // add functionality!
        tools.add(new JButton("Restore")); // add functionality!
        tools.addSeparator();
        tools.add(new JButton("Resign")); // add functionality!
        tools.addSeparator();
        tools.add(message);

        messageBox = new JLabel("<html>optional game statistics pane</html>");
        gui.add(messageBox, BorderLayout.LINE_START);

        Board = new JPanel(new GridLayout(0, 11));
        Board.setBorder(new LineBorder(Color.BLACK));
        gui.add(Board);

        
        Insets buttonMargin = new Insets(0,0,0,0);
        for (int height = 0; height < BoardSquares.length; height++) {
            for (int width = 0; width < BoardSquares[height].length; width++) {
                JButton b = new JButton();
                b.addActionListener(this);
                b.setActionCommand(width + "," + height);
                b.setMargin(buttonMargin);
               
                ImageIcon icon = new ImageIcon(
                        new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB)); 
                //need images or something
                b.setIcon(icon);
                //in case we want different colored squares
                if ((width % 2 == 1 && height % 2 == 1) || (width % 2 == 0 && height % 2 == 0)) {
                    b.setBackground(Color.WHITE);
                } else {
                    b.setBackground(Color.WHITE);
                }
                BoardSquares[width][height] = b;
            }
        }

        //fill the board
        Board.add(new JLabel(""));
        
        for (int height = 0; height < 10; height++) {
            Board.add(
                    new JLabel(COLS.substring(height, height + 1),
                    SwingConstants.CENTER));
        }
        
        for (int height = 0; height < 10; height++) {
            for (int width = 0; width < 10; width++) {
                switch (width) {
                    case 0:
                        Board.add(new JLabel("" + (height + 1),
                                SwingConstants.CENTER));
                    default:
                        Board.add(BoardSquares[width][height]);
                }
            }
        }
        JFrame f = new JFrame();
        f.add(gui);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setLocationByPlatform(true);

        // ensures the frame is the minimum size it needs to be
        // in order display the components within it
        f.pack();
        // ensures the minimum size is enforced.
        f.setMinimumSize(f.getSize());
        f.setVisible(true);
    }

    public JButton[][] getBoardSquares() {
		return BoardSquares;
	}

	public final JComponent getBoard() {
        return Board;
    }

    public final JComponent getGui() {
        return gui;
    }
    
    public void printMessage(String message)
    {
    	String text = messageBox.getText();
    	messageBox.setText(text.substring(0, text.length() - 7) + "<br>" + message + "</html>");
    }

    private int x1;
    private int y1;
    private boolean move = false;
    
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String cellPos = e.getActionCommand();
		String[] pos = cellPos.split(",");
		int x = Integer.parseInt(pos[0]);
		int y = Integer.parseInt(pos[1]);
		if (move)
		{
			if (!boardController.moveUnit(x1, y1, x, y))
				printMessage("Invalid move");
			move = false;
		}
		else
		{
			x1 = x;
			y1 = y;
			move = true;
		}
	}
}