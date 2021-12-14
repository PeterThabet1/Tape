package turing;

/**
 * This class extends Cell class and simulates the Tape for Turing machine
 * 
 *
 */
public class Tape extends Cell { // Tape class begin
	
	private Cell currentCell; //the currentCell to operate on

	public Tape(){ // constructor begin
		
		this.content = ' ';
		currentCell = this;
		
	} // constructor end


	/**
	 * getter method to return currentCell
	 * 
	 * @return Cell at current position
	 */
	public Cell getCurrentCell() { // getCurrentCell() begin
		
		return currentCell;
		
	} // getCurrentCell() end

	/**
	 * getter method to return content of current cell.
	 * 
	 * @return content of current cell
	 */
	public char getContent() { // getContent() begin
		
		return currentCell.content;
		
	} // getContent() end



	/**
	 * setter method to set content at currentCell as ch
	 * 
	 * @param ch type char. the content to provide in currentCell
	 */
	public void setContent(char ch) { // setContent() begin
		
		currentCell.content = ch;
		
	} // setContent() end



	/**
	 * moves the currentCell one position to the left
	 * 
	 */
	public void moveLeft() { // moveLeft() begin
		
		if(currentCell.prev == null) { // there's no left cell
			Cell newCell = new Cell();
			newCell.content = ' ';
			
			currentCell.prev = newCell; 
			newCell.next = currentCell; 
			newCell.prev = null;        
		}
		
		// moving the pointer one position left
		currentCell = currentCell.prev; 

	} // moveLeft() end



	/**
	 * moves the currentCell one position to the right
	 * 
	 */
	public void moveRight() { // moveRight() begin
		
		if(currentCell.next == null) { // there's no right cell
			Cell newCell = new Cell();
			newCell.content = ' ';
			
			currentCell.next = newCell;
			newCell.prev = currentCell;
			newCell.next = null;
		}
		
		// moving the pointer one position right
		currentCell = currentCell.next;
		
	} // moveRight() end


	/**
	 * reads the tape cells and returns the whole string.
	 * reads from the left to the right.
	 * 
	 * @return String representation of the whole tape
	 */
	public String getTapeContents() { // getTapeContents() begin
		String tapeContents = ""; //string to be returned
		Cell readPointer = currentCell; //another pointer to read
		
		// getting the pointer to the most left
		while(readPointer.prev != null) { 
			readPointer = readPointer.prev;
		}

		while(readPointer != null) { // reading and writing the tape

			tapeContents += readPointer.content;
			readPointer = readPointer.next;

		}

		return tapeContents;
	} // getTapeContents() end

} // Tape class end
