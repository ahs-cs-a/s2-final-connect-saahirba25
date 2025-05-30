
public class Board  {


    private int rows;
    private int cols;
    
    /** The grid of pieces */
    private Player[][] grid;
    
    

    public Board(int rows, int cols){
        this.rows = rows;
        this.cols = cols;
        grid = new Player[rows][cols];
        // set each cell of the board to null (empty).
        reset();

    }
    
    public void reset() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                grid[r][c] = null;
            }
        }
    }
    
    public int getRows() {
        return rows;
    }
    
    public int getCols() {
        return cols;
    }
    
    
    /**
    * Returns the Player whose piece occupies the given location, 
    * @param row int
    * @param col int
    */
    public Player getCell(int row, int col ) throws IndexOutOfBoundsException{
        if( (row < 0) || (col < 0) || (row >= rows) || (col >= cols) ) {
            throw new IndexOutOfBoundsException();
        } else {
            return grid[row][col];
        }
    }
    
    //returns true if there are no more plays left
    public boolean boardFilled(){
        //TODO: write this
        for (Player[] players : grid) {
            for (Player player : players) {
                if(player == null)
                    return false;
            }
        }
        return true; 
    }

    // Returns true if move is possible given board state.  
    public boolean possibleMove(Move move) {
        // TODO: write this.  Right now, it ignores filled columns, claiming any move is possible
        for (int i = 0; i < grid.length; i++) {
            if(grid[i][move.getColumn()] == null)
            return true;
        }
        return false;
    }
    
    // Adds a piece to the board for a given Move
    public void addPiece(Move move) {
        //TODO: this is a test stub, you need to rewrite this.
    	if(possibleMove(move)){
        int i = 0;
        while(grid[i][move.getColumn()] != null){
            i++;
        }
            grid[i][move.getColumn()] = move.getPlayer();
        }
    }

    // if the board contains a winning position, returns the Player that wins.
    // Otherwise, returns null.  You could ignore lastMove.
    public Player winner(Move lastMove) {
        // TODO: write this.  Currently, there is never a winnder.
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if(grid[j][i] != null){
                if(grid[j][i].getColor() == grid[j+1][i].getColor() && grid[j][i].getColor() == grid[j+2][i].getColor() && grid[j][i].getColor() == grid[j+1][i].getColor())
                    return grid[j][i];
                }else{continue;}
            
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] != null){
                if(grid[i][j].getColor() == grid[i][j+1].getColor() && grid[i][j].getColor() == grid[i][j+2].getColor() && grid[i][j].getColor() == grid[i][j+3].getColor())
                    return grid[i][j];
                }else{continue;}}
        } 
        return null;
    }
} 
   
 // end Board class
